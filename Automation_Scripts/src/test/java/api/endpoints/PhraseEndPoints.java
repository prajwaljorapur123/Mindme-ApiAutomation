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
}
