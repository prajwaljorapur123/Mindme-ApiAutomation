package com.APIscripts.Teams;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getTeamEmployees {
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	 
	 @Test
		public void getTeams(ITestContext context){
		
		 String token= (String) context.getAttribute("auth_token");
			  int id = (Integer) context.getAttribute("team_id"); 
			

			 given()
			 .headers("Authorization","Bearer "+token)
			 .contentType(ContentType.JSON)
	 		
			 
			 .when().get(baseurl+"/v1/teams/teamEmployee/?teamId="+id)
			 
			 .then().log().all();
			 
			 System.out.println("get team employees............");
			
		}
	
	
	
}
