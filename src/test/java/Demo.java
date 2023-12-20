import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.internal.common.assertion.AssertionSupport;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Arrays;
import java.util.Iterator;

public class Demo {
	String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	String token;
	
	@Test(priority = 1)
	void loginPage()
	{
		String loginBody = "{\r\n"
				+ "    \"email\":\"rocky@yopmail.com\",\r\n"
				+ "    \"password\":\"Prajwal@123\"\r\n"
				+ "}";
		
		token = given()
		.contentType(ContentType.JSON)
		.body(loginBody)
		
		
		
		.when()
		.post(baseurl+"/v1/auth/login")
		.jsonPath().getString("data.accessToken");
		
		System.out.println(token);
		
		
	}
	
	@Test(priority = 2)
	public void deleteTeamMember(){
	//	String token= (String) context.getAttribute("auth_token");
		
		// int id = (Integer) context.getAttribute("team_id"); 
		 
		 
		
			
			given()
			.queryParam("memberId", 4171)
			.queryParam("teamId", 12834)
			.headers("Authorization","Bearer "+token)
			.contentType(ContentType.JSON)
			 
			
			.when()
			.get(baseurl+"/v1/teams/delete_member/")
			
			.then()
			.statusCode(200)
			
			.log().all();
			
			System.out.println("Team member deleted.......");
	
	
	
			
	}	
		
	

}
