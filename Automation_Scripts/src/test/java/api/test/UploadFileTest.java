package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EmployeeEndPoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.Files;

import api.payload.UploadFile.Header;
import api.payload.UploadFile.ProjectDetails;
import api.payload.UploadFile.Sheet;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadFileTest {

	Header header1;
	Header header2;
	Header header3;
	Sheet sheet1;
	ProjectDetails projectDetails;
	Files FilePayload;
	public static int FileId;
	public static int ErrorFileId;

	public static api.payload.FileDetailsByid.FileDetails filedetails;

	@BeforeClass
	public void setupData() {
		FilePayload = new Files();
		FilePayload.setName("");
		FilePayload.setProjectId(ProjectTest.proID);
		FilePayload.setCompanyId(LoginTest.CompanyId);
		FilePayload.setPageNo(0);
		FilePayload.setPageSize(2);

		header1 = new Header();
		header1.setPosition("A1");
		header1.setDataType("Text");
		header1.setHeaderName("sno");

		header2 = new Header();
		header2.setPosition("B1");
		header2.setDataType("Text");
		header2.setHeaderName("name");

		header3 = new Header();
		header3.setPosition("C1");
		header3.setDataType("Text");
		header3.setHeaderName("place");

		sheet1 = new Sheet();
		sheet1.setSheetName("Sheet1");
		sheet1.setValuePosition("A3");
		sheet1.setApproach("TopToBottom");
		sheet1.setHeaders(Arrays.asList(header1, header2, header3));

		projectDetails = new ProjectDetails();
		projectDetails.setProjectId(ProjectTest.proID);
		projectDetails.setCompanyId(LoginTest.CompanyId);
		projectDetails.setCreatedByID(EmployeeTest.CreatedBy);
		projectDetails.setFileUniqueName(null);
		projectDetails.setError(null);
		projectDetails.setFileName("sample.xlsx");
		projectDetails.setSheets(Arrays.asList(sheet1));

	}

	// upload valid file

	@Test(priority = 1)
	public void testUploadfile() {
		Response response = UploadFileEndpoins.UploadFile(LoginTest.LoginToken, projectDetails);

		// validations

		if (response.getStatusCode() == 201
				&& response.jsonPath().getString("message").equals("File Uploaded successfully.")) {
			Reporter.log("upload file...." + response.getStatusCode(), true);
		} else {
			Reporter.log("upload file failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 201, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.", "Correct message returned");


	}

	// upload Error file

	@Test(priority = 2)
	public void testUploadErrorfile() {
		Response response = UploadFileEndpoins.UploadErrorFile(LoginTest.LoginToken, projectDetails);

		// validations
		if (response.getStatusCode() == 201
				&& response.jsonPath().getString("message").equals("File Uploaded successfully.")) {
			Reporter.log("upload error file...." + response.getStatusCode(), true);
		} else {
			Reporter.log("upload error file failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 201, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.", "Correct message returned");
		

	}

	// Get files

	@Test(priority = 3)
	public void Getfiles() {
		Response response = UploadFileEndpoins.GetFiles(LoginTest.LoginToken, FilePayload);

		FileId = response.jsonPath().getInt("data[1].fileId");
		ErrorFileId = response.jsonPath().getInt("data[0].fileId");

		// validations
		if (response.getStatusCode() == 200) {
			Reporter.log("Get files...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Get files failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		

	}

	// Update files

	@Test(priority = 4)
	public void Updatefile() {
		Response response = UploadFileEndpoins.UpdateFile(LoginTest.LoginToken, FileId);

		// validations
		if (response.getStatusCode() == 200
				&& response.jsonPath().getString("message").equals(" Update File Uploaded successfully.")) {
			Reporter.log("update file...." + response.getStatusCode(), true);
		} else {
			Reporter.log("update file failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), " Update File Uploaded successfully.", "Correct message returned");

	}

	// download error file

	@Test(priority = 5)
	public void TestDownloadExcelfile() throws IOException {
		Response response = UploadFileEndpoins.DownloadExcelFile(ErrorFileId);
		
		

		if (response.getStatusCode() == 200) {	

			// Get input stream from response body
			InputStream inputStream = response.getBody().asInputStream();

			// Create output stream to write file
			OutputStream outputStream = new FileOutputStream(
					"C:\\Users\\Prajwal\\OneDrive\\Documents\\mindme_java_test_automation\\Automation_Scripts\\Downloads\\sample_file.xlsx");

			// Write data from input stream to output stream
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			// Close streams
			outputStream.close();
			inputStream.close();
			Reporter.log("excel File downloaded...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Failed to download error excel file. Status code: " + response.getStatusCode(),false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		
		
		

	}

	// upload error file fix

	@Test(priority = 6)
	public void testErrorfilefix() {
		Response response = UploadFileEndpoins.UploadErrorFix(LoginTest.LoginToken, projectDetails, ErrorFileId);

		// validations
		if (response.getStatusCode() == 200
				&& response.jsonPath().getString("message").equals(" Error File Uploaded successfully.")) {
			Reporter.log("Error File fixed...." + response.getStatusCode(), true);
		} else {
			Reporter.log("error file  fix failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), " Error File Uploaded successfully.", "Correct message returned");

	}

	// delete files

	@Test(priority = 7)
	public void Deletefile() {
		Response response = UploadFileEndpoins.DeleteFile(LoginTest.LoginToken, ErrorFileId);

		// validations
		if (response.getStatusCode() == 200) {
			Reporter.log("Delete excel files...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Delete excel file failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");

	}

	// Get file By fileId

	@Test(priority = 8)
	public void GetFileByFileId() {
		Response response = UploadFileEndpoins.GetFileByFileId(LoginTest.LoginToken, FileId);
		filedetails = response.as(api.payload.FileDetailsByid.FileDetails.class);

		// validations
		if (response.getStatusCode() == 200) {
			Reporter.log("GetFileByFileId...." + response.getStatusCode(), true);
		} else {
			Reporter.log("GetFileByFileId failed...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");

	}

}
