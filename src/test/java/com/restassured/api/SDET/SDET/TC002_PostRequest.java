package com.restassured.api.SDET.SDET;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PostRequest {
	
	@Test
	public void getDetails(){
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RequestSpecification httpResuest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("FirstName", "Ganesh");
		requestParams.put("LastName", "M");
		
		httpResuest.header("Content-Type","application/json");
		httpResuest.body(requestParams.toJSONString());
			
		Response response=httpResuest.request(Method.POST,"/register");
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		
		int statusCode=response.statusCode();
		
		System.out.println(statusCode);
		
		String s=response.jsonPath().get("SuccessCode");
		
	}

}
