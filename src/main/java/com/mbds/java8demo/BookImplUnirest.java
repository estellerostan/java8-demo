package com.mbds.java8demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class BookImplUnirest {

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
	 
	  private static final String URI_BOOK = "http://localhost:8080/bibliothequelivreservice/api/livre/1";
	  
	  public Book getBook() throws Exception {
	    HttpResponse<Book> response = Unirest.get(URI_BOOK).asObject(Book.class);
	    Book book = response.getBody();
	    return book;
	  }
}