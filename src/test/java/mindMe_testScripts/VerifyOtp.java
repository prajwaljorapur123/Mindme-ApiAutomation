package mindMe_testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyOtp {
	@Test
	public void verify()
	{
		RestAssured.baseURI = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		RequestSpecification request = RestAssured.given();
		
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJwZXJtaXNzaW9uIjpbMl0sInN1YiI6IjEwMzA3LGhvb21hbjEyQHlvcG1haWwuY29tIiwiaXNzIjoiTWluZE1lIiwiaWF0IjoxNzAyNDAyNDUwLCJleHAiOjE3MDI0ODg4NTB9.XujO3B8xZJhln7Cr4TB0_ZZJxehhMMsMekGz0MDg0xbmXzsSWnHbcKU8mWOKZm89azXvJ5bSEtxSuhcfkEpjhw";
		request.header("Authorization" , "Bearer " + token)
		.header("Content-Type","application/json");
		
		 String data = "{\r\n"
		 		+ "    \"userId\":\"35\",\r\n"
		 		+ "    \"otpType\":\"0\",\r\n"
		 		+ "    \"otp\":\"5072\"\r\n"
		 		+ "}";
		 
		 request.header("Content-Type","application/json");
			Response responseFromOTPverify = request.body(data).post("/v1/otp/verify");
			
			responseFromOTPverify.prettyPrint();
			
			 //validations
		    
		    Assert.assertEquals(responseFromOTPverify.getStatusCode(), 200, "Invalid status code");
		    
		    Assert.assertEquals(responseFromOTPverify.getBody().jsonPath().getString("message"), "OK", "Incorrect success message");
		
	}

}
