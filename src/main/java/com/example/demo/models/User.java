package com.example.demo.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;



import com.example.demo.services.DoB;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false)
	private int id;
	
	@Column(name="name",nullable=false)
	@NotBlank(message = "Name cannot be empty or null")
	@NotEmpty(message = "Name cannot be empty or null")
	private String name;
	
	@Column(unique=true,nullable=false)
	@NotEmpty(message = "Email cannot be empty or null")
	@Email(message= "Type a valid email address")
	private String email;
	
	@Column(unique=true,nullable=false)
	@NotEmpty(message = "CPF cannot be empty or null")
	@Size(min=11,max=11, message = "Type a valid CPF")
	private String cpf;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")	
	//@Past(message="Type a valid date of birth")
	@DoB(message = "Type a valid date of birth or follow the format: dd/mm/yyy")
	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$", message = "Please, type a date in the following format: dd/mm/yyyy")
	@Column(nullable=false)
	@NotNull(message = "Date of birth cannot be null")
	private String dob; //date of birth
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(
			name="reading_comics",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="comic_id")
	)
	private List<Comic> readingComics;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(int id, String name, String email, String cpf, String dob, List<Comic> readingComics) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dob = dob;
		this.readingComics = readingComics;
	}

	public void readComic(Comic comic) {
		readingComics.add(comic);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public List<Comic> getReadingComics() {
		return readingComics;
	}
	
	public void setReadingComics(List<Comic> readingComics) {
		this.readingComics = readingComics;
	}
	
	
}
