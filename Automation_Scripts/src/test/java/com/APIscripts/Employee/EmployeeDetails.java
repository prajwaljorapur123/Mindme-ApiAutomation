package com.APIscripts.Employee;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class EmployeeDetails {
	String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	
	@Test
	void getEmployees(ITestContext context)
	{
		String token= (String) context.getAttribute("auth_token");

		given()
		.headers("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.when().get(baseurl+"/v1/employee/Details")
		
		.then().log().all();
		
		System.out.println("Details of super admin");
		
	
		
	}

}
