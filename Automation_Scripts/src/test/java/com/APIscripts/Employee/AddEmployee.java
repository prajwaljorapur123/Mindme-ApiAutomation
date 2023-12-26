package com.APIscripts.Employee;
import static io.restassured.RestAssured.given;


import java.util.Arrays;

import org.json.JSONObject;
import org.openqa.selenium.devtools.v118.fetch.model.AuthChallengeResponse.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class AddEmployee {
	String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	@Test
	void addemp(ITestContext context) {
		String token= (String) context.getAttribute("auth_token");
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("firstName", faker.name().firstName());
		data.put("lastName", faker.name().lastName());
		data.put("email", faker.internet().emailAddress());
		data.put("countryCode", "+91");
		data.put("phone", "2323238923");
		data.put("permissionIds", Arrays.asList(1));
		data.put("designation", faker.name().lastName() );
		data.put("imageId","0");
		
		
	io.restassured.response.Response res =  given()
			.headers("Authorization","Bearer "+token)
		   .contentType(ContentType.JSON)
	    	.body(data.toString())
		
		.when()
		.post(baseurl+"/v1/employee/add");
	

	res.prettyPrint();
	
		
		
		int id =res.jsonPath().getInt("data.employeeDetails.id");
		context.setAttribute("emp_id", id);
		
		String email = res.jsonPath().getString("data.employeeDetails.email");
		context.setAttribute("emp_email", email);
		System.out.println("added employee..............");
		
		
	}

}
