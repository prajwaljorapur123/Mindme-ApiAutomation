package mindMe_testScripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RegisterCompany {
	String token;
	String baseUrl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test(priority = 1)
	void register()
	{
		
		String RegisterBody = "{\r\n"
				+ "    \"companyName\":\"Some Company Name\",\r\n"
				+ "    \"companyDescription\":\"Some Description\",\r\n"
				+ "    \"password\":\"123456\",\r\n"
				+ "    \"addEmployee\":{\r\n"
				+ "        \"empType\":\"1\",\r\n"
				+ "        \"firstName\":\"Some Name\",\r\n"
				+ "        \"lastName\":\"Some Last\",\r\n"
				+ "        \"designation\":\"Some designation\",\r\n"
				+ "        \"countryCode\":\"+91\",\r\n"
				+ "        \"email\":\"iovat@yopmail.com\",\r\n"
				+ "        \"phone\":\"9090909090\",\r\n"
				+ "        \"permissionIds\":[1],\r\n"
				+ "        \"imageId\":\"12\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		token =given()
		.contentType(ContentType.JSON)
		.body(RegisterBody)
		
		
		.when()
		.post(baseUrl+"/v1/Company/create")
		.jsonPath().getString("data.accessToken");
		
		
		
	
		System.out.println(token);
	}
	
	@Test(priority = 2)
	void sendOTP()
	{
			
		String otpBody = "{\r\n"
				+ "    \"otpType\":\"0\"\r\n"
				+ "}";
		
		given()
		
		.headers("Authorization" , "Bearer "+token)
		.contentType(ContentType.JSON)
		.body(otpBody)
		
		.when().post(baseUrl+"/v1/otp/send")
		
		.then().log().all()
		.statusCode(200)
		.body("data", equalTo("Mail Sent Successfully..."))
		.body("message", equalTo("200 OK"));
		
		
		
	}
	
	

}
