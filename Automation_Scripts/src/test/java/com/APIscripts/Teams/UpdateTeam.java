package com.APIscripts.Teams;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class UpdateTeam {
	
	
 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	 
	 @Test
		public void getTeams(ITestContext context){
		 System.out.println("Team updated ............");
		 String token= (String) context.getAttribute("auth_token");
			  int id = (Integer) context.getAttribute("team_id"); 
			  
			  Faker faker = new Faker();
			  
			  JSONObject data = new JSONObject();
			  
			  data.put("teamId", id);
			  data.put("teamName", faker.name().fullName());
			  data.put("empId", Arrays.asList(4171));
			

			 given()
			 .headers("Authorization","Bearer "+token)
			 .contentType(ContentType.JSON)
			 .body(data.toString())
	 		
			 
			 .when().post(baseurl+"/v1/teams/update_teams")
			 
			 .then().log().all();
			
		}

}
