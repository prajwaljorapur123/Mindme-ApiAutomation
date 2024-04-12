package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
	public static int CompanyId;
	@BeforeClass
	public void setupData()
	{
		
	    LoginPayload = new Login();
		LoginPayload.setEmail("bigboss@yopmail.com");
		LoginPayload.setPassword("Prajwal@123");
	
	}
	
	@Test(priority = 1)
	public void testLogin(ITestContext context)
	{
	Response response = LoginEndPoints.Loginpage(LoginPayload);
	
	 LoginToken =response.jsonPath().getString("data.accessToken");
	context.setAttribute("token", LoginToken);
    
    
    //validations
    
    AssertJUnit.assertEquals(response.getStatusCode(), 200);
    
    
    Reporter.log("login successfull....", true);
	}
	
	@Test(priority = 2)
	public void companyDetails()
	{
	Response response = LoginEndPoints.GetComapany(LoginTest.LoginToken);
	
	
	
	CompanyId = response.jsonPath().get("data.id");
    
    
  //validations
    AssertJUnit.assertEquals(response.getStatusCode(), 200);
    AssertJUnit.assertEquals(response.jsonPath().getString("message"), "200 OK");
    
    Reporter.log("Get Company Details....", true);
	}

}
