package api.payload.UploadFile;

import java.util.List;

public class ProjectDetails {
	
	     String projectId;
		 String companyId;
	     String createdByID;
	     String fileUniqueName;
	     String error;
	     String fileName;
	     List<Sheet> sheets;
	     
     public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCreatedByID() {
		return createdByID;
	}
	public void setCreatedByID(String createdByID) {
		this.createdByID = createdByID;
	}
	public String getFileUniqueName() {
		return fileUniqueName;
	}
	public void setFileUniqueName(String fileUniqueName) {
		this.fileUniqueName = fileUniqueName;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<Sheet> getSheets() {
		return sheets;
	}
	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}


}
