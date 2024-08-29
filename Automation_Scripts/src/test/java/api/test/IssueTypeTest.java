package api.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.IssueTypeEndpoints;
import api.endpoints.LoginEndPoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.IssueType;
import api.payload.Login;
import io.restassured.response.Response;

public class IssueTypeTest {

	IssueType IssuePayload;
	Faker faker;
	public static String IssueTypeName;

	@BeforeClass
	public void setupData() {

		faker = new Faker();

		IssuePayload = new IssueType();
		IssuePayload.setSuperIssueType("Exterior Maintenance Issues");
		IssuePayload.setIssueType(faker.name().title() + " issues");
		IssuePayload.setIsActive(true);

	}

	// upload Issue Type file

	@Test(priority = 1)
	public void testUploadIssueTypefile() {
		String filePath = "src/test/resources/IssueType.xlsx";
		Response response = IssueTypeEndpoints.UploadIssueTypeFile(AdminTest.AdminLoginToken, filePath);
         
		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("upload IssueType...." + response.getStatusCode(), true);
		} else {
			Reporter.log("upload IssueType failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}
	
	//Upload issueType with Invalid File (Unsupported file type)
	
	@Test(priority = 2)
	public void testUploadIssueTypefileWithInvalidFile() {
		String filePath = "src/test/resources/Issue1.png";
		Response response = IssueTypeEndpoints.UploadIssueTypeFile(AdminTest.AdminLoginToken, filePath);
		
		
		// validations

		if (response.getStatusCode() == 400 ) {
			Reporter.log("upload IssueType with Invalid File...." + response.getStatusCode(), true);
		} else {
			Reporter.log("upload IssueType with Invalid File failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		

	}
	
	//Upload issueType with Invalid Headers (Headers do not match the expected format)
	
		@Test(priority = 3)
		public void testUploadIssueTypefileWithInvalidHeaders() {
			String filePath = "src/test/resources/sample.xlsx";
			Response response = IssueTypeEndpoints.UploadIssueTypeFile(AdminTest.AdminLoginToken, filePath);
			
			
			// validations

			if (response.getStatusCode() == 400 ) {
				Reporter.log("upload IssueType with Invalid Headers...." + response.getStatusCode(), true);
			} else {
				Reporter.log("upload IssueType with Invalid Headers failed" + response.prettyPrint(), false);
			}
			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			

		}
		
		
		// upload Issue Type file with user account
		//expected  - You are not privileged for this operation

		@Test(priority = 4)
		public void testUploadIssueTypewithUser() {
			String filePath = "src/test/resources/IssueType.xlsx";
			Response response = IssueTypeEndpoints.UploadIssueTypeFile(LoginTest.LoginToken, filePath);
	        
			// validations

			if (response.getStatusCode() == 400) {
				Reporter.log("upload IssueType with user account...." + response.getStatusCode(), true);
			} else {
				Reporter.log("upload IssueType with user account failed" + response.prettyPrint(), false);
			}
			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			

		}
		

	// Test Create Issue Type

	@Test(priority = 5)
	public void CreateIssueType() {
		Response response = IssueTypeEndpoints.CreateIssueType(AdminTest.AdminLoginToken, IssuePayload);

		IssueTypeName = response.jsonPath().getString("data.issueType");

		if (response.getStatusCode() == 200) {
			Reporter.log("Create IssueType...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Create IssueTypeFail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

	// Test Get Issue Type

	@Test(priority = 6)
	public void GetIssueType() {
		Response response = IssueTypeEndpoints.GetIssueType(AdminTest.AdminLoginToken);

		if (response.getStatusCode() == 200) {
			Reporter.log("Get IssueType...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Get IssueTypeFail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

	// Test Create Issue Type with same name

	@Test(priority = 7)
	public void CreateIssueTypeWithSameName() {
		IssuePayload.setIssueType(IssueTypeName);

		Response response = IssueTypeEndpoints.CreateIssueType(AdminTest.AdminLoginToken, IssuePayload);
		

		if (response.getStatusCode() == 400) {
			Reporter.log("Create IssueType With Same Name...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Create IssueType With Same Name Fail" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");

	}

}
