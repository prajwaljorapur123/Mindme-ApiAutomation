package api.payload;

import java.util.List;

public class Project {

	String projectName;
	List<Integer> teamId;
	int projectId;
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
