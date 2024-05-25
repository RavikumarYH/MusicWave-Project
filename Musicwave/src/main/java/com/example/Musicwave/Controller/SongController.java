package com.example.Musicwave.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Musicwave.Entity.Song;
import com.example.Musicwave.Service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService ss;
	
	@PostMapping("/addsongs")
	public String addsong(@ModelAttribute Song song )
	{
		
		String name= song.getName();
		
		boolean songExists = ss.songExists(name);
		
		if(songExists==false) 
		{
			ss.savesong(song);
		}
		else 
		{
			System.out.println("Duplicate Entry");
		}
		return "AdminHome";
	}
	
	@GetMapping("/playsongs")
	public String playsong(Model model)
	{
		boolean premium = false;
		
		if(premium)
		{
			List<Song> songsList= ss.fetchAllSongs();
			model.addAttribute("songs", songsList);	
			return "viewsongs";
	}
	else
	{
			return "pay";
	}
		
	}
	
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) 
	{
		List<Song> songsList= ss.fetchAllSongs();
		model.addAttribute("songs", songsList);	
		return "viewsongs";
		
	}
	
	
}
