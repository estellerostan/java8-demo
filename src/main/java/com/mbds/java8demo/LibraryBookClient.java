package com.mbds.java8demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mashape.unirest.http.exceptions.UnirestException;

public class LibraryBookClient {

	public static void main(String[] args) throws UnirestException {
		BookImplUnirest restBook = new BookImplUnirest();
		
		// array as a source of the stream
		Book[] books = restBook.getAllBooks();
		
		List<Book> b = restBook.getBooks();
		
		// all the books titles written by Victor Hugo
		List<String> victorHugoBooks = Arrays.stream(books).
				filter(it -> it.getAuthor().equals("Victor Hugo"))
				.map(it -> it.getNom())
				.collect(Collectors.toList());
		
		// all the books titles that start with the letter D
		List<String> dBooks = b.stream()
				.map(Book::getNom)
				.filter(nom -> nom.startsWith("D"))
				.collect(Collectors.toList());

		System.out.println(Arrays.toString(books));
		System.out.println(b);
		
		System.out.println(victorHugoBooks);
		System.out.println(dBooks);	
	}
}
