package api.payload.UploadFile;

import java.util.List;

public class ProjectDetails {
	
	int ProjectId;
		 int companyId;
	     int createdByID;
	     String fileUniqueName;
	     String error;
	     String fileName;
	     List<Sheet> sheets;
	     

	 	public int getProjectId() {
	 		return ProjectId;
	 	}
	 	public void setProjectId(int projectId) {
	 		ProjectId = projectId;
	 	}
	     
    
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCreatedByID() {
		return createdByID;
	}
	public void setCreatedByID(int createdByID) {
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
