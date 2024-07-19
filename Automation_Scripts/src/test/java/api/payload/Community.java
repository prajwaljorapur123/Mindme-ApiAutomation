package api.payload;

import java.util.List;

public class Community {
	int companyId;
	
	String projectName;
	List<Integer> teamId;
	Boolean isCommunity;
	
	int pageNo;
	int pageSize;
	
	int projectId;
	String description;
	String frequencyType;
	String customDate;
	String communityName;
	Integer communityId;
	
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFrequencyType() {
		return frequencyType;
	}
	public void setFrequencyType(String frequencyType) {
		this.frequencyType = frequencyType;
	}
	public String getCustomDate() {
		return customDate;
	}
	public void setCustomDate(String customDate) {
		this.customDate = customDate;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Integer> getTeamId() {
		return teamId;
	}
	public void setTeamId(List<Integer> teamId) {
		this.teamId = teamId;
	}
	public Boolean getIsCommunity() {
		return isCommunity;
	}
	public void setIsCommunity(Boolean isCommunity) {
		this.isCommunity = isCommunity;
	}

}
