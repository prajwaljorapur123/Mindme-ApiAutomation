package mindMe_testScripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class Addemployee {
String token;
String baseUrl = "http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	
	@Test(priority = 1)
	void loginPage()
	{
		String loginBody = "{\r\n"
				+ "    \"email\":\"dagar@yopmail.com\",\r\n"
				+ "    \"password\":\"Prajwal@123\"\r\n"
				+ "}";
		
		token = given()
		.contentType(ContentType.JSON)
		.body(loginBody)
		
		
		
		.when()
		.post(baseUrl+"/v1/auth/login")
		.jsonPath().getString("data.accessToken");
		
		
	}
	
	@Test(priority = 2)
	void addEmployee()
	{
		System.out.println(token);
		String employeeBody = "{\r\n"
				+ "    \"firstName\":\"dinga\",\r\n"
				+ "    \"lastName\":\"donga\",\r\n"
				+ "    \"email\":\"polpghlakkhh@yopmail.com\",\r\n"
				+ "    \"countryCode\":\"+91\",\r\n"
				+ "    \"phone\":\"9090909090\",\r\n"
				+ "    \"permissionIds\":[1],\r\n"
				+ "    \"designation\":\"Some Designation\",\r\n"
				+ "    \"imageId\":\"0\"\r\n"
				+ "}";
		
		given()
		.headers("Authorization" , "Bearer "+token)
		.contentType(ContentType.JSON)
		.body(employeeBody)
		
		.when()
		.post(baseUrl+"/v1/employee/add")
		
		.then()
		.log().all()
		.statusCode(200)
	    .body("data.emailMessage", equalTo("Mail Sent Successfully..."))
	    .body("message", equalTo("OK"));
	}
	
	
	//@Test()
	void update()
	{
	
		String jsondata = "{\r\n"
				+ "  \"firstName\":\"sejal\",\r\n"
				+ "    \"lastName\":\"kololll\",\r\n"
				+ "    \"email\":\"sejon@yopmail.com\",\r\n"
				+ "    \"phone\":\"9036334455998877\",\r\n"
				+ "    \"permissionIds\":[0],\r\n"
				+ "    \"designation\":\"tester\",\r\n"
				+ "    \"gender\":\"Male\",\r\n"
				+ "    \"imageId\":\"14\"\r\n"
				+ "}";
		
		String jpg = "‪C:\\\\Users\\\\www.abcom.in\\\\Downloads\\\\i1.jpg";
		
		
		given()
		
		.contentType(ContentType.JSON)
		.headers("Authorization" , "Bearer "+token)
		.body(jsondata)
		.multiPart("file", new File(jpg))
		
		.when()
		 .post(baseUrl+"/v1/employee/updateEmployee")
		
		.then().log().all();
	}
	
	
	
		
		

}
