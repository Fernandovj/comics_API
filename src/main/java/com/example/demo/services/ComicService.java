package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Comic;
import com.example.demo.repositories.ComicRepository;


@Service
public class ComicService {
	@Autowired
	ComicRepository comicRepository;
	
	public ArrayList<Comic> getComics(){
		return (ArrayList<Comic>) comicRepository.findAll();
	}
	
	public Comic setComic(Comic comic) {
		return comicRepository.save(comic);
	}

}
