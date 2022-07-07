package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Comic;

@Repository
public interface ComicRepository extends CrudRepository<Comic, Integer>{

}
