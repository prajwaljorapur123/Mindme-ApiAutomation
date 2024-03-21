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

//Create Team

@Test(priority = 1,invocationCount = 2)
public void TestCreateTeam()
{
	teampayload.setTeamName(faker.name().bloodGroup());
  Response response =TeamEndPoints.CreateTeam(LoginTest.LoginToken , teampayload);
  response.prettyPrint();
  
  
  //validations
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  
   teamId =  response.jsonPath().getInt("data.teams.id");
	

  Reporter.log("team created successfully" , true);
}


//Team details

@Test(priority = 2)
public void TestTeamDetails()
{
	
  Response response =TeamEndPoints.TeamDetails(LoginTest.LoginToken , this.teampayload.getPageNo(),this.teampayload.getPageSize());
  response.prettyPrint();
  teamsId = response.jsonPath().getList("data.teamsEmpDetails.teams.id");
  
  //validations
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  Reporter.log("team datails......." , true);
}

//Team Update

@Test(priority = 3)
public void TestTeamUpdate()
{
	
	teampayload.setTeamId(teamId);
	teampayload.setTeamName(faker.name().bloodGroup());
	
    Response response =TeamEndPoints.TeamUpdate(LoginTest.LoginToken , teamId, teampayload);
    response.prettyPrint();
  
  //validations
  
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  Reporter.log("team updated successfully" , true);
}


//Team Delete

@Test(priority = 4)
public void TestTeamDelete()
{
	System.out.println(teamId);
	teampayload.setTeamId(teamId);
	
	
  Response response =TeamEndPoints.TeamDelete(LoginTest.LoginToken , teamId);
  response.prettyPrint();
  
  //validations
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  Reporter.log("team deleted successfully" , true);
}


}
