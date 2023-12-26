package com.APIscripts.Auth;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ResetPassword {
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test()
	
	void reset(ITestContext context)
	{
		String token= (String) context.getAttribute("auth_token");
		
		String data = "{\r\n"
				+ "    \"password\":\"Prajwal@123\"\r\n"
				+ "}";
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(data)
		
		.when().post(baseurl+"/v1/auth/reset_password")
		
		.then()
		.log().all();
	}

}
