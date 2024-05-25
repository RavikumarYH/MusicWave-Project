package com.example.Musicwave.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Musicwave.Entity.Song;

@Service
public interface SongService {

	boolean songExists(String name);

	void savesong(Song song);

	List<Song> fetchAllSongs();

	List<Song> fetchAllsongs();

}
