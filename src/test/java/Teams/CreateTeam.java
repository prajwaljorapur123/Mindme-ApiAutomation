package Teams;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateTeam {
	
    String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	
	@Test
	public void CreatTeam(ITestContext context)
	{
		
		 String token= (String) context.getAttribute("auth_token");
    			Faker faker = new Faker();
        		JSONObject data = new JSONObject();
        		data.put("teamName", faker.name().fullName());
        		data.put("empId", Arrays.asList(6170,5534,4189,4175));
        		
        		
        	int id = given()
        		.headers("Authorization" , "Bearer "+token)
        		.contentType(ContentType.JSON)
        		.body(data.toString())
        		
        		.when().post(baseurl+"/v1/teams/create")
        		.jsonPath().getInt("data.teams.id");
        	   context.setAttribute("team_id", id);
        	   
        	   System.out.println("team created id :"+id);
        	   
        	   System.out.println("team created successfull...............");
				
    		
//    		.then().log().all()
//    		.statusCode(200)
//    		.body("data.employeeDetailsList.id", hasItems(4171,4175,4189))
//    		.body("message", equalTo("OK"));
    				
	
	}

}
