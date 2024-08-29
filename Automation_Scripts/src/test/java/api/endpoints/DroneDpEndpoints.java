package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.DroneDp;
import api.payload.Pdf;
import api.payload.UploadFile.ProjectDetails;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class DroneDpEndpoints {
	
	public static Response ViewRequest(String token , DroneDp payload)
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(payload)
	    	.when().post(Routes.ViewRequest);
	
         	return response;
		
	}
	
	public static Response GetAllCompanies(String token , DroneDp payload)
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(payload)
	    	.when().post(Routes.GetAllCompanies);
	
         	return response;
		
	}
	
	public static Response RequestCount(String token )
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			
	    	.when().get(Routes.RequestCount);
	
         	return response;
		
	}
	
	public static Response UploadFileForRequest( ProjectDetails projectDetails) {
		File fileToUpload = new File("src/test/resources/Pollard Ct Road, Los Gatos-08-06-2024.xlsx");

		Response response = given()
				.filter(new AllureRestAssured())
				.multiPart("data", projectDetails, "application/json")
				.multiPart("file", fileToUpload, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.contentType("multipart/json")

				.when().post(Routes.upload_file);

		return response;

	}
	
	public static Response UploadPdfForRequest( Pdf PdfDetails)
	{
		File fileToUpload = new File("src/test/resources/Pollard Ct Road, Los Gatos-08-06-2024.pdf");
		
	Response response = given()
			.filter(new AllureRestAssured())
			.multiPart("data" , PdfDetails ,"application/json")
			.multiPart("file", fileToUpload ,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
			.contentType("multipart/json")
			
			
			.when().post(Routes.upload_pdf);
	
	    return response;
		
	}


}
