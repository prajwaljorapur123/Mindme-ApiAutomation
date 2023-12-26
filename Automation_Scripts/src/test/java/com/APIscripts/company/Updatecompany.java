package com.APIscripts.company;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.json.JSONObject;

public class Updatecompany {
	
	@Test
	void updatecompany(ITestContext context)
	{
		String token= (String) context.getAttribute("company_token");
		String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		Faker faker  = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("companyName", faker.company().name());
		data.put("companyDescription", faker.name().bloodGroup());
		data.put("phone", "23232323322");
		
		File fileToUpload = new File("src/test/resources/king.jpg");
		
		given()
		  .headers("Authorization","Bearer "+token)
		  .multiPart("data" , data.toString() ,"application/json")
			.multiPart("file", fileToUpload , "image/jpg" )
			.contentType("multipart/json")
		
		.when()
		.post(baseurl+"/v1/Company/update")
		
		.then().log().all()
		.statusCode(200)
		.body("message", equalTo("200 OK"));
	
	}

}
