package api.test;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.AdminEndpoints;
import api.endpoints.LoginEndPoints;
import api.payload.Admin;
import api.payload.Login;
import io.restassured.response.Response;

public class AdminTest {

	Admin AdminLoginPayload;
	public static String AdminLoginToken;

	@BeforeClass
	public void setupData() {

		AdminLoginPayload = new Admin();
		AdminLoginPayload.setEmail("itachi@yopmail.com");
		AdminLoginPayload.setPassword("Leaf@123");

	}

	// Admin Login Test

	@Test(priority = 1)
	public void TestAdminLogin() {
		Response response = AdminEndpoints.AdminLogin(AdminLoginPayload);

		AdminLoginToken = response.jsonPath().getString("data.accessToken");
		

		if (response.getStatusCode() == 200) {
			Reporter.log("AdminLogin successfull...." + response.getStatusCode(), true);

		} else {
			Reporter.log("AdminLogin failed" + response.prettyPrint(), false);
		}

	}
	
	// Admin dashboard count

		@Test(priority = 2)
		public void TestAdminDashboard() {
			Response response = AdminEndpoints.Admindashboard(AdminLoginToken);
			response.prettyPrint();

			if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
				Reporter.log("Admin Dashboard Count ...." + response.getStatusCode(), true);

			} else {
				Reporter.log("Admin dashboard count fail" + response.prettyPrint(), false);
			}

		}

}
