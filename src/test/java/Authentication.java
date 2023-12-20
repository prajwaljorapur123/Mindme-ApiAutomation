import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
	
	//String uri = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com/v1/employee/add";
	
	
	@Test
	public void Tokentest()
	{
		RestAssured.baseURI = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		RequestSpecification request = RestAssured.given();
		 String payload = "{\r\n"
		 		+ "    \"email\":\"dagar@yopmail.com\",\r\n"
		 		+ "    \"password\":\"Prajwal@123\"\r\n"
		 		+ "}";
		 
		 request.header("Content-Type","application/json");
		Response responseFromgenarateToken = request.body(payload).post("/v1/auth/login");
		
		//responseFromgenarateToken.prettyPrint();
		
		ResponseBody b = responseFromgenarateToken.getBody();
		          String responsebody = b.asString();
		          
		          
		          
		          
		       JsonPath jsnpath = responseFromgenarateToken.jsonPath();
		    //   jsnpath.prettyPrint();
		       
		       String s = jsnpath.get("data.accessToken");
		       System.out.println("token  :" + s);
		       
		



		
		String token = s;
		  given().headers("Authorization" , "Bearer "+token)
		  
		  .when().get("http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com/v1/employee")
		  .then().statusCode(200).log().all();
//		   
	}

}
