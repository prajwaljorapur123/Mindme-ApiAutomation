package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Admin;
import api.payload.AdminCompany;
import api.payload.Login;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AdminEndpoints {

	public static Response AdminLogin(Admin payload) {
		Response response = given().filter(new AllureRestAssured()).contentType(ContentType.JSON).body(payload)

				.when().post(Routes.login_post_url);

		return response;

	}

	public static Response Admindashboard(String token) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token).when()
				.get(Routes.AdmindashboardCount);

		return response;

	}

	public static Response AboutToexpireCompanies(String token, String name, int pageNo, int pageSize, int searchType) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.queryParam("name", name).queryParam("pageNo", pageNo).queryParam("pageSize", pageSize)
				.queryParam("searchType", searchType)

				.when().get(Routes.AdminCompanySearch);

		return response;

	}

	public static Response ExpiredCompanies(String token, String name, int pageNo, int pageSize, int searchType) {

		Response response = given().filter(new AllureRestAssured()).headers("Authorization", "Bearer " + token)
				.queryParam("name", name).queryParam("pageNo", pageNo).queryParam("pageSize", pageSize)
				.queryParam("searchType", searchType)

				.when().get(Routes.AdminCompanySearch);

		return response;

	}

}
