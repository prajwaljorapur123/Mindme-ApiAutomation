package com.APIscripts.Teams;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
        		
        		
        	Response res = given()
        		.headers("Authorization" , "Bearer "+token)
        		.contentType(ContentType.JSON)
        		.body(data.toString())
        		
        		.when().post(baseurl+"/v1/teams/create");
        	
        int id = 	res.jsonPath().getInt("data.teams.id");
        		//.jsonPath().getInt("data.teams.id");
        	   context.setAttribute("team_id", id);
        	   
        	   
        	   res.prettyPrint();
        	   
        	   
        	   
        	  // validations
        	  String msg = res.jsonPath().get("message");
        	   
        	   int status = res.statusCode();
        	   System.out.println(status);
        	 Assert.assertEquals(msg, "OK","team created");
        	 Assert.assertEquals(status, 200,"Correct status code returned");
        	   
        	   System.out.println("team created successfull...............");
				
    		

    				
	
	}

}
