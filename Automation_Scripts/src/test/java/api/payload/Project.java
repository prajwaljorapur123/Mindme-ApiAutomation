package api.payload;

import java.util.List;

public class Project {

	String projectName;
	List<Integer> teamId;
	int projectId;
	 int pageNo;
	    int pageSize;
	    
	   
	public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
	public int getprojectId() {
		return projectId;
	}
	public void setprojectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Integer> getteamId() {
		return teamId;
	}
	public void setteamId(List<Integer> teamId) {
		this.teamId = teamId;
	}
}
