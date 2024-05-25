package com.example.Musicwave.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Musicwave.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);

}
