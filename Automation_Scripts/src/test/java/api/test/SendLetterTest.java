package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.SendLetterEndpoints;
import api.endpoints.UploadFileEndpoins;
import api.payload.Files;
import api.payload.SendLetter;
import api.payload.UploadFile.Header;
import api.payload.UploadFile.ProjectDetails;
import api.payload.UploadFile.Sheet;
import io.restassured.response.Response;

public class SendLetterTest {

	SendLetter SendLetterPayload;

	@BeforeClass
	public void setupData() {

		SendLetterPayload = new SendLetter();
		SendLetterPayload.setMailSender("vdc-sw-expert1@mindmetechnology.com");
		SendLetterPayload.setRecipient("prajwal.krvjorapur@trudosys.com");
		SendLetterPayload.setSubject(" Testing for send letter");
		SendLetterPayload.setMsgBody(
				"<html lang=\\\"en\\\"> <head> <meta charset=\\\"UTF-8\\\"> <meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\"> <style> body { font-family: Arial, sans-serif; margin: 20px; } .container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px; } .header, .footer { text-align: center; margin-bottom: 20px; } .header img { max-width: 150px; height: auto; } .content { margin-bottom: 20px; } .signature { margin-top: 30px; } .violation-summary, .decision { margin-top: 20px; padding: 10px; border: 1px solid #ddd; border-radius: 4px; } .violation-summary h3, .decision h3 { margin-top: 0; } .hearing-results { text-align: right; font-weight: bold; } </style> </head> <body> <div class=\\\"container\\\"> <div class=\\\"header\\\"> <img src=\\\"https://images.unsplash.com/photo-1624555130581-1d9cca783bc0?q=80&w=2942&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D\\\" alt=\\\"Company Logo\\\" width=\\\"300\\\" height=\\\"100\\\"> <p>500 Alfred Nobel Drive, Suite 250, Hercules, CA 94547</p> <p>Fax (510) 262-1797 | Tel (510) 262-1795 | <a href=\\\"http://www.collins-mgmt.com\\\">www.collins-mgmt.com</a></p> <p>Email: <a href=\\\"mailto:rhil@collins-mgmt.com\\\">rhil@collins-mgmt.com</a>, <a href=\\\"mailto:stephen@collins-mgmt.com\\\">stephen@collins-mgmt.com</a></p> <h2>PARK VILLA ASSOCIATION - MARSH CREEK</h2> </div> <div class=\\\"content\\\"> <p>Date: Jul 15 2024 ,</p> <p>John Doe<br> 123 Main St<br> Apt 4B<br> Hercules, CA , 94547 </p> <p>RE: Account # 123456 / 789 Some Address</p> <p class=\\\"hearing-results\\\">Hearing Results</p> <p>Dear John Doe,</p> <p>We previously invited you to attend a Hearing on February 13, 2023, to discuss the outstanding violation that was reported to exist concerning your property. The details of the violation are as follows:</p> <div class=\\\"violation-summary\\\"> <h3>Violation Summary:</h3> <p>Noise complaint</p> <p>Excessive noise after 10 PM</p> <p>Please see the last page for the specific CC&R or Rule section which applies to this violation.</p> </div> <div class=\\\"decision\\\"> <h3>At the Hearing, the Board decided on the following:</h3> <p>The Board voted to assess a fine in the amount of $100.00 for non-compliance.</p> <p>Please note that continued non-compliance could result in fines of up to $500.00. Assessments are subject to late fees, liens, interest, collection fees, and other remedies if not paid per the Association's Collection Policy.</p> <p>Should you have any questions regarding the standards at Park Villa Association - Marsh Creek, please refer to the Association Rules and Regulations and CC&R's.</p> </div> <p>Your cooperation is greatly appreciated by your Board of Directors, the Homeowners Association, and your neighbors.</p> <div class=\\\"signature\\\"> <p>Sincerely,</p> <p>PARK VILLA ASSOCIATION - MARSH CREEK</p> <p>Board of Directors</p> <p>Rhiannon Harris, Community Association Manager</p> <p>COLLINS MANAGEMENT COMPANY</p> </div> </div> <div class=\\\"footer\\\"> <p>PARK VILLA ASSOCIATION - MARSH CREEK</p> <p>500 Alfred Nobel Drive, Suite 250, Hercules, CA 94547</p> <p>Fax (510) 262-1797 | Tel (510) 262-1795 | <a href=\\\"http://www.collins-mgmt.com\\\">www.collins-mgmt.com</a></p> </div> </div> </body> </html>");

	}

