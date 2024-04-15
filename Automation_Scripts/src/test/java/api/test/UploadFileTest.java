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
import io.restassured.response.ResponseBody;

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
	
	//upload valid file
	
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
	
	@Test(priority = 3)
	public void Getfiles()
	{
	 Response response =UploadFileEndpoins.GetFiles( LoginTest.LoginToken , FilePayload);
	 
	 
	FileId=response.jsonPath().getInt("data[1].fileId");
	ErrorFileId=response.jsonPath().getInt("data[0].fileId");
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	
	 
	 Reporter.log("Get Files...." , true);
	}
	
	//Update files
	
		@Test(priority = 4)
		public void Updatefile()
		{
		 Response response =UploadFileEndpoins.UpdateFile( LoginTest.LoginToken , FileId);
		 
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		 AssertJUnit.assertEquals(response.jsonPath().getString("message"), " Update File Uploaded successfully.");
		
		 
		 Reporter.log("Update File...." , true);
		}
		
		//upload Error file
		
		@Test(priority = 2)
		public void testUploadErrorfile()
		{
		 Response response =UploadFileEndpoins.UploadErrorFile( LoginTest.LoginToken , projectDetails);
		
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 201);
		 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.");
		 
		 Reporter.log("Upload Error File...." , true);
		}
		
		@Test(priority = 5)
		public void testErrorfilefix()
		{
		 Response response =UploadFileEndpoins.UploadErrorFix( LoginTest.LoginToken , projectDetails , ErrorFileId);
	
		
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		 AssertJUnit.assertEquals(response.jsonPath().getString("message"), " Error File Uploaded successfully.");
		 
		 Reporter.log("Error File Fix...." , true);
		}
		
		//delete files
		
			@Test(priority = 6)
			public void Deletefile()
			{
			 Response response =UploadFileEndpoins.DeleteFile( LoginTest.LoginToken , ErrorFileId);
			
			  
			 //validations
			 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		//	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), " Update File Uploaded successfully.");
			
			 
			 Reporter.log("Delete File...." , true);
			}
			
			//Get file By fileId
			
			@Test(priority = 7)
			public void GetFileByFileId()
			{
			 Response response =UploadFileEndpoins.GetFileByFileId( LoginTest.LoginToken , FileId);
			 filedetails  = response.as(api.payload.FileDetailsByid.FileDetails.class);
			
			
			
			  
			 //validations
			 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
			
			 
			 Reporter.log("GetFileByFileId...." , true);
			}

}
