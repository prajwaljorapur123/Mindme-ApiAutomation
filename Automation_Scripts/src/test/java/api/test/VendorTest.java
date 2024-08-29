package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.IssueTypeEndpoints;
import api.endpoints.VendorEndpoints;
import api.payload.IssueType;
import api.payload.Vendor;
import io.restassured.response.Response;

public class VendorTest {
	
	Vendor VendorPayload;
	
	@BeforeClass
	public void setupData() {

		VendorPayload = new Vendor();
		VendorPayload.setCompanyId(LoginTest.CompanyId);
		VendorPayload.setWorkType(Arrays.asList());;
		VendorPayload.setSearchVendorText("");
		VendorPayload.setIssueSummary("");
		VendorPayload.setPageNo("0");
		VendorPayload.setPageSize("10");
		

	}

	// upload Vendor Details

	@Test(priority = 1)
	public void TestUploadVendorDetails() {
		String filePath = "src/test/resources/VendorUpload.xlsx";
		Response response = VendorEndpoints.UploadVendorDetails(LoginTest.LoginToken, filePath);
		
         
		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Upload Vendor details...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Upload Vendor Details failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}
	
	// upload Vendor Details with invalid headers

		@Test(priority = 2)
		public void TestUploadVendorWithInvalidHeaders() {
			String filePath = "src/test/resources/sample.xlsx";
			Response response = VendorEndpoints.UploadVendorDetails(LoginTest.LoginToken, filePath);
			
	         
			// validations

			if (response.getStatusCode() == 400 && response.jsonPath().getString("error").equals("Invalid file format. Headers do not match the expected format.")) {
				Reporter.log("Upload Vendor with invalid Headers...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Upload Vendor with invalid Headers failed" + response.prettyPrint(), false);
			}
			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			Assert.assertEquals(response.jsonPath().getString("error"), "Invalid file format. Headers do not match the expected format.", "Correct message returned");

		}
		
		// upload Vendor Details with invalid file

				@Test(priority = 3)
				public void TestUploadVendorWithInvalidFile() {
					String filePath = "src/test/resources/Issue1.png";
					Response response = VendorEndpoints.UploadVendorDetails(LoginTest.LoginToken, filePath);
					
			         
					// validations

					if (response.getStatusCode() == 400 && response.jsonPath().getString("error").equals("Unsupported file type. Please upload an Excel or CSV file.")) {
						Reporter.log("Upload Vendor with invalid file...." + response.getStatusCode(), true);
					} else {
						Reporter.log("Upload Vendor with invalid file failed" + response.prettyPrint(), false);
					}
					Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
					Assert.assertEquals(response.jsonPath().getString("error"), "Unsupported file type. Please upload an Excel or CSV file.", "Correct message returned");

				}
				
				
				// upload Vendor Details with large file

			//	@Test(priority = 4)
				public void TestUploadVendorWithLargeFile() {
					String filePath = "src/test/resources/Issue1.png";
					Response response = VendorEndpoints.UploadVendorDetails(LoginTest.LoginToken, filePath);
					
			         
					// validations

					if (response.getStatusCode() == 400 && response.jsonPath().getString("error").equals("Unsupported file type. Please upload an Excel or CSV file.")) {
						Reporter.log("Upload Vendor with Large file...." + response.getStatusCode(), true);
					} else {
						Reporter.log("Upload Vendor with Large file failed" + response.prettyPrint(), false);
					}
					Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
					Assert.assertEquals(response.jsonPath().getString("error"), "Unsupported file type. Please upload an Excel or CSV file.", "Correct message returned");

				}
	
	
	// Test Get Vendor List

		@Test(priority = 5)
		public void GetIssueType() {
			Response response = VendorEndpoints.GetVendors(LoginTest.LoginToken, VendorPayload);
			

			if (response.getStatusCode() == 200) {
				Reporter.log("Get Vendors...." + response.getStatusCode(), true);

			} else {
				Reporter.log("Get Vendors failed" + response.prettyPrint(), false);
			}
			Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
			Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

		}

}
