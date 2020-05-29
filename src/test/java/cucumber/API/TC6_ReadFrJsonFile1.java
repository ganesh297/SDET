package cucumber.API;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC6_ReadFrJsonFile1 {
	
	@Test
	public void readJsonFromFile() throws IOException, ParseException{
		
		FileReader fileReader=new FileReader("C:\\Users\\Sri\\workspace\\SDET\\data2.json");
		JSONParser jsonparser=new JSONParser();
		JSONObject jsonObject=(JSONObject) jsonparser.parse(fileReader);
		//String name=(String) jsonObject.get("quiz.sport.q1.question");
		//System.out.println(name);
	
		
	Response response=given().contentType(ContentType.JSON)	
		.body(fileReader).get()
		.then().extract().response();
		
	System.out.println(response);
	
	String q=response.jsonPath().get("quiz.sport.q1.question");
			System.out.println(q);
	
	/*JsonPath j=response.jsonPath();
	System.out.println(j.get("quiz.sport.q1.question"));
	}*/
	

	
	
/*	@DataProvider(name="Files")
	public String[] loadData(){
		
		String[] files=new String[2];
		files[0]="C:\\Users\\Sri\\workspace\\SDET\\data2.json";
		files[1]="C:\\Users\\Sri\\workspace\\SDET\\data2.json";
		return files;
	}
	
	//@Test(dataProvider="Files")
	public void readJsonFromFileDP(String FileName) throws IOException, ParseException{
		
		FileReader fileReader=new FileReader(FileName);
		JSONParser jsonparser=new JSONParser();
		JSONObject jsonObject=(JSONObject) jsonparser.parse(fileReader);
		String name=(String) jsonObject.get("quiz.sport.q1.question");
		System.out.println(name);
	
		
	Response response=given().contentType(ContentType.JSON)	
		.body(fileReader).get();
		
	response.prettyPrint();
*/		
	}

}
