package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Community;
import api.payload.Project;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CommunityEndpoints {
	public static Response CreateCommunity(String token, Community payload) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(payload).when().post(Routes.project_create_url);

		return response;

	}

	public static Response SearchCommunity(String token, Community payload) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(payload).when().post(Routes.projects_url);

		return response;

	}
	
	public static Response Createrequest(String token , Community payload)
	{
		
	Response response = given()
			.filter(new AllureRestAssured())
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.Createrequest);
	
	    return response;
		
	}

	public static Response DvsOverview(String token, Community payload) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(payload).when().post(Routes.DvsOverview);

		return response;	
	}
	
	public static Response OverviewIssueCount(String token, Community payload) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(payload).when().post(Routes.issueCounts);

		return response;
	}
}
