package Teams;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteTeam {
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		@Test
		public void deleteTeam(ITestContext context){
			
			 int id = (Integer) context.getAttribute("team_id"); 
			 String token= (String) context.getAttribute("auth_token");
			System.out.println("start");	
				given()

				.queryParam("id", id)
				.headers("Authorization","Bearer "+token)
				.contentType(ContentType.JSON)
				 
				
				.when()
				.get(baseurl+"/v1/teams/delete/")
				
				.then()
				.statusCode(200)
				
				.log().all();
				
				System.out.println("Team deleted ..........");
			
		}
}
