package com.APIscripts.Auth;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ForgotPassword {
	
	
	@Test
	void forgotPassword()
	{
		 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		 String data = "{\r\n"
		 		+ "    \"email\":\"rocky@yopmail.com\"\r\n"
		 		+ "}";
		 
		 given()
		 .contentType(ContentType.JSON)
		 .body(data)
		 
		 
		 .when()
		 .post(baseurl+"/v1/auth/forgot_password")
		 
		 .then().log().all();

	}

}
