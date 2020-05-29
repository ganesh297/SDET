package cucumber.API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;




/*
given()
	set cookies, add auth, add param, set headers info etc....
when()
	get, post,put,delete...	

then()
	validate status code, extract response, extract headers cookies & response body....
 */
public class TC1_GETRequest1 {

	//@Test //SDET
	public void getWeatherDetails()
	{
		given()
		.when()
		.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("City", equalTo("Hyderabad"))
		.header("Content-Type","application/json");

	}


	//@Test//TL--Error
	public void getWeather(){
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

		Response response=RestAssured.given()				
				.when().get("/Hyderabad");

		JsonPath jsonResponse=response.jsonPath();

		List<String> names=jsonResponse.getList("City");
		for(String name:names){
			System.out.println(name);

		}



	}



	@Test //SDET
	public void getEmployee()
	{
		Response response=	given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when()
				.get("https://gorest.co.in/public-api/users")
				.then()
				.extract().response();

		int size=response.path("result.size()");
		System.out.println("Size: "+size);
		for(int i=1;i<=size;i++){
			
			String name=response.path("result.first_name["+i+"]");
			String email=response.path("result.email["+i+"]");
		System.out.println(name+ "--"+email);
		}


	}


	//@Test//TL
	public void getEmployee2(){
		RestAssured.baseURI="https://gorest.co.in/public-api";

		Response response=RestAssured.given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when().get("/users");

		JsonPath jsonResponse=response.jsonPath();

		List<String> names=jsonResponse.getList("result.first_name");
		for(String name:names){
			//System.out.println(name);

		}

		int size=response.body().path("result.size()");
		System.out.println("Size: "+size);
		for(int i=1;i<=size;i++){
			System.out.println(response.body().path("result.first_name["+i+"]"));
		}
	}


	//@Test//TL
	public void getEmployee2withRootpath(){
		RestAssured.baseURI="https://gorest.co.in/public-api";

		Response response=RestAssured.given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when().get("/users")
				.then()
				.rootPath("result")                      //ROOT PATH
				.extract().response();


		int size=response.path("size()");
		System.out.println("Size: "+size);
		
		for(int i=1;i<=size;i++){
			System.out.println(response.body().path("result.first_name["+i+"]"));
		}
	}

	//@Test//TL
	public void getEmployee2withDetachRootpath(){
		RestAssured.baseURI="https://gorest.co.in/public-api";

		Response response=RestAssured.given()
				.headers("Authorization", "Bearer FI-M1uVJsWIH6gUd8Ki8yeHxWxvVi0eRDfi3")
				.when().get("/users")
				.then()
				.rootPath("result")                      //ROOT PATH
				.body("first_name", hasItems("sagar"))
				.detachRootPath("result")
				.body("result.first_name", hasItems("sagar")).extract().response();
				

		int size=response.path("size()");
		System.out.println("Size: "+size);
		
		for(int i=1;i<=size;i++){
			System.out.println(response.body().path("result.first_name["+i+"]"));
		}
	}

}
