package com.priyaman.communomixclient.globals;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by priya_000 on 12/30/2015.
 */
public class GlobalConstants {

    //Firebase Constants
    public static final String  FIREBASE_LINK = "https://communomix1.firebaseio.com/";
    //Auth Constants
    public static final String SERVER_URL = "http://10.0.2.2:8080/CommunoMixServer";
    public static final String AUTH_SERVICE = SERVER_URL + "/auth/userAuth";
    public static final String TAG = "AndroidRESTClientActivity";
    public static final String AUTH_FAIL = "{\"uid\":\"xxxFAIL_AUTHxxx\"}";

    public static final String PARAM_DELIM = "&";
    public static final String PARAM_EQUAL = "=";
    public static final String PARAM_SLASH = "/";

    //User Constants
    public static final String USER_ID = "uid";
    public static final String USER_NAME = "name";
    public static final String USER_NICK = "nickName";
    public static final String USER_PASS = "password";
    public static final String USER_TYPE = "userType";

    public static final String USERS_TABLE = "users_table";
    public static final String PARTY_TABLE = "party_table";

    //Party COnstants
    public static final String UNINIT_PARTY_ID = "xxxxxUNINIT_PARTYxxxx";
    //Intents Map
    public static final String NORMAL_USER = "N";
    public static final Map<String, Class> intentsMap;
    static
    {
        HashMap<String, Class> myMap = new HashMap<String, Class>();
        myMap.put("S", com.priyaman.communomixclient.Activities.HostHomeActivity.class);
        myMap.put("N", com.priyaman.communomixclient.Activities.UserHomeActivity.class);
        intentsMap = Collections.unmodifiableMap(myMap);
    }

}
