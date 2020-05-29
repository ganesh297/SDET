package cucumber.API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC3_PutRequest {

	@Test
	public void updateRecord(){
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("first_name","Ganesh12");
		map.put("last_name","M");
		map.put("gender","male");
		map.put("email","ganesh123@roberts.com");
		map.put("status","active");

		
		RestAssured.baseURI="https://gorest.co.in";
		
		given().contentType(ContentType.JSON)	
			.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3").body(map)
		.when().put("/public-api/users/24916")
		.then().log().all().statusCode(200);
		}

	}
	

