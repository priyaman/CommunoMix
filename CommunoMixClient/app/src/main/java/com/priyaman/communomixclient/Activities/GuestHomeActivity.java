package com.priyaman.communomixclient.Activities;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.priyaman.communomixclient.R;
import com.priyaman.communomixclient.adapters.SongListAdapter;
import com.priyaman.communomixclient.databeans.SongBean;
import com.priyaman.communomixclient.globals.GlobalConstants;
import com.priyaman.communomixclient.globals.StaticGlobals;

public class GuestHomeActivity extends ListActivity {
    private ListAdapter mChatListAdapter;
    private ValueEventListener mConnectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_home);

        // Setup our input methods. Enter key on the keyboard or pushing the send button
        EditText inputText = (EditText) findViewById(R.id.messageInputSong);

        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_NULL && keyEvent.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    sendMessage();
                }
                return true;
            }
        });

        EditText inputText2 = (EditText) findViewById(R.id.messageInputArtist);

        inputText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_NULL && keyEvent.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    sendMessage();
                }
                return true;
            }
        });

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendMessage();
        }
    });
}

    @Override
    public void onStart() {
        super.onStart();
        while(StaticGlobals.currParty == null){

        }
        //Set Party Name
        ((TextView)findViewById(R.id.partyIdHeader)).setText(getResources().getString(R.string.welcome_banner) +
                StaticGlobals.currParty.getPartyName());
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        mChatListAdapter = new SongListAdapter(StaticGlobals.mFirebaseRef.child(GlobalConstants.PARTY_TABLE).child(StaticGlobals.currParty.getPartyId()).child(GlobalConstants.PARTY_PLAYLIST),
                SongBean.class, R.layout.song_message,this);
        listView.setAdapter(mChatListAdapter);
        mChatListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(mChatListAdapter.getCount() - 1);
            }
        });

        // Finally, a little indication of connection status
        mConnectedListener = StaticGlobals.mFirebaseRef.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean connected = (Boolean) dataSnapshot.getValue();
                if (connected) {
                    Toast.makeText(GuestHomeActivity.this, "Connected to Firebase", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GuestHomeActivity.this, "Disconnected from Firebase", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                // No-op
            }
        });
    }

    private void sendMessage() {
        EditText inputTextSong = (EditText) findViewById(R.id.messageInputSong);
        EditText inputTextArtist = (EditText) findViewById(R.id.messageInputArtist);

        String artist = inputTextArtist.getText().toString();
        String songName = inputTextSong.getText().toString();
        if(!artist.equals("") && !songName.equals(""))
        {
            // Create our 'model', a Chat object
            SongBean song = new SongBean(songName, artist, StaticGlobals.currUser.getUid(), StaticGlobals.currUser.getNickName());

            // Create a new, auto-generated child of that chat location, and save our chat data there
            StaticGlobals.mFirebaseRef.child(GlobalConstants.PARTY_TABLE).child(StaticGlobals.currParty.getPartyId()).child(GlobalConstants.PARTY_PLAYLIST).push().setValue(song);
            inputTextArtist.setText("");
            inputTextSong.setText("");
        }
    }

}
