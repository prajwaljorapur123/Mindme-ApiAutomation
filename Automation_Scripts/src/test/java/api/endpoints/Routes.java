package api.endpoints;

public class Routes {
	
	public static String baseurl="http://mindmedev-env.eba-p3axgdvz.us-east-2.elasticbeanstalk.com";
	
	
	//Login
	public static String login_post_url = baseurl+"/v1/auth/login";
	
    
	//employee 
	
	public static String post_url = baseurl+"/v1/employee/add";
	public static String get_url = baseurl+"/v1/employee/Details";
	public static String update_url=baseurl+"/v1/employee/updateEmployee";
	public static String delete_url=baseurl+"/v1/employee/deleteEmployee/";
	public static String search_url=baseurl+"/v1/employee/search";
	
	//teams 
	
	public static String teams_post_url = baseurl+"/v1/teams/create";
	public static String teams_get_url = baseurl+"/v1/teams";
	public static String teams_update_url=baseurl+"/v1/teams/update_teams";
	public static String teams_delete_url=baseurl+"/v1/teams/delete/";
	
	
}
