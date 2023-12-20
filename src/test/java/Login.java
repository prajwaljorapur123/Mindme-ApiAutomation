import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class Login {
	
	
	
	@Test
	public void loginpage()
	{
		 // Set the base URI for the API
		RestAssured.baseURI="http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	     
		// Define request body for login
		String requestBody = "{\r\n"
				+ "    \"email\":\"rocky@yopmail.com\",\r\n"
				+ "    \"password\":\"Prajwal@123s\"\r\n"
				+ "}";
		
		 // Perform the POST request
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/v1/auth/login");
		
		 //print response
		response.prettyPrint();
		
		
		int status = response.getStatusCode();
	    String responseBody = response.getBody().asString();
	    
	    //validations
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code");
	    
	    Assert.assertEquals(response.getBody().jsonPath().getString("message"), "OK", "Incorrect success message");
	    
	    
	 
   System.out.println("status code :" +status);
   System.out.println("response body :"+responseBody);
	}
	

}
