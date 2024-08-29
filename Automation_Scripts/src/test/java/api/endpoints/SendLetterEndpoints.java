package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.SendLetter;
import api.payload.UploadFile.ProjectDetails;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendLetterEndpoints {

	public static Response SendLetter(String token, SendLetter payload, String[] filePaths) {

		// Explicitly declare the type
		RequestSpecification request = given().filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token)
				.multiPart("emailLetterDetails", payload, "application/json");

		if (filePaths != null) {
			for (String filePath : filePaths) {
				if (filePath != null && !filePath.isEmpty()) {
					File fileToUpload = new File(filePath);
					request.multiPart("files", fileToUpload);
				}
			}
		}

		// Send the request
		Response response = request.contentType("multipart/form-data").when().post(Routes.Send_Letter);

		return response;

	}

}
