package com.APIscripts.Employee;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.json.JSONObject;

public class EditEmployee {
	String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	@Test
	void editEmp(ITestContext context)
	{
		String token= (String) context.getAttribute("auth_token");
		 String email = (String) context.getAttribute("emp_email");
		 
		 Faker faker = new Faker();
			JSONObject jsondata = new JSONObject();
			jsondata.put("firstName", faker.name().firstName());
			jsondata.put("lastName", faker.name().lastName());
			jsondata.put("email", email);
			jsondata.put("countryCode", "+91");
			jsondata.put("phone", "2323238923");
			jsondata.put("permissionIds", Arrays.asList(1));
			jsondata.put("designation", faker.name().lastName());
			jsondata.put("imageId","0");
			
			given()
			.multiPart("data" , jsondata.toString() ,"application/json")
			.contentType("multipart/json")
			.headers("Authorization","Bearer "+token)
			
			.when().post(baseurl+"/v1/employee/updateEmployee")
			
			.then().log().all();
			
			
		 
		
	}

}
