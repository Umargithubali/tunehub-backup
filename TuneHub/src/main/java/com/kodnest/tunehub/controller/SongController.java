package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller 
class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
		songService.addSong(song);
		return "NewSong";
	}
}