package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.AdminCompany;
import api.payload.UploadFile.ProjectDetails;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AdminCompanyEndpoints {
	
	public static Response AdminCreateCompany(String token, AdminCompany company) {
		

		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token)
				.contentType("application/json")
				.body(company)
				.when().post(Routes.AdminCreateCompany);

		return response;

	}
	
public static Response AdminCompanySearch(String token , String name , int pageNo , int pageSize , int searchType ) {
		

		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token)
				.queryParam("name", name)
		        .queryParam("pageNo", pageNo)
		        .queryParam("pageSize", pageSize)
		        .queryParam("searchType", searchType)
		        
				.when().get(Routes.AdminCompanySearch);

		return response;

	}


public static Response AdminUpdateCompany(String token , int id , AdminCompany payload) {
	

	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization", "Bearer " + token)
			.contentType(ContentType.JSON)
			.body(payload)
	        
			.when().post(Routes.AdminUpdateCompany);

	return response;

}


public static Response AdminDiCompany(String token , int id , AdminCompany payload) {
	

	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization", "Bearer " + token)
			.contentType(ContentType.JSON)
			.body(payload)
	        
			.when().post(Routes.AdminUpdateCompany);

	return response;

}
}
