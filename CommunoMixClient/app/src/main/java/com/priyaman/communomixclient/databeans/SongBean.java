package com.priyaman.communomixclient.databeans;

/**
 * Created by priya_000 on 1/6/2016.
 */
public class SongBean {
    private String songName;
    private String suggestedByNick;
    private boolean beenPlayed;
    private String artist;
    private String suggestedById;

    public SongBean(){

    }

    public SongBean(String songName, String artist, String suggestedById, String suggestedByNick){
        this.songName = songName;
        this.artist = artist;
        this.suggestedById = suggestedById;
        this.suggestedByNick = suggestedByNick;
        this.beenPlayed = false;

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



    public String getSuggestedByNick() {
        return suggestedByNick;
    }

    public void setSuggestedByNick(String suggestedByNick) {
        this.suggestedByNick = suggestedByNick;
    }








    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSuggestedById() {
        return suggestedById;
    }

    public void setSuggestedById(String suggestedById) {
        this.suggestedById = suggestedById;
    }

    public boolean isBeenPlayed() {
        return beenPlayed;
    }

    public void setBeenPlayed(boolean beenPlayed) {
        this.beenPlayed = beenPlayed;
    }
}
