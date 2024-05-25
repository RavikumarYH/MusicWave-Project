package com.example.Musicwave.Service;

import org.springframework.stereotype.Service;

import com.example.Musicwave.Entity.User;

@Service
public interface UserService {

	boolean emailExists(User user);

	void saveUser(User user);

	boolean validUser(String email, String password);

	String getRole(String email);

	User getUser(String email);

	void updateUser(User user);

}
