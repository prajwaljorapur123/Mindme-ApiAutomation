package api.endpoints;

import static io.restassured.RestAssured.given;

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
}
