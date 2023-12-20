package company;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateCompany {
	
	String token;
	String baseUrl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test(priority = 1)
	void register(ITestContext context)
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
				+ "        \"email\":\"ppovat@yopmail.com\",\r\n"
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
		
		context.setAttribute("auth_token", token);
	
//	Retoken=token;
		
	
		System.out.println(token);
	}
	
	@Test(priority = 2)
	void sendOTP()
	{
		System.out.println(token);
			
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
