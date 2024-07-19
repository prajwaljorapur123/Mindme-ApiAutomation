package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class CreateJiraTicket {
	
	
	
	    private static final String JIRA_USERNAME = "prajwal.krvjorapur@trudosys.com"; //  JIRA username
	    private static final String JIRA_API_TOKEN = "ATATT3xFfGF0bNTHgu3Qct0Nt2g3T9vovndh9f95qZ2D7ESXYpSPTYjFrvVksu0gwy1FKQdc3KWAGkbP9Sr3prazrbgPM2nST00YaM4IB5jU3leL4yEL6GHnVqefQXoLugGLuYP_K5qjHS656vYPcNKqC1RdvrBxS4iIUm4gfIiNN9jH_Ot4zzg=7878131F"; // Replace with your JIRA API token

	    static {
	        PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
	        basicAuth.setUserName(JIRA_USERNAME);
	        basicAuth.setPassword(JIRA_API_TOKEN);
	        RestAssured.authentication = basicAuth;
	    }

	    public static void createJiraIssue(String summary, String description) {
	    	String jiraPayload = "{\n" +
	                "  \"fields\": {\n" +
	                "    \"project\": {\n" +
	                "      \"key\": \"OV\"\n" + // Replace with the correct project key
	                "    },\n" +
	                "    \"summary\": \"" + summary + "\",\n" +
	                "    \"description\": \"" + description + "\",\n" +
	                "    \"issuetype\": {\n" +
	                "      \"name\": \"Bug\"\n" +
	                "    }\n" +
	                "  }\n" +
	                "}";

//	        Response response = RestAssured.given()
//	                .contentType(ContentType.JSON)
//	                .body(jiraPayload)
//	                .post(Routes.JIRA_URL);
//
//	        int statusCode = response.getStatusCode();
//	        String responseBody = response.getBody().asPrettyString();
//
//	        System.out.println("Response Status Code: " + statusCode);
//	        System.out.println("Response Body: " + responseBody);
	    	System.out.println("create jira");
	    }
	
}
