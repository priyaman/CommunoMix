package com.priyaman.communomixclient.databeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.priyaman.communomixclient.globals.GlobalConstants;
import com.priyaman.communomixclient.globals.StaticGlobals;

import java.util.List;
import java.util.UUID;

/**
 * Created by priya_000 on 1/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PartyBean {

    private String partyId;
    private String hostId;
    private String partyName;
    private int maxGuests;
    private List<String> allowedGenres;
    private List<SongBean> partyPlayList;

    public PartyBean(){

    }

    public PartyBean(String partyName, String maxGuests, List<String> allowedGenres){
        this.partyId = GlobalConstants.UNINIT_PARTY_ID;
        this.hostId = StaticGlobals.currUser.getUid();
        this.partyName = partyName;
        this.maxGuests = Integer.parseInt(maxGuests);
        this.allowedGenres = allowedGenres;
    }

    public PartyBean(String partyId, String partyName, String maxGuests, List<String> allowedGenres, List<SongBean> partyPlayList){
        this.partyId = partyId;
        this.hostId = StaticGlobals.currUser.getUid();
        this.partyName = partyName;
        this.maxGuests = Integer.parseInt(maxGuests);
        this.allowedGenres = allowedGenres;
        this.partyPlayList = partyPlayList;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public List<String> getAllowedGenres() {
        return allowedGenres;
    }

    public void setAllowedGenres(List<String> allowedGenres) {
        this.allowedGenres = allowedGenres;
    }
}
