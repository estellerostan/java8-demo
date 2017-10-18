package com.mbds.java8demo;

import java.util.Date;

public class Book {
	private Long id;
	private String name;
	private String author;
	private Date publicationDate;
	private String isbn;
	private Library library;

	public Book() {
		super();
	}

	public Book(Long id, String nom, String auteur, Date dateParution, String isbn) {
		super();
		this.id = id;
		this.name = nom;
		this.author = auteur;
		this.publicationDate = dateParution;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String nom) {
		this.name = nom;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuteur(String auteur) {
		this.author = auteur;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setDateParution(Date dateParution) {
		this.publicationDate = dateParution;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn =isbn;
	}
	
	public Library getLibrary() {
		return library;
	}

	public void setBibliotheque(Library library) {
		this.library = library;
	}
}