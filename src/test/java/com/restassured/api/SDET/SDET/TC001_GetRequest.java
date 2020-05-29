package com.restassured.api.SDET.SDET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetRequest {
	
	@Test
	public void getDetails(){
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpResuest=RestAssured.given();
		
		Response response=httpResuest.request(Method.GET,"/Chennai");
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		
		int statusCode=response.statusCode();
		
		System.out.println(statusCode);
		
	}

}
