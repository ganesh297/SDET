package cucumber.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TC1_GetUsingPathParam {
	
		@Test //SDET
		public void getWeatherDetails()
		{
			given()
			.pathParam("cityName", "Hyderabad")
			.when()
				.get("http://restapi.demoqa.com/utilities/weather/city/{cityName}")
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City", equalTo("Hyderabad"))
				.header("Content-Type","application/json");
			
		}
		

}
