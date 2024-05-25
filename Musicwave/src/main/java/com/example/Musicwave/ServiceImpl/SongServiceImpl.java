package com.example.Musicwave.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Musicwave.Entity.Song;
import com.example.Musicwave.Repository.SongRepository;
import com.example.Musicwave.Service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository sr;
	
	@Override
	public boolean songExists(String name) {
		// TODO Auto-generated method stub
		Song song = sr.findByName(name);
		if(song==null) {
			return false;
		}
		else
		{
			return true;
		}
			
	}

	@Override
	public void savesong(Song song) {
		// TODO Auto-generated method stub
		sr.save(song);
	}

	@Override
	public List<Song> fetchAllSongs() {
		// TODO Auto-generated method stub
		List<Song> songs= sr.findAll();
		return songs;
	}

	@Override
	public List<Song> fetchAllsongs() {
		// TODO Auto-generated method stub
		List<Song> songs= sr.findAll();
		return songs;
	}
}
