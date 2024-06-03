package api.test;

import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.AdminCompanyEndpoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.AdminCompany;
import api.payload.CompanyEmp;
import io.restassured.response.Response;

public class AdminCompanyTest {

	AdminCompany companypayload;
	CompanyEmp empdetails;
	Faker faker;
	AdminCompany SearchCompany;
	int CompanyId;
	AdminCompany UpdateCompany;

	@BeforeClass
	public void setupData() {

		companypayload = new AdminCompany();
		faker = new Faker();

		empdetails = new CompanyEmp();
		empdetails.setEmpType("1");
		empdetails.setFirstName(faker.name().firstName());
		empdetails.setLastName(faker.name().lastName());
		empdetails.setDesignation(faker.nation().nationality());
		empdetails.setCountryCode("+91");
		empdetails.setEmail(faker.internet().emailAddress());
		empdetails.setPhone("6360504064");
		empdetails.setPermissionIds(Arrays.asList(2));
		empdetails.setImageId("0");

		companypayload.setCompanyName(faker.name().title());
		companypayload.setPassword("Prajwal@123");
		companypayload.setDeviceId(null);
		companypayload.setDeviceType(null);
		companypayload.setImageId("0");
		companypayload.setEmpLimit(20);
		companypayload.setExpireDate("2025-06-30 00:00:00.000");
		companypayload.setAddEmployee(empdetails);

		SearchCompany = new AdminCompany();
		SearchCompany.setName("");
		SearchCompany.setPageNo(0);
		SearchCompany.setPageSize(8);
		SearchCompany.setSearchType(2);

		UpdateCompany = new AdminCompany();

	}

	// Admin Create Company

	 @Test(priority = 1)
	public void AdminCreateCompany() {

		Response response = AdminCompanyEndpoints.AdminCreateCompany(AdminTest.AdminLoginToken, companypayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Admin Create Company...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Admin Create Company failed" + response.prettyPrint(), true);
		}

	}

	// Admin Search Company

	@Test(priority = 2)
	public void AdminSearchCompany() {

		Response response = AdminCompanyEndpoints.AdminCompanySearch(AdminTest.AdminLoginToken,
				this.SearchCompany.getName(), this.SearchCompany.getPageNo(), this.SearchCompany.getPageSize(),
				this.SearchCompany.getSearchType());

		CompanyId = response.jsonPath().getInt("data[0].id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Admin Search Company...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Admin Search Company failed" + response.prettyPrint(), true);
		}

	}

	// Admin update Company

	@Test(priority = 3)
	public void AdminUpdateCompany() {
		UpdateCompany.setId(CompanyId);
		UpdateCompany.setCompanyName(faker.name().title());
		UpdateCompany.setExpireDate("2026-06-30 00:00:00.000");
		UpdateCompany.setPhone("9988988998");

		Response response = AdminCompanyEndpoints.AdminUpdateCompany(AdminTest.AdminLoginToken, CompanyId,
				UpdateCompany);
		

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Admin Update Company...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Admin Update Company failed" + response.prettyPrint(), true);
		}

	}
	
	
	// Admin Disable Company

		@Test(priority = 4)
		public void AdminDisableCompany() {

			Response response = AdminCompanyEndpoints.AdminDisableCompany(AdminTest.AdminLoginToken, CompanyId , false);

			// validations

			if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
				Reporter.log("Admin Disable Company...." + response.getStatusCode(), true);
			} else {
				Reporter.log("Admin disable Company failed" + response.prettyPrint(), true);
			}
			
			
			
		}

}
