package com.priyaman.communomixclient.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.priyaman.communomixclient.R;
import com.priyaman.communomixclient.databeans.SongBean;
import com.priyaman.communomixclient.databeans.UserData;
import com.priyaman.communomixclient.globals.GlobalConstants;
import com.priyaman.communomixclient.globals.StaticGlobals;

/**
 * Created by priya_000 on 1/6/2016.
 */
public class SongListAdapter extends FirebaseListAdapter<SongBean> {


    /**
     * @param mRef        The Firebase location to watch for data changes. Can also be a slice of a location, using some
     *                    combination of <code>limit()</code>, <code>startAt()</code>, and <code>endAt()</code>,
     * @param mModelClass Firebase will marshall the data at a location into an instance of a class that you provide
     * @param mLayout     This is the mLayout used to represent a single list item. You will be responsible for populating an
     *                    instance of the corresponding view with the data from an instance of mModelClass.
     * @param activity    The activity containing the ListView
     *
     */

    private UserData suggestedByUser;
    public SongListAdapter(Query mRef, Class<SongBean> mModelClass, int mLayout, Activity activity) {
        super(mRef, mModelClass, mLayout, activity);
    }

    @Override
    protected void populateView(View view, SongBean model) {
        // Map a Chat object to an entry in our listview
        final String suggestorId = model.getSuggestedByNick();

        TextView authorText = (TextView) view.findViewById(R.id.suggestedBy);
        //authorText.setText(suggestedByUser.getNickName() + ": ");
        authorText.setText(suggestorId + ": ");
        // If the message was sent by this user, color it differently
        if (suggestorId != null && suggestorId.equals(StaticGlobals.currUser. getNickName())) {
            authorText.setTextColor(Color.RED);
        } else {
            authorText.setTextColor(Color.BLUE);
        }
        ((TextView) view.findViewById(R.id.songName)).setText(model.getSongName());
        ((TextView) view.findViewById(R.id.songArtist)).setText(model.getArtist());
    }
}
