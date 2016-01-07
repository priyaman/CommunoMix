package com.priyaman.communomixclient.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Logger;
import com.priyaman.communomixclient.R;
import com.priyaman.communomixclient.globals.GlobalConstants;
import com.priyaman.communomixclient.globals.StaticGlobals;

import java.util.HashMap;
import java.util.Map;

public class CreateUserActivity extends AppCompatActivity {

    Button mCreateUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Firebase Registration
        Firebase.setAndroidContext(this);
        if(StaticGlobals.mFirebaseRef==null)
            StaticGlobals.mFirebaseRef = new Firebase(GlobalConstants.FIREBASE_LINK);

        //Handle Button Click
        this.mCreateUserButton  = (Button)findViewById(R.id.buttonCreate);
        this.mCreateUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
                String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
                StaticGlobals.mFirebaseRef.createUser(userName, password, new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        // user was created
                        Toast.makeText(getApplicationContext(), "Pass",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error]
                        Toast.makeText(getApplicationContext(), "Fail",
                                Toast.LENGTH_LONG).show();
                        Log.i("Firebase Fail", "Unable to connect to ref");
                    }
                });
                StaticGlobals.mFirebaseRef.authWithPassword(((EditText) findViewById(R.id.editTextEmail)).getText().toString(),
                        ((EditText) findViewById(R.id.editTextPassword)).getText().toString(),
                        new Firebase.AuthResultHandler() {
                            @Override
                            public void onAuthenticated(AuthData authData) {
                                // Authentication just completed successfully :)
                                Map<String, String> map = new HashMap<String, String>();
                                map.put(GlobalConstants.USER_ID, authData.getUid());
                                map.put(GlobalConstants.USER_NAME, ((EditText) findViewById(R.id.editTextName)).getText().toString());
                                map.put(GlobalConstants.USER_NICK, ((EditText) findViewById(R.id.editTextNickname)).getText().toString());
                                map.put(GlobalConstants.USER_PASS, ((EditText) findViewById(R.id.editTextPassword)).getText().toString());
                                map.put(GlobalConstants.USER_TYPE, GlobalConstants.NORMAL_USER);
                                StaticGlobals.mFirebaseRef.child(GlobalConstants.USERS_TABLE)
                                        .child(authData.getUid()).setValue(map);
                            }

                            @Override
                            public void onAuthenticationError(FirebaseError error) {
                                Log.e("Firebase Login Err", "FirebaseLoginError");
                            }
                        });
            }
        });

    }

}
