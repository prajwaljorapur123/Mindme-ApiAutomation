package mindMe_testScripts;

import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class otpVerify {

	
	@Test()
	void verify()
	{
		RegisterCompany rc = new RegisterCompany();
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJwZXJtaXNzaW9uIjpbMl0sInN1YiI6IjEwNjExLGlvdmF0QHlvcG1haWwuY29tIiwiaXNzIjoiTWluZE1lIiwiaWF0IjoxNzAyODgyMzQyLCJleHAiOjE3MDI5Njg3NDJ9.68mXHoTHx3YFofn9RQX9srIQnOtAv6jbRS3DiP5730WE4VMN9n-Oh3TAzyUbAFxvAWq3ZLAQshzZ1pdZsPV7wQ";
	
		String verifyBody = "{\r\n"
				+ "    \"userId\":\"35\",\r\n"
				+ "    \"otpType\":\"0\",\r\n"
				+ "    \"otp\":\"7250\"\r\n"
				+ "}";
		
		given()
		.headers("Authorization" , "Bearer "+ token)
		.contentType(ContentType.JSON)
		.body(verifyBody)
		
		.when()
		.post(rc.baseUrl+"/v1/otp/verify")
		
		.then().log().all();
		
		
	}
}
