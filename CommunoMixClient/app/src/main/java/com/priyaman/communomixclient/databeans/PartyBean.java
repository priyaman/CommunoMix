package com.priyaman.communomixclient.databeans;

import com.priyaman.communomixclient.globals.GlobalConstants;

import java.util.List;

/**
 * Created by priya_000 on 1/5/2016.
 */
public class PartyBean {

    private String partyId;
    private String partyName;
    private int maxGuests;
    private List<String> allowedGenres;

    public PartyBean(){

    }

    public PartyBean(String partyName, String maxGuests, List<String> allowedGenres){
        this.partyId = GlobalConstants.UNINIT_PARTY_ID;
        this.partyName = partyName;
        this.maxGuests = Integer.parseInt(maxGuests);
        this.allowedGenres = allowedGenres;
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
