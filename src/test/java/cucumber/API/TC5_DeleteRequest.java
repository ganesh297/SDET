package cucumber.API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC5_DeleteRequest {
	
	@Test
	public void deleteRecord(){
		
		
		
		RestAssured.baseURI="https://gorest.co.in";
		
		given().contentType(ContentType.JSON)	
			.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
		.when().delete("/public-api/users/25085")
		.then().log().all().statusCode(200);
		}


}
