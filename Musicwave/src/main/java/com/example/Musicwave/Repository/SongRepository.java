package com.example.Musicwave.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Musicwave.Entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	Song findByName(String name);

}
