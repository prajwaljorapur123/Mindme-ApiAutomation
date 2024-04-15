package api.test;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.PhraseEndPoints;
import api.endpoints.SearchEndpoints;
import api.payload.FileSearch;
import api.payload.Phrase;

import io.restassured.response.Response;

public class SearchTest {
	
	FileSearch SearchPayload;
	FileSearch	PdfSearchPayload;
	
	
	@BeforeClass
	public void setupData()
	{
		SearchPayload=new FileSearch();
		SearchPayload.setProjectId(ProjectTest.proID);
		SearchPayload.setFileId(UploadFileTest.FileId);
		SearchPayload.setIsAbbreviation("");
		SearchPayload.setSearchText("prajwal");
		SearchPayload.setFileDetailsModel(UploadFileTest.filedetails);
		
		PdfSearchPayload=new FileSearch();
		
		PdfSearchPayload.setProjectId(ProjectTest.proID);
		PdfSearchPayload.setSearchText("park");
		
		
	}
	
	//search excel file
	
	@Test(priority = 1)
	public void testSearchExcelData()
	{
	 Response response = SearchEndpoints.Searchexceldata(SearchPayload, LoginTest.LoginToken);
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
	 
	 Reporter.log("search excel data...." , true);
	}
	
	
	//search pdf file 
	
	@Test(priority = 2)
	public void testSearchPdfData()
	{
		
	 Response response = SearchEndpoints.Searchpdfdata(LoginTest.LoginToken , PdfSearchPayload);
	 
	 response.prettyPrint();
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
	 
	 Reporter.log("search pdf data...." , true);
	}
	
	//dashboard count 
	
	@Test(priority = 3)
	public void testDashboardCount()
	{
	 Response response = SearchEndpoints.DashboardCount(LoginTest.LoginToken);
	 
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "200 OK");
	 
	 Reporter.log("dashboard count...." , true);
	}
	
	

	
	
}
