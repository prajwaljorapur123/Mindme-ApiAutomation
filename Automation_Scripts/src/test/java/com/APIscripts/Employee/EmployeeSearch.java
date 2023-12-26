package com.APIscripts.Employee;


	import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


	public class EmployeeSearch {
		String baseurl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
		
		@Test
		void teamsearch(ITestContext context)
		{
			String token= (String) context.getAttribute("auth_token");
			String data="{\r\n"
					+ "    \"name\":\"\",\r\n"
					+ "    \"pageNo\":0,\r\n"
					+ "    \"pageSize\":8\r\n"
					+ "}";
				
		Response	 res  = given()
				.headers("Authorization","Bearer "+token)
				.contentType(ContentType.JSON)
				.body(data)
				 
				
				.when()
				.post(baseurl+"/v1/employee/search");
		
		res.prettyPrint();
		
			List<Object> id = res.jsonPath().getList("data.employeeDetails.id");
				
				
		}

	

}
