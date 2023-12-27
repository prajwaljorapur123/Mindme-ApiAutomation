package api.test;

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


@BeforeClass
public void setupData()
{
	faker = new Faker();
	teampayload = new Team();
	
	teampayload.setTeamName(faker.name().bloodGroup());
	teampayload.setEmpId(EmployeeTest.employeeId);
	teampayload.setPageNo(0);
	teampayload.setPageSize(8);
	teampayload.setTeamId(teamId);
	
	
	
	
}


@Test(priority = 1)
public void TestCreateTeam()
{
	
  Response response =TeamEndPoints.CreateTeam(LoginTest.LoginToken , teampayload);
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  
 teamId =  response.jsonPath().getInt("data.teams.id");
 System.out.println(teamId);
  Reporter.log("team created successfully" , true);
}


@Test(priority = 2)
public void TestTeamDetails()
{
	
  Response response =TeamEndPoints.TeamDetails(LoginTest.LoginToken , this.teampayload.getPageNo(),this.teampayload.getPageSize());
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  Reporter.log("team datails......." , true);
}

@Test(priority = 3)
public void TestTeamUpdate()
{
	
	teampayload.setTeamId(teamId);
	teampayload.setTeamName(faker.name().bloodGroup());
	
  Response response =TeamEndPoints.TeamUpdate(LoginTest.LoginToken , teamId, teampayload);
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  Reporter.log("team updated successfully" , true);
}

@Test(priority = 4)
public void TestTeamDelete()
{
	
	teampayload.setTeamId(teamId);
	
	
  Response response =TeamEndPoints.TeamDelete(LoginTest.LoginToken , teamId);
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  Reporter.log("team deleted successfully" , true);
}


}
