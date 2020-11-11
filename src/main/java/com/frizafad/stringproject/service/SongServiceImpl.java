package com.frizafad.stringproject.service;

import java.util.List;

import com.frizafad.stringproject.dao.SongDao;
import com.frizafad.stringproject.model.Songdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SongServiceImpl implements SongService {
    
    @Autowired
    SongDao songDao;

    @Override
    public List<Songdata> getAllSong() {
        return songDao.getAllSong();
    }

    @Override
    public Songdata getSongdata(Integer id) {
        return songDao.getSongdata(id);
    }

    @Override
    public Songdata saveSongdata(Songdata songdata) {
        return songDao.saveSongdata(songdata);
    }

    @Override
    public Songdata updateSongdata(Songdata songdata) {
        return songDao.updateSongdata(songdata);
    }

    @Override
    public Songdata deleteSongdata(Songdata songdata) {
        return songDao.deleteSongdata(songdata);
    }
    
}
