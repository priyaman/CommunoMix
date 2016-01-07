package com.priyaman.communomixclient.databeans;

import android.util.Log;

import com.firebase.client.AuthData;
import com.priyaman.communomixclient.globals.GlobalConstants;

import org.json.JSONObject;

/**
 * Created by priya_000 on 1/2/2016.
 */
public class UserData {
    //Data Fields
    private String uid;
    private String name;
    private String nickName;
    private String userType;
    private String password;

    //Constructor
    public UserData(){
        super();
        this.uid = GlobalConstants.AUTH_FAIL;
    }

    public UserData(String jsonResponse){
        super();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            this.uid = jsonObject.getString(GlobalConstants.USER_ID);
            this.name = jsonObject.getString(GlobalConstants.USER_NAME);
            this.nickName = jsonObject.getString(GlobalConstants.USER_NICK);
            this.password = jsonObject.getString(GlobalConstants.USER_PASS);
            this.userType = jsonObject.getString(GlobalConstants.USER_TYPE);
        }catch (Exception e){
            Log.e("USER_PARSE_ERR", "Malformed JSON");
        }

    }

    public UserData(AuthData authData){
        this.uid = authData.getUid();
        this.name = (String)authData.getProviderData().get(GlobalConstants.USER_NAME);
        this.name = (String)authData.getProviderData().get(GlobalConstants.USER_NICK);
        this.name = (String)authData.getProviderData().get(GlobalConstants.USER_PASS);
        this.name = (String)authData.getProviderData().get(GlobalConstants.USER_TYPE);
    }
    public UserData(String uid, String name, String nickName, String userType,
                    String password) {
        super();
        this.uid = uid;
        this.name = name;
        this.nickName = nickName;
        this.userType = userType;
        this.password = password;
    }

    //Getter Setters

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
