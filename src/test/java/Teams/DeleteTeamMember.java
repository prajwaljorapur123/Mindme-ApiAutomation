package Teams;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteTeamMember {
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test
	public void deleteTeamMember(ITestContext context) throws InterruptedException{
		String token= (String) context.getAttribute("auth_token");
		
		 int id = (Integer) context.getAttribute("team_id"); 
		 
		
		 
		 System.out.println(token);
		 
		 
		 System.out.println(id);
		
			
			given()
			.queryParam("memberId", 5534)
			.queryParam("teamId", id)
			.headers("Authorization","Bearer "+token)
			.contentType(ContentType.JSON)
			
			
			 
			
			.when()
			.get(baseurl+"/v1/teams/delete_member/")
			
			.then()
		//	.statusCode(200)
			
			.log().all();
			
			System.out.println("Team member deleted.......");
		
	}

}
