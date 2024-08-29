package api.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.CommunityEndpoints;
import api.endpoints.ProjectEndPoints;
import api.payload.Community;
import api.payload.Project;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CommunityTest {

	Faker faker;
	Community communitypayload;
	Community RequestPayload;
	public static int CommunityId;
	public static int RequestId;
	Community Overviewpayload;
	String CommunityName;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		communitypayload = new Community();
		communitypayload.setProjectName(faker.name().title());
		communitypayload.setTeamId(TeamTest.teamsId);
		communitypayload.setIsCommunity(true);
		communitypayload.setAddress("Pollard Ct Road, Los Gatos");
		communitypayload.setCity("Los Gatos");
		communitypayload.setState("California (CA)");
		communitypayload.setPostalCode("95032");

		RequestPayload = new Community();
		

		Overviewpayload = new Community();

	}

	// Create Community.

	@Test(priority = 1)
	public void TestCreateCommunity() {

		Response response = CommunityEndpoints.CreateCommunity(LoginTest.LoginToken, communitypayload);
		CommunityId = response.jsonPath().getInt("data.projectDetails.id");
		CommunityName =	response.jsonPath().getString("data.projectDetails.projectName");
		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("community Created...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Community Created Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Create Community with Existing Name

	@Test(priority = 2)
	public void CreateCommunitywithExistingName() {
		communitypayload.setProjectName(CommunityName);

		Response response = CommunityEndpoints.CreateCommunity(LoginTest.LoginToken, communitypayload);


		// validations

		if (response.getStatusCode() == 400
				&& response.jsonPath().getString("error").equals("Community name already exist")) {
			Reporter.log("Create Community with Existing Name...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Create Community with Existing Name Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("error"), "Community name already exist",
				"Correct message returned");

	}
	
	// Create Community with Null Fields

		@Test(priority = 3)
		public void CreateCommunitywithNullFields() {
			communitypayload.setProjectName(faker.name().title());
			communitypayload.setAddress(null);
			communitypayload.setCity(null);
			communitypayload.setState(null);
			communitypayload.setPostalCode(null);
			
			Response response = CommunityEndpoints.CreateCommunity(LoginTest.LoginToken, communitypayload);
            response.prettyPrint();

			// validations

			if (response.getStatusCode() == 400
					&& response.jsonPath().getString("error").equals("Mandatory fields are not provided: Address, City, State, Postal Code")) {
				Reporter.log("Create Community with Null Fields...." + response.getStatusCode(), true);

			} else {
				Reporter.log("Create Community with Null Fields Fail...." + response.prettyPrint(), false);
			}

			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			Assert.assertEquals(response.jsonPath().getString("error"), "Mandatory fields are not provided: Address, City, State, Postal Code",
					"Correct message returned");

		}
	
	
	// Search Community.

	@Test(priority = 4)
	public void TestSearchCommunity() {
		communitypayload.setProjectName("");
		communitypayload.setPageNo(0);
		communitypayload.setPageSize(8);

		Response response = CommunityEndpoints.SearchCommunity(LoginTest.LoginToken, communitypayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("community Search...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Community Search Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Create request

	@Test(priority = 5)
	public void TestCreateRequest() {	
		RequestPayload.setProjectId(CommunityId);
		RequestPayload.setDescription(faker.name().nameWithMiddle());
		RequestPayload.setFrequencyType("Every Month");

		Response response = CommunityEndpoints.Createrequest(LoginTest.LoginToken, RequestPayload);
		
		RequestId = response.jsonPath().getInt("data.id");
		

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Create request...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Create Request Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}
	
	
	// Create  request with same frequency

		@Test(priority = 6)
		public void CreateRequestWithSamefrequency() {		
			RequestPayload.setProjectId(CommunityId);
			RequestPayload.setDescription(faker.name().nameWithMiddle());
			RequestPayload.setFrequencyType("Every Day");

			Response response = CommunityEndpoints.Createrequest(LoginTest.LoginToken, RequestPayload);
			
			// validations

			if (response.getStatusCode() == 400) {
				Reporter.log("Create request with same frequency...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Create request with same frequency Fail...." + response.prettyPrint(), false);
			}

			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			

		}
		
		

	// Dvs Overview

	@Test(priority = 7)
	public void TestDvsOverview() {
		Overviewpayload.setCompanyId(LoginTest.CompanyId);
		Overviewpayload.setCommunityName(null);
		Overviewpayload.setPageNo(0);
		Overviewpayload.setPageSize(8);

		Response response = CommunityEndpoints.DvsOverview(LoginTest.LoginToken, Overviewpayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Dvs Overview...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Dvs Overview Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "200 OK", "Correct message returned");

	}

	// Overview Issue Counts

	 @Test(priority = 8)
	public void TestOverviewIssueCount() {
		Overviewpayload.setCompanyId(LoginTest.CompanyId);
		Overviewpayload.setCommunityId(null);
		Overviewpayload.setPageNo(0);
		Overviewpayload.setPageSize(8);

		Response response = CommunityEndpoints.OverviewIssueCount(LoginTest.LoginToken, Overviewpayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Overview Issue Counts...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Overview Issue Counts...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	
	// Overview Issue Counts with invalid payload

		 @Test(priority = 9)
		public void TestOverviewIssueCountwithInvalidPayload() {
			Overviewpayload.setCompanyId(LoginTest.CompanyId);
			Overviewpayload.setCommunityId(null);
			Overviewpayload.setPageNo(0);
			Overviewpayload.setPageSize(0);
			

			Response response = CommunityEndpoints.OverviewIssueCount(LoginTest.LoginToken, Overviewpayload);
           
			// validations

			if (response.getStatusCode() == 400 ) {
				Reporter.log("Overview Issue Counts with invalid payload...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Overview Issue Counts with invalid payload...." + response.prettyPrint(), false);
			}

			Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");
			

		}

	// DataSearch Issue Counts

	@Test(priority = 10)
	public void TestdatasearchIssueCount() {
		Overviewpayload.setCompanyId(LoginTest.CompanyId);
		Overviewpayload.setCommunityId(CommunityTest.CommunityId);
		Overviewpayload.setPageNo(0);
		Overviewpayload.setPageSize(8);

		Response response = CommunityEndpoints.OverviewIssueCount(LoginTest.LoginToken, Overviewpayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("DataSearch Issue Counts...." + response.getStatusCode(), true);
		} else {
			Reporter.log("DataSearch Issue Counts...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

}
