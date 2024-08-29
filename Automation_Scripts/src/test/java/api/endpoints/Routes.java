package api.endpoints;

public class Routes {
	
	public static String baseurl="http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	public static String ip = "3.15.28.172:8090";
	
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
	public static String teams_employees=baseurl+"/v1/teams/teamEmployee?teamId=";
	public static String delete_team_member=baseurl+"/v1/teams/delete_member?/";
	
	
	//Project
	
	public static String project_create_url = baseurl+"/v1/project/create";
	public static String projects_url = baseurl+"/v1/project/search";
	public static String project_update_url=baseurl+"/v1/project/updateProjectTeam";
	public static String project_delete_url=baseurl+"/v1/project/delete_project?projectId=";
	
	
	//uploadFile
	
	public static String upload_file = "http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/upload";
	public static String uploadError_file = "http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/upload";
	public static String upload_Error_fix="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/uploadError/";
	public static String Get_file = "http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/files";
	public static String Update_file ="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/updateFile/";
	public static String Delete_file="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/";
	public static String GetFileByFleId ="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/fileInfo/"; 
	
	
	//uploadpdf
	
	public static String upload_pdf="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/uploadPDF";
	public static String pdf_delete ="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/pdf/";
	
	
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
	
	public static String FileDownload ="http://"+ip+"/rest/internal/backgroundWorker/background-job-worker/download/";
	
	//Search History
	
	public static String ExcelSearchHistory =baseurl+"/v1/search/getHistory?/";
	public static String PdfSearchHistory =baseurl+"/v1/search/getHistory?/";
	
	
	//Dvs
	public static String DvsOverview =baseurl+"/v1/request/overview";
	
	public static String issueCounts = baseurl+"/v1/search/issuesCounts";
	
	public static String Createrequest =baseurl+"/v1/request/createRequest";
	
	
	//Admin portal
	
	//create
	public static String AdminCreateCompany =baseurl+"/v1/company/adminCreateCompany";
	
	//search
	public static String AdminCompanySearch =baseurl+"/v1/company/adminSearchCompany?/";
	
	//update
	public static String AdminUpdateCompany =baseurl+"/v1/company/adminUpdateCompany";
	
	//disable
	public static String AdminDisableCompany =baseurl+"/v1/company/adminDisableCompany?/";
	
	//dashboard count
	
	public static String AdmindashboardCount =baseurl+"/v1/dashboard/getAllAdminCounts";
	
	//DroneDp
	
	public static String ViewRequest =baseurl+"/v1/request/viewRequests";
	
	public static String RequestCount =baseurl+"/v1/request/getRequestsCount";
	
	public static String GetAllCompanies =baseurl+"/v1/request/getAllCompanies";
	
	public static String DataDvs =baseurl+"/v1/search/dataDvs";
	
	//jira
	
	public static  String JIRA_URL = "https://admintrudosys.atlassian.net/rest/api/2/issue/";
	
	
	//issue Types 
	public static  String Uplaod_issueType = baseurl+"/v1/issue/upload";
	
	public static  String Create_Issue = baseurl+"/v1/issue/createIssueType";
	
	public static  String Get_Issues = baseurl+"/v1/issue/getAllIssueTypes";
	
	
	//Send Letter
	
	public static  String Send_Letter = baseurl+"/v1/mail/send";
	
	
	//Vendor 
	
	public static  String Upload_VendorDetails = baseurl+"/v1/vendor/upload";
	
	public static  String Get_Vendors = baseurl+"/v1/vendor/viewVendors";
	
	
	
	
	
	
	
	
	
	
}
