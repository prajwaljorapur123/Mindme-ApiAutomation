package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;

import api.payload.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeEndPoints {
	
	
	public static Response addEmployee(Employee payload , String token)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when().post(Routes.post_url);
	
	return response;
		
	}
	
	public static Response EmployeeDetails(String token)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get(Routes.get_url);
	
	    return response;
		
	}
	
	public static Response UpdateEmployee(String email , Employee payload,String token)
	{
	
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.multiPart("data",payload , "application/json")
		.contentType("multipart/json")
		.when().post(Routes.update_url);
	    return response;
		
	}
	
	public static Response DeleteEmployee(int eid , String token)
	{
		
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.queryParam("id",eid )
		.contentType(ContentType.JSON)
		.when().get(Routes.delete_url);
	    return response;
		
	}
	
	
	public static Response SearchEmployee(String token,Employee payload)
	{
	
	Response response = given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(payload)
		.when().post(Routes.search_url);
	    return response;
		
	}
	
	
	

}
