package cucumber.API;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC7_ReadFrJsonFile2DP {
	
	
	
	
	@DataProvider(name="dp")
	public String[] readJsonFromFile() throws IOException, ParseException{
		
		FileReader fileReader=new FileReader("C:\\Users\\Sri\\workspace\\SDET\\usercred.json");
		JSONParser jsonparser=new JSONParser();
		JSONObject usercredjsonobject=(JSONObject) jsonparser.parse(fileReader);
	
		JSONArray usercredjsonarray=(JSONArray)usercredjsonobject.get("userlogin");
		String arr[]=new String[usercredjsonarray.size()];
		
	for(int i=0;i<usercredjsonarray.size();i++){
		JSONObject users=(JSONObject)usercredjsonarray.get(i);
		String user=(String) users.get("UN");
		String pwd=(String)users.get("PWD");
		
		//System.out.println(user +" "+pwd);
		
		arr[i]=user+","+pwd;
		
				
	}
	return arr;
	
	}

	
	@Test(dataProvider="dp")
	void login(String data){
		
		String d[]=data.split(",");
		System.out.println(d[0] +" -----"+d[1]);
	}
	
	
	
}
