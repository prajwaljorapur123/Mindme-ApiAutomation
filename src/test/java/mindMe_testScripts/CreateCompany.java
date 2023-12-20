package mindMe_testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCompany {
	
	@Test
	public void RegisterCompany(){
		
		 // Set the base URI for the API
		RestAssured.baseURI="http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		// Define request body for Register page.
		
		String requestBody = "{\r\n"
				+ "    \"companyName\":\"Trudosys\",\r\n"
				+ "    \"companyDescription\":\"Web dev\",\r\n"
				+ "    \"password\":\"Prajwal@123\",\r\n"
				+ "    \"addEmployee\":{\r\n"
				+ "        \"empType\":\"1\",\r\n"
				+ "        \"firstName\":\"bolandi\",\r\n"
				+ "        \"lastName\":\"hooman\",\r\n"
				+ "        \"designation\":\"owner\",\r\n"
				+ "        \"countryCode\":\"+91\",\r\n"
				+ "        \"email\":\"hooman12@yopmail.com\",\r\n"
				+ "        \"phone\":\"9090909090\",\r\n"
				+ "        \"permissionIds\":[1],\r\n"
				+ "        \"imageId\":\"12\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		 // Perform the POST request
		
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/v1/Company/create");
		
		response.prettyPrint();
		
		String jsonstring = response.getBody().asString();
		String token = JsonPath.from(jsonstring).get("data.accessToken");
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Authorization" , "Bearer " + token)
		.header("Content-Type","application/json");
		
		String otpSend = "{\r\n"
				+ "    \"otpType\":\"0\"\r\n"
				+ "}";
		
		Response otpSendResponse = request.body(otpSend).post("/v1/otp/send");
		
		otpSendResponse.prettyPrint();
		
		
 //validations
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code");
	    
	    Assert.assertEquals(response.getBody().jsonPath().getString("message"), "OK", "Incorrect success message");
		
		
		
		
		
		
		
	}

}
