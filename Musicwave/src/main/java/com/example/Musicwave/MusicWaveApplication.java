package com.example.Musicwave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class MusicWaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicWaveApplication.class, args);
		
	}

}
