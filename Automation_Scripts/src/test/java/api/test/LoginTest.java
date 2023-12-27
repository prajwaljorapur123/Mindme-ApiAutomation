package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.LoginEndPoints;
import api.payload.Employee;
import api.payload.Login;
import io.restassured.response.Response;

public class LoginTest {
	Login LoginPayload;
	public static String LoginToken;
	
	@BeforeClass
	public void setupData()
	{
		
	 LoginPayload = new Login();
		LoginPayload.setEmail("dagar@yopmail.com");
		LoginPayload.setPassword("Prajwal@123");
	
	}
	
	@Test
	public void testLogin(ITestContext context)
	{
	Response response = LoginEndPoints.Loginpage(LoginPayload);
	
	 LoginToken =response.jsonPath().getString("data.accessToken");
	context.setAttribute("token", LoginToken);
    response.prettyPrint();
    Reporter.log("login successfull....", true);
	}

}
