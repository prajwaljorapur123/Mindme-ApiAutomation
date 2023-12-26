package com.APIscripts.Auth;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class LoginPage {

	
		String baseUrl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		
		@Test
		void loginPage(ITestContext context)
		{
			System.out.println("login successfull.........................");
			String loginBody = "{\r\n"
					+ "    \"email\":\"dagar@yopmail.com\",\r\n"
					+ "    \"password\":\"Prajwal@123\"\r\n"
					+ "}";
			
			String token=given()
			.contentType(ContentType.JSON)
			.body(loginBody)
			
			.when()
			.post(baseUrl+"/v1/auth/login")
			.jsonPath().getString("data.accessToken");
			
			
			//global variable 
			System.out.println(token);
			context.setAttribute("auth_token", token);
			

		}

}
