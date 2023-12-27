package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import api.payload.Team;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TeamEndPoints {
	
	public static Response CreateTeam(String token , Team payload)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.teams_post_url);
	
	    return response;
		
	}
	
	public static Response TeamDetails(String token , int No,int size)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.queryParam("pageNo", No)
		.queryParam("pageSize", size)
		.when().get(Routes.teams_get_url);
	
	    return response;
		
	}
	
	public static Response TeamUpdate(String token ,  int teamId , Team payload)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		
		.body(payload)
		.when().post(Routes.teams_update_url);
	
	    return response;
		
	}
	public static Response TeamDelete(String token , int teamId)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.queryParam("id", teamId)
	
		.when().get(Routes.teams_delete_url);
	
	    return response;
		
	}
	

}
