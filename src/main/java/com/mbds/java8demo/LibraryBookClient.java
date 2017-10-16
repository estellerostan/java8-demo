package com.mbds.java8demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class LibraryBookClient {

	public static void main(String[] args) throws Exception {
		HttpResponse<JsonNode> getResponse = Unirest.get("http://localhost:8080/bibliothequelivreservice/api/livre/1")
				.header("accept", "application/json")
				.asJson();

		System.out.println(getResponse.getBody());

		System.out.println(new BookImplUnirest().getBook());
	}
}
