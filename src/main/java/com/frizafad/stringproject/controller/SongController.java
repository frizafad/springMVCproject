package com.frizafad.stringproject.controller;

import com.frizafad.stringproject.model.Songdata;
import com.frizafad.stringproject.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;


@Controller
public class SongController {
    
    @Autowired
    SongService service;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("songdatas", service.getAllSong());
        return "index";
    }

    @RequestMapping(value = "tambah",method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("songdata", new Songdata());
        return "tambah";
    }

    @RequestMapping(value = "tambah",method = RequestMethod.POST)
    public String adding(@ModelAttribute("songdata") Songdata songdata) {
        service.saveSongdata(songdata);
        return "redirect:/";
    }

    @RequestMapping(value = "edit/id",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable("id")Integer id) throws NotFoundException {
        Songdata song = service.getSongdata(id);
        if (song==null) {
            throw new NotFoundException("Data Not Found Bro");
        }
        model.addAttribute("songdata", song);
        return "edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String editing(@ModelAttribute("songdata")Songdata songdata) {
        service.updateSongdata(songdata);
        return "redirect:/";
    }

    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String deleting(@PathVariable("id")Integer id) throws NotFoundException {
        Songdata song = service.getSongdata(id);
        if (song == null) {
           throw new NotFoundException("Data Not Found");
        }
        service.deleteSongdata(song);
        return "redirect:/";
    }
    
    
}
