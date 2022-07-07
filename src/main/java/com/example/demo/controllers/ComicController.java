package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Comic;
import com.example.demo.services.ComicService;


@RestController
@RequestMapping("/api")
public class ComicController {
	
	@Autowired
	ComicService comicService;
	
	@GetMapping("/comics")
	public ArrayList<Comic> getComics(){
		return comicService.getComics();		
	}
	
	@PostMapping("/comics")
	public Comic setComic(@RequestBody Comic comic) {
		return this.comicService.setComic(comic);
	}

}
