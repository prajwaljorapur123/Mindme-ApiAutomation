package api.test;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.PhraseEndPoints;
import api.endpoints.SearchEndpoints;
import api.payload.FileSearch;
import api.payload.Phrase;

import io.restassured.response.Response;

public class SearchTest {

	FileSearch SearchPayload;
	FileSearch PdfSearchPayload;

	@BeforeClass
	public void setupData() {
		SearchPayload = new FileSearch();
		SearchPayload.setProjectId(ProjectTest.proID);
		SearchPayload.setFileId(UploadFileTest.FileId);
		SearchPayload.setIsAbbreviation("");
		SearchPayload.setSearchText("prajwal");
		SearchPayload.setFileDetailsModel(UploadFileTest.filedetails);

		PdfSearchPayload = new FileSearch();

		PdfSearchPayload.setProjectId(ProjectTest.proID);
		PdfSearchPayload.setSearchText("park");

	}

	// search excel file

	@Test(priority = 1)
	public void testSearchExcelData() {
		Response response = SearchEndpoints.Searchexceldata(SearchPayload, LoginTest.LoginToken);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Search excel data...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Search excel data Fail...." + response.prettyPrint(), false);
		}

	}

	// search pdf file

	@Test(priority = 2)
	public void testSearchPdfData() {

		Response response = SearchEndpoints.Searchpdfdata(LoginTest.LoginToken, PdfSearchPayload);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Search pdf data...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Search pdf data Fail...." + response.prettyPrint(), false);
		}

	}

	// dashboard count

	@Test(priority = 3)
	public void testDashboardCount() {
		Response response = SearchEndpoints.DashboardCount(LoginTest.LoginToken);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Dashboard count...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Dashboard count Fail...." + response.prettyPrint(), false);
		}

		throw new SkipException("Skip dashboard");

	}

}
