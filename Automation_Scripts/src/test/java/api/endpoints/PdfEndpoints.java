package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.Files;
import api.payload.Pdf;
import api.payload.UploadFile.ProjectDetails;
import io.restassured.response.Response;

public class PdfEndpoints {
	
	public static Response UploadPdf(String token , Pdf PdfDetails)
	{
		File fileToUpload = new File("src/test/resources/Revised RV Lot Rules and Regulations.doc.pdf");
		
	Response response = given()
			.multiPart("data" , PdfDetails ,"application/json")
			.multiPart("file", fileToUpload ,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
			.contentType("multipart/json")
			.headers("Authorization","Bearer "+token)
			
			.when().post(Routes.upload_pdf);
	
	    return response;
		
	}
	
	public static Response GetFiles(String token , Pdf payload)
	{
		
		
	Response response = given()
			
			
			.contentType("application/json")
			.headers("Authorization","Bearer "+token)
			.body(payload)
			
			.when().post(Routes.Get_file);
	
	    return response;
		
	}
	
	
	public static Response DeletePdf(String token ,int FileId )
	{	
		
	     Response response = given()	
			
		.when().delete(Routes.pdf_delete + FileId);
	
	     return response;
		
	}

}
