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
		
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJwZXJtaXNzaW9uIjpbMl0sInN1YiI6IjEwMTYzLGRha3VyYWpAeW9wbWFpbC5jb20iLCJpc3MiOiJNaW5kTWUiLCJpYXQiOjE3MDIzMTQwMTYsImV4cCI6MTcwMjQwMDQxNn0.Q4q61ZtcFdur70_FNcnj52j-NWaFcf4_2b0JilBW94JgSVzOQxqIiwM9DF6NK7rAJZ6tktjoZJ0A4Np8vMVezw";
		request.header("Authorization" , "Bearer " + token)
		.header("Content-Type","application/json");
		
		 String data = "{\r\n"
		 		+ "    \"userId\":\"35\",\r\n"
		 		+ "    \"otpType\":\"0\",\r\n"
		 		+ "    \"otp\":\"3428\"\r\n"
		 		+ "}";
		 
		 request.header("Content-Type","application/json");
			Response responseFromOTPverify = request.body(data).post("/v1/otp/verify");
			
			responseFromOTPverify.prettyPrint();
		
	}
}
