package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.DroneDpEndpoints;
import api.endpoints.LoginEndPoints;
import api.endpoints.PdfEndpoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.DroneDp;
import api.payload.Files;
import api.payload.Login;
import api.payload.Pdf;
import api.payload.UploadFile.Header;
import api.payload.UploadFile.ProjectDetails;
import api.payload.UploadFile.Sheet;
import io.restassured.response.Response;

public class DroneDpTest {

	DroneDp Requestpayload;
	
	Header header1;
	Header header2;
	Header header3;
	Header header4;
	Header header5;
	Header header6;
	Header header7;
	Header header8;
	Header header9;
	Header header10;
	Header header11;
	Sheet sheet1;
	ProjectDetails projectDetails;
	
	Pdf PdfPayload;
	

	@BeforeClass
	public void setupData() {

		Requestpayload = new DroneDp();
		Requestpayload.setCompanyId(LoginTest.CompanyId);
		Requestpayload.setSearchText(null);
	//	Requestpayload.setProjectId(CommunityTest.CommunityId);
		Requestpayload.setStatus("pending");
		Requestpayload.setPageNo(0);
		Requestpayload.setPageSize(8);
		
		header1 = new Header();
		header1.setPosition("A1");
		header1.setDataType("Number");
		header1.setHeaderName("IssueId");

		header2 = new Header();
		header2.setPosition("B1");
		header2.setDataType("Number");
		header2.setHeaderName("IssueNumber");

		header3 = new Header();
		header3.setPosition("C1");
		header3.setDataType("Text");
		header3.setHeaderName("IssueSummary");
		
		header4 = new Header();
		header4.setPosition("D1");
		header4.setDataType("Text");
		header4.setHeaderName("IssueType");

		header5 = new Header();
		header5.setPosition("E1");
		header5.setDataType("Text");
		header5.setHeaderName("IssueStatus");

		header6 = new Header();
		header6.setPosition("F1");
		header6.setDataType("Text");
		header6.setHeaderName("IssueSeverity");
		
		header7 = new Header();
		header7.setPosition("G1");
		header7 .setDataType("Number");
		header7.setHeaderName("IssueCostOfRepair");

		header8 = new Header();
		header8.setPosition("H1");
		header8.setDataType("Date Time");
		header8.setHeaderName("IssueDateCreated");

		header9 = new Header();
		header9.setPosition("I1");
		header9.setDataType("Date Time");
		header9.setHeaderName("IssueDateModified");
		
		header10 = new Header();
		header10.setPosition("J1");
		header10.setDataType("Text");
		header10.setHeaderName("IssueCreatedBy");

		header11 = new Header();
		header11.setPosition("K1");
		header11.setDataType("Text");
		header11.setHeaderName("IssueLocation");

		sheet1 = new Sheet();
		sheet1.setSheetName("Pollard ct Road, Los Gatos");
		sheet1.setValuePosition("A2");
		sheet1.setApproach("TopToBottom");
		sheet1.setHeaders(Arrays.asList(header1, header2, header3,header4, header5, header6,header7, header8, header9,header10, header11));

		projectDetails = new ProjectDetails();
		projectDetails.setProjectId(CommunityTest.CommunityId);
		projectDetails.setCompanyId(LoginTest.CompanyId);
		projectDetails.setCreatedByID(EmployeeTest.CreatedBy);
		projectDetails.setRequestRefID(CommunityTest.RequestId);
		projectDetails.setFileUniqueName(null);
		projectDetails.setError(null);
		projectDetails.setFileName("DvsDemo.xlsx");
		projectDetails.setSheets(Arrays.asList(sheet1));
		
		
		PdfPayload = new Pdf();
		PdfPayload.setProjectId(CommunityTest.CommunityId);
		PdfPayload.setCompanyId(LoginTest.CompanyId);
		PdfPayload.setCreatedByID(EmployeeTest.CreatedBy);
		PdfPayload.setRequestRefID(CommunityTest.RequestId);
		PdfPayload.setFileUniqueName("");
		PdfPayload.setError("");
		PdfPayload.setFileName("Dvs pdf.pdf");
		

		
		
		
		

	}
	
	// Get All Companies for drone dp.

		@Test(priority = 1)
		public void GetAllCompanies() {
			
			Response response = DroneDpEndpoints.GetAllCompanies(AdminTest.AdminLoginToken, Requestpayload);
			
			// validations

			if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
				Reporter.log("GetAllCompanies...." + response.getStatusCode(), true);
			} else {
				Reporter.log("GetAllCompanies failed" + response.prettyPrint(), true);
			}
			Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
			Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

		}
		
	//  Request Count

			@Test(priority = 2)
			public void RequestCount() {
				Response response = DroneDpEndpoints.RequestCount(AdminTest.AdminLoginToken);
				

				// validations

				if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
					Reporter.log("RequestCount...." + response.getStatusCode(), true);
				} else {
					Reporter.log("RequestCount failed" + response.prettyPrint(), true);
				}
				Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
				Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

			}

	// View Request

	@Test(priority = 3)
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
	
	//Upload Excel file for request.
	
	@Test(priority = 4)
	public void testUploadExcelFileForRequest() {
		Response response = DroneDpEndpoints.UploadFileForRequest( projectDetails);
		

		// validations

		if (response.getStatusCode() == 201
				&& response.jsonPath().getString("message").equals("File Uploaded successfully.")) {
			Reporter.log("upload file for request...." + response.getStatusCode(), true);
		} else {
			Reporter.log("upload file for request failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 201, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.", "Correct message returned");


	}
	
	// upload pdf file for request

		@Test(priority = 5)
		public void TestUploadPdfForRequest() {
			Response response = DroneDpEndpoints.UploadPdfForRequest( PdfPayload);
            
			// validations
			if (response.getStatusCode() == 201
					&& response.jsonPath().getString("message").equals("File Uploaded successfully.")) {
				Reporter.log("Upload pdf for request...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Upload pdf for request Fail...." + response.prettyPrint(), false);
			}
			Assert.assertEquals(response.getStatusCode(), 201, "Correct status code returned");
			Assert.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.",
					"Correct message returned");

		}
		
		
}
