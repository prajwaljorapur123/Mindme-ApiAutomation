package api.endpoints;

public class Routes {
	
	public static String baseurl="http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	
	//Login
	public static String login_post_url = baseurl+"/v1/auth/login";
	public static String Get_company_url= baseurl+"/v1/company";
	
	
    
	//employee 
	
	public static String post_url = baseurl+"/v1/employee/add";
	public static String get_url = baseurl+"/v1/employee";
	public static String update_url=baseurl+"/v1/employee/updateEmployee";
	public static String delete_url=baseurl+"/v1/employee/deleteEmployee?id=";
	public static String search_url=baseurl+"/v1/employee/search";
	
	//teams 
	
	public static String teams_post_url = baseurl+"/v1/teams/create";
	public static String teams_get_url = baseurl+"/v1/teams";
	public static String teams_update_url=baseurl+"/v1/teams/update_teams";
	public static String teams_delete_url=baseurl+"/v1/teams/delete?id=";
	
	
	//Project
	
	public static String project_create_url = baseurl+"/v1/project/create";
	public static String projects_url = baseurl+"/v1/project/search";
	public static String project_update_url=baseurl+"/v1/project/updateProjectTeam";
	public static String project_delete_url=baseurl+"/v1/project/delete_project?projectId=";
	
	
	//uploadFile
	
	public static String upload_file = "http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/upload";
	public static String uploadError_file = "http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/upload";
	public static String upload_Error_fix="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/uploadError/";
	public static String Get_file = "http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/files";
	public static String Update_file ="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/updateFile/";
	public static String Delete_file="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/";
	public static String GetFileByFleId ="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/fileInfo/"; 
	
	
	//uploadpdf
	
	public static String upload_pdf="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/uploadPDF";
	public static String pdf_delete ="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/pdf/";
	
	
	//Phrase
	
	public static String Add_phrase =baseurl+"/v1/abbreviation/add";
	public static String Get_phrase =baseurl+"/v1/abbreviation/searchByProject?/";
	public static String Update_phrase =baseurl+"/v1/abbreviation/update";
	public static String Delete_phrase =baseurl+"/v1/abbreviation/delete";
	
	//search
	public static String excel_data =baseurl+"/v1/search/data";
	public static String pdf_data =baseurl+"/v1/search/data/pdf";
	
	
	//Dashboards
	
	public static String DashboardCount =baseurl+"/v1/dashboard/getAllCounts";
	
	//Downloads
	
	public static String FileDownload ="http://18.220.125.215:8090/rest/internal/backgroundWorker/background-job-worker/download/";
	
	
	
}
