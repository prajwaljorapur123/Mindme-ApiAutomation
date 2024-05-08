package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Employee;
import api.payload.Login;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndPoints {
	
	
		public static Response Loginpage(Login payload)
		{
		Response response = given()
				.filter(new AllureRestAssured())
			.contentType(ContentType.JSON)
			.body(payload)
			
			.when().post(Routes.login_post_url);
		
		return response;
			
		}
		
		public static Response GetComapany(String token)
		{
		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization","Bearer "+token)
		    	.when().get(Routes.Get_company_url);
		
	         	return response;
			
		}

}


