package com.frizafad.stringproject.dao;

import java.util.List;

import com.frizafad.stringproject.model.Songdata;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongDaoImpl implements SongDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Songdata> getAllSong() {
        return sessionFactory.getCurrentSession().createQuery("from Songdata").list();
    }

    @Override
    public Songdata getSongdata(Integer id) {
        return (Songdata) sessionFactory.getCurrentSession().get(Songdata.class, id);
    }

    @Override
    public Songdata saveSongdata(Songdata songdata) {
        sessionFactory.getCurrentSession().save(songdata);
        return songdata;
    }

    @Override
    public Songdata updateSongdata(Songdata songdata) {
        sessionFactory.getCurrentSession().update(songdata);
        return songdata;
    }

    @Override
    public Songdata deleteSongdata(Songdata songdata) {
        sessionFactory.getCurrentSession().delete(songdata);
        return songdata;
    }
    
}
