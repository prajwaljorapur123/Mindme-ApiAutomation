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
	
	
	@BeforeClass
	public void setupData()
	{
		SearchPayload=new FileSearch();
		SearchPayload.setProjectId(ProjectTest.proID);
		SearchPayload.setFileId(UploadFileTest.FileId);
		SearchPayload.setIsAbbreviation("");
		SearchPayload.setSearchText("prajwal");
		SearchPayload.setFileDetailsModel(UploadFileTest.filedetails);
	}
	
	@Test(priority = 1)
	public void testSearchExcelData()
	{
	 Response response = SearchEndpoints.Searchexceldata(SearchPayload, LoginTest.LoginToken);
	 
	response.prettyPrint();
	 
	
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
	 
	 Reporter.log("search excel data...." , true);
	}

	
	
}
