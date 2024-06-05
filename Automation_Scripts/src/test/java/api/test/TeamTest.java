package api.test;

import java.util.List;

import org.testng.Assert;
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
	public static int team_memberid;
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
			Reporter.log("Team Created...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Team Created Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

//Team details

	@Test(priority = 2)
	public void TestTeamDetails() {

		Response response = TeamEndPoints.TeamDetails(LoginTest.LoginToken, this.teampayload.getPageNo(),
				this.teampayload.getPageSize());

		teamsId = response.jsonPath().getList("data.teamsEmpDetails.teams.id");

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Details...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Team Details Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

//Team Update

	@Test(priority = 3)
	public void TestTeamUpdate() {

		teampayload.setTeamId(teamId);
		teampayload.setTeamName(faker.name().bloodGroup());

		Response response = TeamEndPoints.TeamUpdate(LoginTest.LoginToken, teamId, teampayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Update...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Team Updated Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Team Employees

	@Test(priority = 4)
	public void TestTeamEmployees() {

		teampayload.setTeamId(teamId);

		Response response = TeamEndPoints.TeamEmployees(LoginTest.LoginToken, teamId);
		team_memberid = response.jsonPath().getInt("data[0].id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Employees...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Team Employees Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

	// Delete team Member

	@Test(priority = 5)
	public void TestDeleteTeamMember() {
		teampayload.setMemberId(team_memberid);

		Response response = TeamEndPoints.DeleteTeamMember(LoginTest.LoginToken, this.teampayload.getMemberId(),
				this.teampayload.getTeamId());

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Delete Team Member...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Delete Team Member Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

//Team Delete

	@Test(priority = 6)
	public void TestTeamDelete() {

		teampayload.setTeamId(teamId);

		Response response = TeamEndPoints.TeamDelete(LoginTest.LoginToken, teamId);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Team Deleted...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Team Deleted Fail...." + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("message"), "OK", "Correct message returned");

	}

}
