package com.example.Musicwave.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Musicwave.Entity.Song;
import com.example.Musicwave.Entity.User;
import com.example.Musicwave.Service.SongService;
import com.example.Musicwave.Service.UserService;
import com.example.Musicwave.ServiceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService us;
	
	@Autowired
	UserServiceImpl usimpl;
	
	@Autowired
	SongService ss; 

	@PostMapping("/Register")
	
	public String addUser(@ModelAttribute User user)
	{
		//To Check a user with a mail is present or not 
		boolean userExists = us.emailExists(user);
		
		if(userExists==false) 
		{
			us.saveUser( user);
			System.out.println("user Added Successfully");
		}
		else 
		{
			System.out.println("Duplicate user!! try to log in");
		}
		
		return "Login";
		
	}
	
	@PostMapping("/validate")
	
	public String ValidateUser(@RequestParam("email")String email , 
				@RequestParam("password") String password, HttpSession session, Model model)
	{
		
		if(us.validUser(email, password)==true)
		{
			session.setAttribute("email", email);
			
			
			String role =us.getRole(email);
			
			if(role.equals("admin"))
			{
				return "AdminHome";			
			}
			else
			{
				User user=us.getUser(email);
				boolean userstatus=user.isIspremium();
				List<Song> fetchAllsongs=ss.fetchAllsongs();
				model.addAttribute("songs", fetchAllsongs);
				
				model.addAttribute("ispremium", userstatus);
			
				return "CustomerHome";	
			}
		}
			else
			{
				return "Login";
			}
			
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate() ;
		return "Login";
		
	}

}
