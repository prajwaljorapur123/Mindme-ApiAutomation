package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Phrase;
import api.payload.Project;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PhraseEndPoints {

	public static Response AddPhrase(String token , Phrase payload)
	{
		Response response = given()
				.headers("Authorization","Bearer "+token)
				.contentType(ContentType.JSON)
				.body(payload)
				.when().post(Routes.Add_phrase);
			
			    return response;
	}
	
	public static Response GetPhrase(String token ,String searchWord,int projectId, int fileId , int pageNo ,int  pageSize)
	{
		Response response = given()
				.headers("Authorization","Bearer "+token)
				
				.queryParam("searchWord", searchWord)
				.queryParam("projectId", projectId)
				.queryParam("fileId", fileId)
				.queryParam("pageNo", pageNo)
				.queryParam("pageSize", pageSize)
				.when().get(Routes.Get_phrase);
			
			    return response;
	}
	
	public static Response UpdatePhrase(String token ,String id, Phrase payload)
	{
		Response response = given()
				.headers("Authorization","Bearer "+token)
				.contentType(ContentType.JSON)
				.body(payload)
				.when().post(Routes.Update_phrase);
			
			    return response;
	}
	
	public static Response DeletePhrase(String token ,String abbreviationId)
	{
		Response response = given()
				.headers("Authorization","Bearer "+token)
				
				.queryParam("abbreviationId", abbreviationId)
			
				.when().get(Routes.Delete_phrase);
			
			    return response;
	}
	
	
}
