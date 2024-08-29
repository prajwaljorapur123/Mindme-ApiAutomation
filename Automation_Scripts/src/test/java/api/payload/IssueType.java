package api.payload;

public class IssueType {
	
	String superIssueType;
	String issueType;
    Boolean isActive;
    
    
	public String getSuperIssueType() {
		return superIssueType;
	}
	public void setSuperIssueType(String superIssueType) {
		this.superIssueType = superIssueType;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
