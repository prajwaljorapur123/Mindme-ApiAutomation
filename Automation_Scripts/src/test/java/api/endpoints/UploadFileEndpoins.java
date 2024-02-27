package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.UploadFile.ProjectDetails;
import io.restassured.response.Response;

public class UploadFileEndpoins {
	public static Response UploadFile(String token , ProjectDetails projectDetails)
	{
		File fileToUpload = new File("src/test/resources/sample.xlsx");
		
	Response response = given()
			.multiPart("data" , projectDetails ,"application/json")
			.multiPart("file", fileToUpload ,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
			.contentType("multipart/json")
			.headers("Authorization","Bearer "+token)
			
			.when().post(Routes.upload_file);
	
	    return response;
		
	}

}