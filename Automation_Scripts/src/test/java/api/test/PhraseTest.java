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
	
	@BeforeClass
	public void setupData()
	{
		PhrasePayload=new Phrase();
		PhrasePayload.setWord("pharse1");
		PhrasePayload.setPhrase("show details of prajwal");
		PhrasePayload.setProjectId(ProjectTest.proID);
		PhrasePayload.setFileId(UploadFileTest.FileId);
	}
	
	@Test(priority = 1)
	public void testAddPhrase()
	{
	 Response response =PhraseEndPoints.AddPhrase( LoginTest.LoginToken , PhrasePayload);
	 response.prettyPrint();
	 
	
	 
	 //validations
	 AssertJUnit.assertEquals(response.getStatusCode(), 200);
	 AssertJUnit.assertEquals(response.jsonPath().getString("message"), "200 OK");
	 
	 Reporter.log("phrase Added successfully." , true);
	}

}
