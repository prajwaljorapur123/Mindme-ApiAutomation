package api.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.AdminEndpoints;
import api.payload.Admin;
import api.payload.AdminCompany;
import io.restassured.response.Response;

public class AdminTest {

	Admin AdminLoginPayload;

	public static String AdminLoginToken;
	AdminCompany searchpayload;

	@BeforeClass
	public void setupData() {

		AdminLoginPayload = new Admin();
		AdminLoginPayload.setEmail("itachi@yopmail.com");
		AdminLoginPayload.setPassword("Leaf@123");

		searchpayload = new AdminCompany();
		searchpayload.setName("");
		searchpayload.setPageNo(0);
		searchpayload.setPageSize(8);
		searchpayload.setSearchType(0);

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
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");

	}

	// Admin dashboard count

	@Test(priority = 2)
	public void TestAdminDashboard() {
		Response response = AdminEndpoints.Admindashboard(AdminLoginToken);

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Admin Dashboard Count ...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Admin dashboard count fail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

	// About to expire companies list

	@Test(priority = 3)
	public void TestAboutToExpirecompanies() {
		Response response = AdminEndpoints.AboutToexpireCompanies(AdminLoginToken, this.searchpayload.getName(),
				this.searchpayload.getPageNo(), this.searchpayload.getPageSize(), this.searchpayload.getSearchType());

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("list of About to expire companies...." + response.getStatusCode(), true);

		} else {
			Reporter.log("list of About to expire companies fail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

	@Test(priority = 4)
	public void TestExpiredcompanies() {
		searchpayload.setSearchType(1);
		Response response = AdminEndpoints.AboutToexpireCompanies(AdminLoginToken, this.searchpayload.getName(),
				this.searchpayload.getPageNo(), this.searchpayload.getPageSize(), this.searchpayload.getSearchType());

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("list of expired companies...." + response.getStatusCode(), true);

		} else {
			Reporter.log("list of expired companies fail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}
}
