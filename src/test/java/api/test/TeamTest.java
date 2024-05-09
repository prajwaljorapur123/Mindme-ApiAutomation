package api.test;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EmployeeEndPoints;
import api.endpoints.TeamEndPoints;
import api.payload.Employee;
import api.payload.Team;
import io.restassured.response.Response;

public class TeamTest {
	Faker faker;
	Team teampayload;
	public static int teamId;
	public static List<Integer> teamsId;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		teampayload = new Team();
		teampayload.setTeamName(faker.name().bloodGroup());
		teampayload.setEmpId(EmployeeTest.employeeId);
		teampayload.setPageNo(0);
		teampayload.setPageSize(8);
		teampayload.setTeamId(teamId);

	}

//Create Team

	@Test(priority = 1, invocationCount = 2)
	public void TestCreateTeam() {
		teampayload.setTeamName(faker.name().bloodGroup());
		Response response = TeamEndPoints.CreateTeam(LoginTest.LoginToken, teampayload);
		teamId = response.jsonPath().getInt("data.teams.id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Created...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Team Created Fail...." + response.prettyPrint(),false);
		}

	}

//Team details

	@Test(priority = 2)
	public void TestTeamDetails() {

		Response response = TeamEndPoints.TeamDetails(LoginTest.LoginToken, this.teampayload.getPageNo(),
				this.teampayload.getPageSize());

		teamsId = response.jsonPath().getList("data.teamsEmpDetails.teams.id");

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Details...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Team Details Fail...." + response.prettyPrint(),false);
		}

	}

//Team Update

	@Test(priority = 3)
	public void TestTeamUpdate() {

		teampayload.setTeamId(teamId);
		teampayload.setTeamName(faker.name().bloodGroup());

		Response response = TeamEndPoints.TeamUpdate(LoginTest.LoginToken, teamId, teampayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Update...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Team Updated Fail...." + response.prettyPrint(),false);
		}

	}

//Team Delete

	@Test(priority = 4)
	public void TestTeamDelete() {

		teampayload.setTeamId(teamId);

		Response response = TeamEndPoints.TeamDelete(LoginTest.LoginToken, teamId);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Deleted...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Team Deleted Fail...." + response.prettyPrint(),false);
		}

	}

}
