package com.frizafad.stringproject.service;

import java.util.List;

import com.frizafad.stringproject.model.Songdata;

public interface SongService {
    public List<Songdata> getAllSong();
    public Songdata getSongdata(Integer id);
    public Songdata saveSongdata(Songdata songdata);
    public Songdata updateSongdata(Songdata songdata);
    public Songdata deleteSongdata(Songdata songdata);
}
