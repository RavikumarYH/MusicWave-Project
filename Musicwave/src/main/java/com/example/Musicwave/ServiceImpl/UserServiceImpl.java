package com.example.Musicwave.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Musicwave.Entity.User;
import com.example.Musicwave.Repository.UserRepository;
import com.example.Musicwave.Service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	
	@Autowired
	UserRepository ur;
	
	@Override
	public boolean emailExists(User user) {
		// TODO Auto-generated method stub
		User existinguser=ur.findByEmail(user.getEmail());
		
		if(existinguser!=null) {
			System.out.println("Present");
			return true;
		}
		else
		{
			System.out.println("Absent");
			return false;
		}
	}
		

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
	ur.save(user);	
	}
	
	

	@Override
	public boolean validUser(String email, String password) {
		// TODO Auto-generated method stub
User user=ur.findByEmail(email);
		
		String dbpwd = user.getPassword();
		
		if(password.equals(dbpwd)) {
			return true;
		}
		else 
		{
			return false; 
		}
		
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		User user = ur.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return ur.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ur.save(user);
	}

}
