package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import api.payload.Project;
import api.payload.Team;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectEndPoints {

	public static Response CreateProject(String token , Project payload)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.project_create_url);
	
	    return response;
		
	}
	
	public static Response ProjectDetails(String token)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.when().get(Routes.projects_url);
	    return response;
		
	}
	
	public static Response ProjectUpdate(String token  ,int id,	List<Integer> team, Project payload)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.project_update_url);
	
	    return response;
		
	}
	
	
}
