package com.frizafad.stringproject.dao;

import com.frizafad.stringproject.model.Songdata;

import java.util.List;

public interface SongDao {
    public List<Songdata> getAllSong();
    public Songdata getSongdata(Integer id);
    public Songdata saveSongdata(Songdata songdata);
    public Songdata updateSongdata(Songdata songdata);
    public Songdata deleteSongdata(Songdata songdata);

}
