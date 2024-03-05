package com.kodnest.tunehub.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongRepository songRepository;
	
	@Override
	public String addSong(Song song) {
		songRepository.save(song);
		return "song added successfully";
	}
}