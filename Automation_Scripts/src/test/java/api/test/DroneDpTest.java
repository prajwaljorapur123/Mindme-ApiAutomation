package api.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.DroneDpEndpoints;
import api.endpoints.LoginEndPoints;
import api.payload.DroneDp;
import api.payload.Login;
import io.restassured.response.Response;

public class DroneDpTest {

	DroneDp Requestpayload;

	@BeforeClass
	public void setupData() {

		Requestpayload = new DroneDp();
		Requestpayload.setCompanyId(LoginTest.CompanyId);
		Requestpayload.setProjectId(CommunityTest.CommunityId);
		Requestpayload.setStatus("pending");
		Requestpayload.setPageNo(0);
		Requestpayload.setPageSize(8);

	}

	// View Request

	@Test(priority = 1)
	public void ViewRequest() {
		Response response = DroneDpEndpoints.ViewRequest(AdminTest.AdminLoginToken, Requestpayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("View request...." + response.getStatusCode(), true);
		} else {
			Reporter.log("View request failed" + response.prettyPrint(), true);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

}
