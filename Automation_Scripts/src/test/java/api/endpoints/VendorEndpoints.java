package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.Vendor;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class VendorEndpoints {
	
	public static Response UploadVendorDetails(String token , String filePath) {
		File fileToUpload = new File(filePath);

		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token)
				.multiPart("file", fileToUpload)
				.contentType("multipart/json")
				.when().post(Routes.Upload_VendorDetails);

		return response;

	}
	
	public static Response GetVendors(String token , Vendor payload )
	{
	Response response = given()
			.filter(new AllureRestAssured())
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(payload)
	    	.when().post(Routes.Get_Vendors);
	
         	return response;
		
	}
	
	
}
