package api.payload;

import java.util.List;


public class Team {
	String teamName;
    List<Integer> empId;
    int pageNo;
    int pageSize;
    int teamId;
	
	
	     public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamIDS) {
		this.teamId = teamIDS;
	}
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
		public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Integer> getEmpId() {
		return empId;
	}
	public void setEmpId(List<Integer> empId) {
		this.empId = empId;
	}
		

}
