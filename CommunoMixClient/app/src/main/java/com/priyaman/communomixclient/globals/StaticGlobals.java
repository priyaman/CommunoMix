package com.priyaman.communomixclient.globals;

import com.firebase.client.Firebase;
import com.priyaman.communomixclient.databeans.PartyBean;
import com.priyaman.communomixclient.databeans.UserData;

/**
 * Created by priya_000 on 1/2/2016.
 */
public class StaticGlobals {

    public static Firebase mFirebaseRef;
    public static UserData currUser;
    public static boolean isUserSet = false;
    public static boolean firebaseWait = false;
    public static PartyBean currParty;
    public static UserData currSongSuggestor;

}
