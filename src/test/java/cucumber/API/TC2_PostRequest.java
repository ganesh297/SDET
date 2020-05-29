package cucumber.API;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class TC2_PostRequest {
	
	
	 String id;
	@Test(priority=1)
	public void post1Map(){		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("first_name","Ganesh");
		map.put("last_name","M");
		map.put("gender","male");
		map.put("email","gans1436Peter27@roberts.com");
		map.put("status","active");

		RestAssured.baseURI="https://gorest.co.in";
		
	Response response=given().contentType(ContentType.JSON)	
			.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3").body(map)
		.when().post("/public-api/users")
		.then().extract().response();
		
	//response.prettyPrint();
	
id=response.jsonPath().get("result.id").toString();
	
		System.out.println(id);
		}

	
	
	//AFTER ADDING GETTING THAT DATA
	
	@Test(priority=2) //SDET
	public void getEmployee()
	{
		
		System.out.println("https://gorest.co.in/public-api/users/"+id);
		Response response=	given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when()
				
				.get("https://gorest.co.in/public-api/users/"+id)
				.then()
				.extract().response();

			System.out.println("Firts Name: "+response.path("result.first_name"));
		}




	
	
	
	
	
	//@Test
	public void post1File(){		
		File jsonData=new File("C:\\Users\\Sri\\workspace\\RestAssuredPractice\\data1.json");
		
		RestAssured.baseURI="https://gorest.co.in";
		
		given().contentType(ContentType.JSON)	
			.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3").body(jsonData)
		.when().post("/public-api/users")
		.then().log().all().statusCode(200);
		}





}
