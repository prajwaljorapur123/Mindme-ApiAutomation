package Teams;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.opentelemetry.context.Context;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class GetTeams {
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	 
	 @Test
	public void getTeams(ITestContext context){
		 System.out.println("get teams.................");
		 String token= (String) context.getAttribute("auth_token"); //this should come from login page
		

		 given()
		 .headers("Authorization","Bearer "+token)
		 .contentType(ContentType.JSON)
 		
		 
		 .when().get(baseurl+"/v1/teams?pageNo=0&pageSize=10")
		 
		 .then()
		 .statusCode(200)
		 .body("message", equalTo("OK"));
		
	}

}
