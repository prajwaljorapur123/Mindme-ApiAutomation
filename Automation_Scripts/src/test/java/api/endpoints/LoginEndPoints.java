package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Employee;
import api.payload.Login;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndPoints {
	
	
		public static Response Loginpage(Login payload)
		{
		Response response = given()
			.contentType(ContentType.JSON)
			.body(payload)
			
			.when().post(Routes.login_post_url);
		
		return response;
			
		}

}
