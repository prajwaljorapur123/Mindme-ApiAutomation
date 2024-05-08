package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Employee;
import api.payload.FileSearch;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SearchEndpoints {

	public static Response Searchexceldata(FileSearch payload , String token)
	{
		
	Response response = given()
			.filter(new AllureRestAssured())
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		
		.body(payload)
		
		.when().post(Routes.excel_data);
	
	return response;
		
	}
	
	
	public static Response Searchpdfdata( String token , FileSearch payload)
	{
		
	Response response = given()
			.filter(new AllureRestAssured())
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.pdf_data);
	
	return response;
		
	}
	
	
	
	
	public static Response DashboardCount(String token)
	{
		
	Response response = given()
			.filter(new AllureRestAssured())
		.headers("Authorization","Bearer "+token)
		
		.when().get(Routes.DashboardCount);
	
	return response;
		
	}
	
}
