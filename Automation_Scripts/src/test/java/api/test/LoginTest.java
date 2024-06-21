package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
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
	public void setupData() {

		LoginPayload = new Login();
		LoginPayload.setEmail("bigboss@yopmail.com");
		LoginPayload.setPassword("Prajwaljhs@123");

	}

	// Login Test

	@Test(priority = 1)
	public void testLogin() {
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		LoginToken = response.jsonPath().getString("data.accessToken");

		if (response.getStatusCode() == 200) {
			Reporter.log("Login successfull...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
	

	}

	// company test

	@Test(priority = 2)
	public void companyDetails() {
		Response response = LoginEndPoints.GetComapany(LoginTest.LoginToken);

		CompanyId = response.jsonPath().get("data.id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("company details...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Company details failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

}
