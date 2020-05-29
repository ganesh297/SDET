package cucumber.API;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC1_GetCookies {

	@Test//TL
	public void getHeaders(){
		RestAssured.baseURI="https://gorest.co.in/public-api";

		Response response=RestAssured.given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when().get("/users");

		Map<String,String> cookieMap=response.getCookies();
		for(Map.Entry<String, String> cookieValue :cookieMap.entrySet()){

			System.out.println(cookieValue.getKey()+"   "+cookieValue.getValue());

		}
		
		Cookie cookie=response.getDetailedCookie("_csrf");
		
		System.out.println(cookie.getExpiryDate());
		
		System.out.println(cookie.hasExpiryDate());
		
		System.out.println(cookie.hasDomain());
		
	}



}
