package Teams;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TeamSearch {
	
	 String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test
	void teamsearch(ITestContext context)
	{
		
		System.out.println("Team search is done....");
		String token= (String) context.getAttribute("auth_token");
		
		given()

		.queryParam("searchWord", "Sana")
		.queryParam("pageNo", 0)
		.queryParam("pageSize", 10)
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		 
		
		.when()
		.get(baseurl+"/v1/teams/teamSearch/")
		
		.then()
		.statusCode(200)
		.body("data[0].teams.teamsName",equalTo("Sana Barton") )
		.log().all();
		
	}

}
