package com.example.demo.models;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "comic")
public class Comic {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false)
	private int id;
	@Column(name="title",nullable=false)
	private String title;
	@Column(nullable=false)
	private float cost;
	@Column(nullable=false)
	private String authors;
	@Column(unique=true,nullable=false)
	private String isbn;
	private String description;
	@ManyToMany(mappedBy="readingComics")
	@JsonIgnore
	private List<User> readers;
	
	public Comic() {
		// TODO Auto-generated constructor stub
	}

	public Comic(int id, String title, float cost, String authors, String isbn, String description,
			List<User> readers) {
		super();
		this.id = id;
		this.title = title;
		this.cost = cost;
		this.authors = authors;
		this.isbn = isbn;
		this.description = description;
		this.readers = readers;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<User> getReaders() {
		return readers;
	}
	
	public void setReaders(List<User> readers) {
		this.readers = readers;
	}
	
	
	
}
