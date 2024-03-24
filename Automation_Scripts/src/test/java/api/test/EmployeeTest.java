package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EmployeeEndPoints;
import api.payload.Employee;
import io.restassured.response.Response;


public class EmployeeTest {
	
	Faker faker;
	Employee employeePayload;
	int empID;
	public static List<Integer> employeeId;
	public static int CreatedBy;

	
@BeforeClass
public void setupData()
{
	faker = new Faker();
	employeePayload = new Employee();
	
	employeePayload.seteid(empID);
	employeePayload.setFirstName(faker.name().firstName());
	employeePayload.setLastName(faker.name().lastName());
	employeePayload.setEmail(faker.internet().emailAddress());
	employeePayload.setCountryCode("+91");
	employeePayload.setPhone("2378237823");
	employeePayload.setPermissionIds(new int[]{1});
	employeePayload.setDesignation(faker.name().nameWithMiddle());
	employeePayload.setImageId("0");
	employeePayload.setTeamName("");
	employeePayload.setPageNo(0);
	employeePayload.setPageSize(8);
}

//Adding employee 

@Test(priority = 1 , invocationCount = 2)
public void testAddEmployee()
{

	employeePayload.setEmail(faker.internet().emailAddress());
 Response response =EmployeeEndPoints.addEmployee(employeePayload , LoginTest.LoginToken);
	
 
 
 empID=response.jsonPath().getInt("data.employeeDetails.id");
	
 
 //validations
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
	
 
 Reporter.log("Added Employee...." , true);
}



//Getting employee details

@Test(priority = 2)
public void testEmployeeDetails()
{
	    Response response =    EmployeeEndPoints.EmployeeDetails(LoginTest.LoginToken);
	  
	    
	   CreatedBy = response.jsonPath().getInt("data.id");
	    
	    //validations
	    AssertJUnit.assertEquals(response.getStatusCode(), 200);
	    Reporter.log("Employee Details...." , true);
}

//Update employee

@Test(priority = 3)
public void TestUpdateEmployee()
{
	//update data
	
	employeePayload.setFirstName(faker.name().firstName());
    employeePayload.setLastName(faker.name().lastName());

	
    Response response = EmployeeEndPoints.UpdateEmployee(this.employeePayload.getEmail(),employeePayload ,LoginTest.LoginToken);
  
  
  //validations
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  Reporter.log("Update Employee...." , true);
}

//Delete Employee

@Test(priority = 4)
public void TestDeleteEmployee()
{
	
  Response response = EmployeeEndPoints.DeleteEmployee(empID , LoginTest.LoginToken);
 
  
  //validations
  
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
  Reporter.log("Delete Employee...." , true);
}

//Search Employee

@Test(priority = 5)
public void TestSearchEmployee()
{
	
  Response response = EmployeeEndPoints.SearchEmployee(  LoginTest.LoginToken , employeePayload);
  
  
  //validations
  
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
   employeeId = response.jsonPath().getList("data.employeeDetails.id");
 
  
  Reporter.log("Search Employee...." , true);
}

}
