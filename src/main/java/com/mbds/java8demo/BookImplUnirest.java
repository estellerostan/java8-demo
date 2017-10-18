package com.mbds.java8demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class BookImplUnirest {
	
	  private static final String URI_BOOK = "http://localhost:8080/bibliothequelivreservice/api/livre/";

	 public BookImplUnirest() {
		    Unirest.setObjectMapper(new ObjectMapper() {
		      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper =
		          new com.fasterxml.jackson.databind.ObjectMapper();
		 
		      public <T> T readValue(String value, Class<T> valueType) {
		        try {
		          return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		          throw new RuntimeException(e);
		        }
		      }
		 
		      public String writeValue(Object value) {
		        try {
		          return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		          throw new RuntimeException(e);
		        }
		      }
		    });
		  }
	  
	  public Book getBook(int id) throws UnirestException  {
	    HttpResponse<Book> response = Unirest.get(URI_BOOK + String.valueOf(id)).header("accept", "application/json").asObject(Book.class);
	    Book book = response.getBody();
	    return book;
	  }
	  		
	  public Book[] getAllBooks() throws UnirestException  {
		    HttpResponse<Book[]> response = Unirest.get(URI_BOOK).asObject(Book[].class);
		    Book[] books = response.getBody();
		    return books;
		  }
	  
	  public List<Book> getBooks() throws UnirestException  {
		    HttpResponse<Book[]> response = Unirest.get(URI_BOOK).asObject(Book[].class);
		    Book[] books = response.getBody();
		    return new ArrayList<Book>(Arrays.asList(books)); 
		  }
}