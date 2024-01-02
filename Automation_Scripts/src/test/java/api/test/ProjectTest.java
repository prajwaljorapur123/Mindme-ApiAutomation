package api.test;

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



	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		projectpayload = new Project();
		
		projectpayload.setProjectName(faker.name().nameWithMiddle());
		projectpayload.setteamId(TeamTest.teamsId);
		
		
	}
	
	@Test(priority = 1)
	public void TestCreateProject()
	{
		
	  Response response =ProjectEndPoints.CreateProject(LoginTest.LoginToken , projectpayload);
	  response.prettyPrint();
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
	  
	  
//	 projectId =  response.jsonPath().getInt("data.teams.id");
//	 System.out.println(teamId);
	  Reporter.log("project created successfully" , true);
	}

}
