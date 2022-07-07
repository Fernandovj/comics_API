package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<User> getUsers(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public User setUser(User user) {
		return userRepository.save(user);
	}

}
