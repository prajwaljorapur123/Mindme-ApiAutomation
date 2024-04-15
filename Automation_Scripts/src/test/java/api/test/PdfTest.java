package api.test;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.PdfEndpoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.Pdf;
import io.restassured.response.Response;



  

  public class PdfTest {
	  
	  Pdf PdfPayload;
	  int PdfDeleteId;
	  int PdfId;
	
	@BeforeClass
	public void setupData()
	{
		
		PdfPayload = new Pdf();
		PdfPayload.setProjectId(ProjectTest.proID);
		PdfPayload.setCompanyId(LoginTest.CompanyId);
		PdfPayload.setCreatedByID(EmployeeTest.CreatedBy);
		PdfPayload.setFileUniqueName("");
		PdfPayload.setError("");
		PdfPayload.setFileName("Revised RV Lot Rules and Regulations.doc.pdf");
		PdfPayload.setPageNo(0);
		PdfPayload.setPageSize(8);
	}
	
	//upload pdf file
	
		@Test(priority = 1,invocationCount = 2)
		public void testUploadpdf()
		{
		 Response response =PdfEndpoints.UploadPdf( LoginTest.LoginToken , PdfPayload);
		
		 
		
		
		
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 201);
		 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "File Uploaded successfully.");
		 
		 Reporter.log("Upload pdf...." , true);
		}
		
		
		@Test(priority = 2)
		public void Getfiles()
		{
		 Response response =PdfEndpoints.GetFiles( LoginTest.LoginToken , PdfPayload);
		 
		 PdfId =response.jsonPath().getInt("data[0].fileId");
		PdfDeleteId =response.jsonPath().getInt("data[1].fileId");
	
		 
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		 
		 Reporter.log("Get Files...." , true);
		}
		
		//delete files
		
		@Test(priority = 3)
		public void DeletePdf()
		{
		 Response response =PdfEndpoints.DeletePdf( LoginTest.LoginToken , PdfDeleteId);
		
		 //validations
		 AssertJUnit.assertEquals(response.getStatusCode(), 200);
		 
		 Reporter.log("Delete Pdf...." , true);
		}
	

}
