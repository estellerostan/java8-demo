package com.mbds.java8demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LibraryBookClient {

	public static void main(String[] args) throws UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/bibliothequelivreservice/api/livre/1")
				.header("accept", "application/json")
				.asJson();
		
		System.out.println(jsonResponse.getStatus());
	}

}
