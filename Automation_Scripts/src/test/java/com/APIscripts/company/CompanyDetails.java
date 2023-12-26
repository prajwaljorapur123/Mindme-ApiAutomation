package com.APIscripts.company;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CompanyDetails {
	
	@Test
	void companyDetails(ITestContext context)
	{
		String token= (String) context.getAttribute("company_token");
		String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		given()
		.headers("Authorization","Bearer "+token)
		
		.when()
		.get(baseurl+"/v1/Company/")
		
		.then().log().all()
		.statusCode(200);

	}

}
