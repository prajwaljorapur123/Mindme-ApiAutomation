package com.APIscripts.Employee;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteEmployee {
	String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test
	void deleteEmp(ITestContext context)
	{
     String token= (String) context.getAttribute("auth_token");
	 int id = (Integer) context.getAttribute("emp_id");
//		 String token ="eyJhbGciOiJIUzUxMiJ9.eyJwZXJtaXNzaW9uIjpbMl0sInN1YiI6IjkyMjMsZGFnYXJAeW9wbWFpbC5jb20iLCJpc3MiOiJNaW5kTWUiLCJpYXQiOjE3MDMxNDExOTAsImV4cCI6MTcwMzIyNzU5MH0.ocWjei3lRJlDp89NDnAJccHrreDIysMvQSSyNoFm1rOOw5wHekFvUG15Pt4fjbhQDk8RR1xEl0nX2XSVzPADxA";
//		 int id = 13195;
		 System.out.println(id);
		
	     given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.queryParam("id", id)
		
		.when()
		.get(baseurl+"/v1/employee/deleteEmployee/")
		.then().log().all();
	     
	    
	    
	  
	    System.out.println("deleted successfully.......");
		
		
	}
	
	

}
