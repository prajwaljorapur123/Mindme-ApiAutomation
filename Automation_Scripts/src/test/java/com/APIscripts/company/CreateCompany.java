package com.APIscripts.company;

import java.util.Arrays;


import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import dev.failsafe.internal.util.Assert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateCompany {
	
	@Test
	void createCompany(ITestContext context)
	{
		String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("companyName", faker.company().name());
		data.put("companyDescription", faker.name());
		data.put("password","Prajwal@123" );
		
		 JSONObject addEmployee = new JSONObject();
		 addEmployee.put("firstName", faker.name().firstName());
		 addEmployee.put("lastName", faker.name().lastName());
		 addEmployee.put("designation", faker.name().username());
		 addEmployee.put("countryCode","+91" );
		 addEmployee.put("email", faker.internet().emailAddress());
		 addEmployee.put("phone","8989898989" );
		 addEmployee.put("permissionIds",Arrays.asList(1) );
		 addEmployee.put("imageId","12" );
		 
		 data.put("addEmployee", addEmployee);
		
	Response res =given()
			.contentType(ContentType.JSON)
	    	.body(data.toString())
	    	
		.when().post(baseurl+"/v1/Company/create");
         res.prettyPrint();
         
     String token = res.jsonPath().get("data.accessToken");
     context.setAttribute("company_token", token);
		
	}

}
