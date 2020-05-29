package cucumber.API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC4_PatchRequest {

	
	@Test
	public void updateRecord(){
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("first_name","Peter");
		map.put("last_name","M");
		map.put("gender","male");
		map.put("email","ganesh1823@roberts.com");
		map.put("status","active");

		
		RestAssured.baseURI="https://gorest.co.in";
		Response response=
		given().contentType(ContentType.JSON)	
			.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3").body(map)
		.when().patch("/public-api/users/24916")
		.then().log().all().statusCode(200).extract().response();
		
		String name=response.path("result.first_name");
		System.out.println(name);
		}

}
