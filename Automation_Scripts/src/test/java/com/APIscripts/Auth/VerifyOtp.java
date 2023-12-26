package com.APIscripts.Auth;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class VerifyOtp {
	
	
@Test
void verify(ITestContext context)
{
	String token= (String) context.getAttribute("auth_token");
	
	String data = "{\r\n"
			+ "    \"userId\":\"35\",\r\n"
			+ "    \"otpType\":\"0\",\r\n"
			+ "    \"otp\":\"7500\"\r\n"
			+ "}";
	
	given()
	
	.when()
	
	.then();
}

}
