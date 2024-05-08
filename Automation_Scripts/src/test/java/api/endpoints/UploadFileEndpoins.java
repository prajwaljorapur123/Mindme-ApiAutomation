package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.payload.Files;
import api.payload.UploadFile.ProjectDetails;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class UploadFileEndpoins {
	public static Response UploadFile(String token, ProjectDetails projectDetails) {
		File fileToUpload = new File("src/test/resources/sample.xlsx");

		Response response = given()
				.filter(new AllureRestAssured())
				.multiPart("data", projectDetails, "application/json")
				.multiPart("file", fileToUpload, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.contentType("multipart/json").headers("Authorization", "Bearer " + token)

				.when().post(Routes.upload_file);

		return response;

	}

	public static Response UpdateFile(String token, int FileId) {
		File fileToUpload = new File("src/test/resources/UpdateSample.xlsx");

		Response response = given()
				.filter(new AllureRestAssured())
				.headers("Authorization", "Bearer " + token).multiPart("file", fileToUpload)
				.contentType("multipart/json")

				.when().post(Routes.Update_file + FileId);

		return response;

	}

	public static Response UploadErrorFile(String token, ProjectDetails projectDetails) {
		File fileToUpload = new File("src/test/resources/ErrorSample.xlsx");

		Response response = given()
				.filter(new AllureRestAssured())
				.multiPart("data", projectDetails, "application/json")
				.multiPart("file", fileToUpload, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.contentType("multipart/json").headers("Authorization", "Bearer " + token)

				.when().post(Routes.uploadError_file);

		return response;

	}

	public static Response UploadErrorFix(String token, ProjectDetails projectDetails, int ErrorFileId) {
		File fileToUpload = new File("src/test/resources/sample.xlsx");

		Response response = given()
				.filter(new AllureRestAssured())
				.multiPart("data", projectDetails, "application/json")
				.multiPart("file", fileToUpload, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.contentType("multipart/json").headers("Authorization", "Bearer " + token)

				.when().post(Routes.upload_Error_fix + ErrorFileId);

		return response;

	}

	public static Response GetFiles(String token, Files payload) {
		Response response = given()
				.filter(new AllureRestAssured())
				.contentType("application/json").headers("Authorization", "Bearer " + token)
				.body(payload)

				.when().post(Routes.Get_file);

		return response;

	}

	public static Response DeleteFile(String token, int FileId) {

		Response response = given()
				.filter(new AllureRestAssured())
				.when().delete(Routes.Delete_file + FileId);

		return response;

	}

	public static Response GetFileByFileId(String token, int FileId) {

		Response response = given()
				.filter(new AllureRestAssured())
				.when().get(Routes.GetFileByFleId + FileId);

		return response;

	}

	public static Response DownloadExcelFile(int FileId) {

		Response response = given()
				.filter(new AllureRestAssured())
				.when().get(Routes.FileDownload + FileId);

		return response;

	}

}
