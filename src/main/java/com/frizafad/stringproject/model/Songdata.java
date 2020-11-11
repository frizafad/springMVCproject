package com.frizafad.stringproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author frizafad
 */
@Entity
@Table(name = "SONGDATA")
public class Songdata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String writer;
    private String singer;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getWriter() {
        return writer;
    }
 
    public void setWriter(String writer) {
        this.writer = writer;
    }
 
    public String getSinger() {
        return singer;
    }
 
    public void setSinger(String singer) {
        this.singer = singer;
    }   
}