	// Send Letter With Attachement

	@Test(priority = 1)
	public void TestSendLetterWithAttachement() {
		String[] filePath = { "src/test/resources/Issue1.png"};

		SendLetterPayload.setSubject("Send Letter With Attachement...");
		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, filePath);

		// validations

		if (response.getStatusCode() == 200
				&& response.jsonPath().getString("data").equals("Mail Sent Successfully...")) {
			Reporter.log("Send Letter With Attachement...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter With Attachement failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("data"), "Mail Sent Successfully...",
				"Correct message returned");

	}

	// Send Letter Without Attachement

	@Test(priority = 2)
	public void TestSendLetterWithOutAttachement() {
		SendLetterPayload.setSubject("Send Letter WithOut Attachement...");

		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, null);

		// validations

		if (response.getStatusCode() == 200
				&& response.jsonPath().getString("data").equals("Mail Sent Successfully...")) {
			Reporter.log("Send Letter Without Attachement...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter Without Attachement failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("data"), "Mail Sent Successfully...",
				"Correct message returned");

	}

	// Send Letter With Invalid Attachement
	// Only JPEG, PNG and JPG files are allowed as attachments

	@Test(priority = 3)
	public void TestSendLetterWithInvalidAttachement() {

		String[] filePath = { "src/test/resources/sample.xlsx"

		};
		SendLetterPayload.setSubject("Send Letter With Invalid Attachement...");
		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, filePath);

		// validations

		if (response.getStatusCode() == 400) {
			Reporter.log("Send Letter With Invalid Attachement...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter With Invalid Attachement failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");

	}

	// Send Letter With Multiple Attachement

	@Test(priority = 4)
	public void TestSendLetterWithMultipleAttachement() {
		String[] filePaths = { "src/test/resources/Issue1.png", "src/test/resources/Issue2.png" };
		SendLetterPayload.setSubject("Send Letter With Multiple Attachement...");
		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, filePaths);

		// validations

		if (response.getStatusCode() == 200
				&& response.jsonPath().getString("data").equals("Mail Sent Successfully...")) {
			Reporter.log("Send Letter With Multiple Attachement...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter With Multiple Attachement failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");
		Assert.assertEquals(response.jsonPath().getString("data"), "Mail Sent Successfully...",
				"Correct message returned");

	}

	// Send Letter With Invalid Recipient Email

	@Test(priority = 5)
	public void TestSendLetterWithInvalidRecipientEmail() {
		SendLetterPayload.setRecipient("prajwal.krvyrudosys.com");

		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, null);

		// validations

		if (response.getStatusCode() == 400) {
			Reporter.log("Send Letter With Invalid Recipient Email...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter With Invalid Recipient Email failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");

	}

	// Send Letter With Large Attachement

	 @Test(priority = 6)
	public void TestSendLetterWithLargeAttachement() {

		String[] filePath = { "src/test/resources/Image30Mb.jpg"

		};
		SendLetterPayload.setSubject("Send Letter With Large Attachement...");
		Response response = SendLetterEndpoints.SendLetter(LoginTest.LoginToken, SendLetterPayload, filePath);
		

		// validations

		if (response.getStatusCode() == 400) {
			Reporter.log("Send Letter With Large Attachement...." + response.getStatusCode(), true);
		} else {
			Reporter.log("Send Letter With Large Attachement failed" + response.prettyPrint(), false);
		}
		Assert.assertEquals(response.getStatusCode(), 400, "Correct status code returned");

	}

}
