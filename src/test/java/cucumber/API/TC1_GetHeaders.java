package cucumber.API;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC1_GetHeaders {
	
	@Test//TL
		public void getHeaders(){
			RestAssured.baseURI="https://gorest.co.in/public-api";
			
			Response response=RestAssured.given()
					.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
					.when().get("/users");
					
			Headers headers=response.getHeaders();
			for(Header h:headers){
				System.out.println(h.getName()+"  "+h.getValue());
				
			}

			
}
}