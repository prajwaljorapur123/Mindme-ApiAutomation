package api.test;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.LoginEndPoints;
import api.payload.Login;
import io.restassured.response.Response;

public class AdminTest {
	
	Login AdminLoginPayload;
	public static String AdminLoginToken;
	
	@BeforeClass
	public void setupData()
	{
		
	    AdminLoginPayload = new Login();
		AdminLoginPayload.setEmail("itachi@yopmail.com");
		AdminLoginPayload.setPassword("Leaf@123");
	
	}
	
	
	//Admin Login Test
	
	@Test(priority = 1)
	public void TestAdminLogin()
	{
	Response response = LoginEndPoints.Loginpage(AdminLoginPayload);
	response.prettyPrint();
	
	 AdminLoginToken =response.jsonPath().getString("data.accessToken");
	  //context.setAttribute("token", AdminLoginToken);
    
	 if (response.getStatusCode()==200 )
     {
		 Reporter.log("AdminLogin successfull...." + response.getStatusCode(),true);
	   
      }
     else
     {
    	 Reporter.log("AdminLogin failed" + response.prettyPrint(),false);
      }
   
	}

}
