package api.test;

import java.util.Arrays;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EmployeeEndPoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.Files;
import api.payload.UploadFile.Header;
import api.payload.UploadFile.ProjectDetails;
import api.payload.UploadFile.Sheet;
import io.restassured.response.Response;

public class UploadFileTest {
	
	Header header1;
	Header header2;
	Header header3;
	Sheet sheet1;
	ProjectDetails projectDetails;
	Files FilePayload;
	public static int FileId;
	
	
	@BeforeClass
	public void setupData()
	{
		FilePayload = new Files();
		FilePayload.setName("");
		FilePayload.setProjectId(ProjectTest.proID);
		FilePayload.setCompanyId(LoginTest.CompanyId);
		FilePayload.setPageNo(0);
		FilePayload.setPageSize(2);
		
		
		
		 header1 = new Header();
        header1.setPosition("A1");
        header1.setDataType("Number");
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
	
	//upload file
	
	@Test(priority = 1)
	public void testUploadfile()
	{
	 Response response =UploadFileEndpoins.UploadFile( LoginTest.LoginToken , projectDetails);
	
	 
	
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 201);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.");
	 
	 Reporter.log("Upload File...." , true);
	}
	
	//Get files
	
	@Test(priority = 2)
	public void Getfiles()
	{
	 Response response =UploadFileEndpoins.GetFiles( LoginTest.LoginToken , FilePayload);
	 
	 
	FileId=response.jsonPath().getInt("data[0].fileId");
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	
	 
	 Reporter.log("Get Files...." , true);
	}

}
