package api.test;

import java.util.Arrays;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EmployeeEndPoints;
import api.endpoints.UploadFileEndpoins;
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
	
	
	
	@BeforeClass
	public void setupData()
	{
		
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
        projectDetails.setProjectId("112");
        projectDetails.setCompanyId("7");
        projectDetails.setCreatedByID("43");
        projectDetails.setFileUniqueName(null);
        projectDetails.setError(null);
        projectDetails.setFileName("sample.xlsx");
        projectDetails.setSheets(Arrays.asList(sheet1));
			
	}
	
	@Test(priority = 1)
	public void testUploadfile()
	{
	 Response response =UploadFileEndpoins.UploadFile( LoginTest.LoginToken , projectDetails);
	 response.prettyPrint();
	 
	
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 201);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.");
	 
	 Reporter.log("File Uploaded successfully." , true);
	}

}
