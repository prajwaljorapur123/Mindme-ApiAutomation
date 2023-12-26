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

@Test(priority = 1)
public void testAddEmployee()
{
 Response response =EmployeeEndPoints.addEmployee(employeePayload , LoginTest.LoginToken);
 response.prettyPrint();
 
 empID=response.jsonPath().getInt("data.employeeDetails.id");
 Reporter.log("Added employee successfully" , true);
}

@Test(priority = 2)
public void testEmployeeDetails()
{
	    Response response =    EmployeeEndPoints.EmployeeDetails(LoginTest.LoginToken);
	    response.prettyPrint();
	    AssertJUnit.assertEquals(response.getStatusCode(), 200);
	    Reporter.log("employee details...." , true);
}

@Test(priority = 3)
public void TestUpdateEmployee()
{
	//update data
	
	employeePayload.setFirstName(faker.name().firstName());
    employeePayload.setLastName(faker.name().lastName());

	
  Response response = EmployeeEndPoints.UpdateEmployee(this.employeePayload.getEmail(),employeePayload ,LoginTest.LoginToken);
  response.prettyPrint();
  AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  Reporter.log("update employee successfully" , true);
}


@Test(priority = 4)
public void TestDeleteEmployee()
{
	//update data
	
	employeePayload.setFirstName(faker.name().firstName());
    employeePayload.setLastName(faker.name().lastName());

	
  Response response = EmployeeEndPoints.DeleteEmployee(empID , LoginTest.LoginToken);
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  Reporter.log("delete employee successfully" , true);
}

@Test(priority = 4)
public void TestSearchEmployee()
{
	
  Response response = EmployeeEndPoints.SearchEmployee(  LoginTest.LoginToken , employeePayload);
  response.prettyPrint();
 AssertJUnit.assertEquals(response.getStatusCode(), 200);
  AssertJUnit.assertEquals(response.jsonPath().getString("message"), "OK");
  
   employeeId = response.jsonPath().getList("data.employeeDetails.id");
 // employeeId = ids.stream().mapToInt(Integer::intValue).toArray();
//     for (int i = 0; i < employeeId.length; i++) {
//		int j = employeeId[i];
//		
//	}

  
  Reporter.log("search employee successfully" , true);
}

}
