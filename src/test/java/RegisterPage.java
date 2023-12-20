import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterPage {
	
	
	
	
	@Test
	public void CreateCompany()
	{
		RestAssured.baseURI = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		RequestSpecification request = RestAssured.given();
		
		String Data = "{\r\n"
				+ "    \"companyName\":\"Some Company Name\",\r\n"
				+ "    \"companyDescription\":\"Some Description\",\r\n"
				+ "    \"password\":\"123456\",\r\n"
				+ "    \"addEmployee\":{\r\n"
				+ "        \"empType\":\"1\",\r\n"
				+ "        \"firstName\":\"Some Name\",\r\n"
				+ "        \"lastName\":\"Some Last\",\r\n"
				+ "        \"designation\":\"Some designation\",\r\n"
				+ "        \"countryCode\":\"+91\",\r\n"
				+ "        \"email\":\"dakuraj@yopmail.com\",\r\n"
				+ "        \"phone\":\"9090909090\",\r\n"
				+ "        \"permissionIds\":[1],\r\n"
				+ "        \"imageId\":\"12\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		 request.header("Content-Type","application/json");
		 Response responseFromgenarateToken = request.body(Data).post("/v1/Company/create");

			responseFromgenarateToken.prettyPrint();
			
			String jsonString = responseFromgenarateToken.getBody().asString();
			
			String tokenGenerated = JsonPath.from(jsonString).get("data.accessToken");
			

			request.header("Authorization" , "Bearer " + tokenGenerated)
			.header("Content-Type","application/json");
			
			String otpSend = "{\r\n"
					+ "    \"otpType\":\"0\"\r\n"
					+ "}";
			
			Response otpSendResponse = request.body(otpSend).post("/v1/otp/send");
			otpSendResponse.prettyPrint();
			
	}

}
