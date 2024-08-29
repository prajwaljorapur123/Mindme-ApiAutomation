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
		LoginPayload.setEmail("Automation@yopmail.com");
		LoginPayload.setPassword("Prajwal@123");

	}

	// Login Test

	@Test(priority = 1)
	public void LoginWithValidCredentials() {
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		LoginToken = response.jsonPath().getString("data.accessToken");

		if (response.getStatusCode() == 200) {
			Reporter.log("Login with valid credentials...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login with valid credentials Fail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");

	}

	// Login with invalid credentials

	@Test(priority = 2)
	public void LoginWithInvalidcredentials() {
		LoginPayload.setEmail("bigboss@yopmail.com");
		LoginPayload.setPassword("Prajal@***");
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		// validations
		if (response.getStatusCode() == 400 && response.jsonPath().getString("error").equals("Bad credentials")) {
			Reporter.log("Login with bad credentials...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login with bad credentails failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("error"), "Bad credentials", "Correct message returned");
	}

	// Login with invalid email

	@Test(priority = 3)
	public void LoginWithInvalidEmail() {
		LoginPayload.setEmail("bigbossyopmail.com");
		LoginPayload.setPassword("Prajal@***");
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		// validations
		if (response.getStatusCode() == 400
				&& response.jsonPath().getString("error.email").equals("must be a well-formed email address")) {
			Reporter.log("Login with Invalid email...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login with Invalid email failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("error.email"), "must be a well-formed email address",
				"Correct message returned");
	}

	// Login with Empty values

	@Test(priority = 4)
	public void LoginWithEmptyValues() {
		LoginPayload.setEmail("");
		LoginPayload.setPassword("");
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		// validations
		if (response.getStatusCode() == 400
				&& response.jsonPath().getString("error.email").equals("length must be between 5 and 50")
				&& response.jsonPath().getString("error.password").equals("length must be between 5 and 2147483647")) {
			Reporter.log("Login with Empty Values...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login with Empty values failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("error.email"), "length must be between 5 and 50",
				"Correct message returned");
		Assert.assertEquals(response.jsonPath().getString("error.password"), "length must be between 5 and 2147483647",
				"Correct message returned");
	}

	// Login with Null values

	@Test(priority = 5)
	public void LoginWithNullValues() {
		LoginPayload.setEmail(null);
		LoginPayload.setPassword(null);
		Response response = LoginEndPoints.Loginpage(LoginPayload);

		// validations
		if (response.getStatusCode() == 400 && response.jsonPath().getString("error.email").equals("must not be null")
				&& response.jsonPath().getString("error.password").equals("must not be null")) {
			Reporter.log("Login with null Values...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Login with null values failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("error.email"), "must not be null",
				"Correct message returned");
		Assert.assertEquals(response.jsonPath().getString("error.password"), "must not be null",
				"Correct message returned");
	}

	// company test

	@Test(priority = 6)
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
