package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.DroneDp;
import api.payload.IssueType;
import api.payload.UploadFile.ProjectDetails;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class IssueTypeEndpoints {
	
	public static Response UploadIssueTypeFile(String token , String filePath) {
		File fileToUpload = new File(filePath);

		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token)
				.multiPart("file", fileToUpload)
				.contentType("multipart/json")

				.when().post(Routes.Uplaod_issueType);

		return response;

	}
	
	public static Response CreateIssueType(String token , IssueType payload)
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(payload)
	    	.when().post(Routes.Create_Issue);
	
         	return response;
		
	}
	
	public static Response GetIssueType(String token)
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			
	    	.when().get(Routes.Get_Issues);
	
         	return response;
		
	}

}
