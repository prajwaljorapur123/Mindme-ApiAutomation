package api.test;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.ProjectEndPoints;
import api.endpoints.TeamEndPoints;
import api.payload.Project;
import api.payload.Team;
import io.restassured.response.Response;

public class ProjectTest {

	Faker faker;
	Project projectpayload;
	public static int projectId;
	public static int proID;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		projectpayload = new Project();
		projectpayload.setprojectId(projectId);
		projectpayload.setProjectName(faker.name().nameWithMiddle());
		projectpayload.setteamId(TeamTest.teamsId);
		projectpayload.setPageNo(0);
		projectpayload.setPageSize(8);

	}

	// Create Project

	@Test(priority = 1, invocationCount = 2)
	public void TestCreateProject() {

		Response response = ProjectEndPoints.CreateProject(LoginTest.LoginToken, projectpayload);

		projectId = response.jsonPath().getInt("data.projectDetails.id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Project Created...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Project Created Fail...." + response.prettyPrint(),false);
		}

	}

	// Project Details

	@Test(priority = 2)
	public void TestProjectDetails() {

		Response response = ProjectEndPoints.ProjectDetails(LoginTest.LoginToken, this.projectpayload.getProjectName(),
				projectpayload);
		proID = response.jsonPath().getInt("data[1].projectDetails.id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Project Details...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Project Details Fail...." + response.prettyPrint(),false);
		}

	}

	// Project Update

	@Test(priority = 3)
	public void TestProjectUpdate() {
		projectpayload.setprojectId(projectId);
		projectpayload.setProjectName(faker.name().nameWithMiddle());

		Response response = ProjectEndPoints.ProjectUpdate(LoginTest.LoginToken, projectId, TeamTest.teamsId,
				projectpayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Project Updated...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Project Update Fail...." + response.prettyPrint(),false);
		}

	}

	// Project Delete

	@Test(priority = 4)
	public void TestProjectDelete() {

		projectpayload.setprojectId(projectId);
		Response response = ProjectEndPoints.projectDelete(LoginTest.LoginToken, projectId);
		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("OK")) {
			Reporter.log("Project Delete...." + response.getStatusCode(),true);
		} else {
			Reporter.log("Project Deleted Fail...." + response.prettyPrint(),false);
		}

	}

}
