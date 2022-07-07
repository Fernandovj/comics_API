package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/listusers")
	public ResponseEntity<ArrayList<User>> getUsers(){
		//return userService.getUsers();
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
		
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<Object> setUser(@Valid @RequestBody User user) {
		//return this.userService.setUser(user);
		try {
			return new ResponseEntity<>(this.userService.setUser(user), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("+");
			Map<String,String> errors = new HashMap<>();				
			String fieldName = "message";
			String message = "Sorry, unable to save possibly due to duplicated CPF or email";
			errors.put(fieldName, message);
	
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
			
		}
	}
	


}
