package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.CommunityEndpoints;
import api.endpoints.ProjectEndPoints;
import api.payload.Community;
import api.payload.Project;
import io.restassured.response.Response;

public class CommunityTest {

	Faker faker;
	Community communitypayload;
	Community RequestPayload;
	public static int CommunityId;
	public static int RequestId;
	Community Overviewpayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		communitypayload = new Community();
		communitypayload.setProjectName(faker.name().title());
		communitypayload.setTeamId(TeamTest.teamsId);
		communitypayload.setIsCommunity(true);

		RequestPayload = new Community();
		
		Overviewpayload = new Community();

	}

	// Create Community.

	@Test(priority = 1)
	public void TestCreateCommunity() {
		communitypayload.setProjectName(faker.name().title());

		Response response = CommunityEndpoints.CreateCommunity(LoginTest.LoginToken, communitypayload);
		CommunityId = response.jsonPath().getInt("data.projectDetails.id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("community Created...." + response.getStatusCode(), true);

		} else {
			Reporter.log("Community Created Fail...." + response.prettyPrint(), false);
		}

		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Search Community.

	@Test(priority = 2)
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

	@Test(priority = 3)
	public void TestCreateRequest() {
		RequestPayload.setProjectId(CommunityId);
		RequestPayload.setDescription(faker.name().nameWithMiddle());
		RequestPayload.setFrequencyType("Weekly");
		//RequestPayload.setCustomDate("2024-12-31T00:00:00Z");

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
	
	// Dvs Overview

		@Test(priority = 4)
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
		
		//Overview Issue Counts

				@Test(priority = 5)
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
				
				//DataSearch Issue Counts

			@Test(priority = 6)
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
