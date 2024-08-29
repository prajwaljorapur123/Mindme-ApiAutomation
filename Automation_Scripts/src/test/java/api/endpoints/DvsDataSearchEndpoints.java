package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.DataDvs;
import api.payload.FileSearch;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DvsDataSearchEndpoints {

	public static Response DvsDataSearch(DataDvs payload , String token)
	{
		
	Response response = given()
			.filter(new AllureRestAssured())
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		
		.body(payload)
		
		.when().post(Routes.DataDvs);
	
	return response;
		
	}
	
}
