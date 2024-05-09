package api.test;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.PhraseEndPoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.Phrase;
import io.restassured.response.Response;

public class PhraseTest {

	Phrase PhrasePayload;
	public static String abbreviationId;

	@BeforeClass
	public void setupData() {
		PhrasePayload = new Phrase();
		PhrasePayload.setWord("pharse1");
		PhrasePayload.setPhrase("show details of prajwal");
		PhrasePayload.setProjectId(ProjectTest.proID);
		PhrasePayload.setFileId(UploadFileTest.FileId);
		PhrasePayload.setabbreviationId(abbreviationId);
		PhrasePayload.setSearchWord("");
		PhrasePayload.setPageNo(0);
		PhrasePayload.setPageSize(100);
	}

	// Add phrase

	@Test(priority = 1)
	public void testAddPhrase() {
		Response response = PhraseEndPoints.AddPhrase(LoginTest.LoginToken, PhrasePayload);

		abbreviationId = response.jsonPath().getString("data._id");

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Add Phrase...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Add Phrase Fail...." + response.prettyPrint(), false);
		}
	}

	// Get phrase

	@Test(priority = 4)
	public void testGetPhrase() {

		Response response = PhraseEndPoints.GetPhrase(LoginTest.LoginToken, this.PhrasePayload.getSearchWord(),
				ProjectTest.proID, UploadFileTest.FileId, this.PhrasePayload.getPageNo(),
				this.PhrasePayload.getPageSize());

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Get Phrase...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Get Phrase Fail...." + response.prettyPrint(), false);
		}

	}

	// Update phrase

	@Test(priority = 2)
	public void testUpdatePhrase() {

		PhrasePayload.setWord("Phrase1 p1");
		PhrasePayload.setPhrase("show details of vivek");

		Response response = PhraseEndPoints.UpdatePhrase(LoginTest.LoginToken, this.PhrasePayload.getabbreviationId(),
				PhrasePayload);

		// validations

		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Update Phrase...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Update Phrase Fail...." + response.prettyPrint(), false);
		}

	}

	// delete phrase

	@Test(priority = 3)
	public void testDeletePhrase() {

		PhrasePayload.setabbreviationId(abbreviationId);

		Response response = PhraseEndPoints.DeletePhrase(LoginTest.LoginToken, abbreviationId);

		// validations
		if (response.getStatusCode() == 200 && response.jsonPath().getString("message").equals("200 OK")) {
			Reporter.log("Delete Phrase...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Delete Phrase Fail...." + response.prettyPrint(), false);
		}

	}

}
