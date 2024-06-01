package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Admin;
import api.payload.Login;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AdminEndpoints {
	
	public static Response AdminLogin(Admin payload)
	{
	Response response = given()
		.filter(new AllureRestAssured())
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when().post(Routes.login_post_url);
	
	return response;
		
	}

}
