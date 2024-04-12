package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Employee;
import api.payload.FileSearch;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SearchEndpoints {

	public static Response Searchexceldata(FileSearch payload , String token)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		
		.body(payload)
		
		.when().post(Routes.excel_data);
	
	return response;
		
	}
	
}
