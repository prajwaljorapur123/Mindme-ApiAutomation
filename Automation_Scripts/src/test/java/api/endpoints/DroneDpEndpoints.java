package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.DroneDp;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class DroneDpEndpoints {
	
	public static Response ViewRequest(String token , DroneDp payload)
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(payload)
	    	.when().post(Routes.ViewRequest);
	
         	return response;
		
	}


}
