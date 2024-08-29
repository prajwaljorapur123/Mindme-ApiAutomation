package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.DvsDataSearchEndpoints;
import api.endpoints.SearchEndpoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.DataDvs;
import api.payload.DvsFilter;
import api.payload.Files;
import io.restassured.response.Response;

public class DvsDataSearchTest {
	Files FilePayload;
	public static api.payload.FileDetailsByid.FileDetails Getfiledetails;
	public static int FileId;
	DataDvs DvsPayload;
	DvsFilter filter1;
	DvsFilter filter2;

	@BeforeClass
	public void setupData() {

		FilePayload = new Files();
		FilePayload.setName("");
		FilePayload.setProjectId(CommunityTest.CommunityId);
		FilePayload.setCompanyId(LoginTest.CompanyId);
		FilePayload.setPageNo(0);
		FilePayload.setPageSize(10);

		filter1 = new DvsFilter();
		filter2 = new DvsFilter();

		DvsPayload = new DataDvs();
		DvsPayload.setProjectId(CommunityTest.CommunityId);
		DvsPayload.setIsCommunity(true);
		DvsPayload.setIsAbbreviation("");
		DvsPayload.setSearchText("chicago");
		DvsPayload.setPageNo(0);
		DvsPayload.setPageSize(8);
		DvsPayload.setFileType("dvs");

	}

	// Dvs data search

	@Test(priority = 1)
	public void DvsDataSearch() {
		// GetFiles
		Response GetFiles = UploadFileEndpoins.GetFiles(LoginTest.LoginToken, FilePayload);
		FileId = GetFiles.jsonPath().getInt("data[1].fileId");

		// GetFileByfileid
		Response getfileid = UploadFileEndpoins.GetFileByFileId(LoginTest.LoginToken, FileId);

		Getfiledetails = getfileid.as(api.payload.FileDetailsByid.FileDetails.class);

		DvsPayload.setFileDetailsModel(DvsDataSearchTest.Getfiledetails);

		Response response = DvsDataSearchEndpoints.DvsDataSearch(DvsPayload, LoginTest.LoginToken);
		
		
		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Dvs Search data...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Dvs Search data Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Dvs Filters

	@Test(priority = 2)
	public void DvsFilters() {
		// GetFiles
		Response GetFiles = UploadFileEndpoins.GetFiles(LoginTest.LoginToken, FilePayload);
		FileId = GetFiles.jsonPath().getInt("data[1].fileId");

		// GetFileByfileid
		Response getfileid = UploadFileEndpoins.GetFileByFileId(LoginTest.LoginToken, FileId);

		Getfiledetails = getfileid.as(api.payload.FileDetailsByid.FileDetails.class);

		filter1.setFieldName("IssueType");
		filter1.setOperator("IN");
		filter1.setValue(Arrays.asList("Termite Issues"));

		filter2.setFieldName("IssueStatus");
		filter2.setOperator("IN");
		filter2.setValue(Arrays.asList("Closed"));

		DvsPayload.setSearchText("");
		DvsPayload.setFiltersDataReq(Arrays.asList(filter1));
		DvsPayload.setFileDetailsModel(DvsDataSearchTest.Getfiledetails);

		Response response = DvsDataSearchEndpoints.DvsDataSearch(DvsPayload, LoginTest.LoginToken);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Dvs Filters...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Dvs Filters Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

}
