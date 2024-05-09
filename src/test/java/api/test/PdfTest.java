package api.test;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.SkipException;
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
		 if (response.getStatusCode() == 201 && response.jsonPath().getString("message").equals("File Uploaded successfully.")) {
				Reporter.log("Upload pdf...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Upload pdf Fail...." + response.prettyPrint(), false);
			}

		}
		
		
		@Test(priority = 2)
		public void Getfiles()
		{
		 Response response =PdfEndpoints.GetFiles( LoginTest.LoginToken , PdfPayload);
		 
		 PdfId =response.jsonPath().getInt("data[0].fileId");
		PdfDeleteId =response.jsonPath().getInt("data[1].fileId");
	
		 
		 //validations
		 if (response.getStatusCode() == 200) {
				Reporter.log("Get Files...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Get Files Fail...." + response.prettyPrint(), false);
			}
		 
		}
		
		//delete files
		
		@Test(priority = 3)
		public void DeletePdf()
		{
		 Response response =PdfEndpoints.DeletePdf( LoginTest.LoginToken , PdfDeleteId);
		
		 //validations
		 if (response.getStatusCode() == 200) {
				Reporter.log("Delete Pdf...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Delete Pdf Fail...." + response.prettyPrint(), false);
			}
		
		}
		
		//download error file
		
				@Test(priority = 4)
				public void TestDownloadExcelfile() throws IOException
				{
				 Response response =UploadFileEndpoins.DownloadExcelFile(PdfId);
				 
				 
				 
				 if (response.getStatusCode() == 200) {
					 
			            // Get input stream from response body
			            InputStream inputStream = response.getBody().asInputStream();
			           
			            // Create output stream to write file
			            OutputStream outputStream = new FileOutputStream("C:/Users/www.abcom.in/Documents/mindme_java_test_automation/Automation_Scripts/Downloads/sample_file.pdf");
			          
			            // Write data from input stream to output stream
			            byte[] buffer = new byte[1024];
			            int bytesRead;
			            while ((bytesRead = inputStream.read(buffer)) != -1) {
			                outputStream.write(buffer, 0, bytesRead);
			            }
			          
			            // Close streams
			            outputStream.close();
			            inputStream.close();
			            System.out.println("pdf File downloaded...."+response.getStatusCode());
			        } 
			        else {
			            System.out.println("Failed to download pdf file. Status code: " + response.getStatusCode());
			        }
				 
				 throw new SkipException("Skip Pdf Download");

				 
				
				}

	

}
