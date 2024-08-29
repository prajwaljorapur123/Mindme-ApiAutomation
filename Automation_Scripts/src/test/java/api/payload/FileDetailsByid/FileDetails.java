		package api.payload.FileDetailsByid;

import java.util.List;

import api.payload.FileDetailsByid.Sheet;;

public class FileDetails {
	 int fileId;
     String companyId;
     String projectId;
     String fileName;
     String fileType;
     String fileUniqueName;
     String fileProcessingStatus;
     String createdDate;
     String timeUpdated;
     int createdByID;
     int requestRefID;
     String fileSize;
     String error;
     boolean activeStatus;
     List<Sheet> sheets;
     
     public int getRequestRefID() {
		return requestRefID;
	}
	public void setRequestRefID(int requestRefID) {
		this.requestRefID = requestRefID;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
    
    
     
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileUniqueName() {
		return fileUniqueName;
	}
	public void setFileUniqueName(String fileUniqueName) {
		this.fileUniqueName = fileUniqueName;
	}
	public String getFileProcessingStatus() {
		return fileProcessingStatus;
	}
	public void setFileProcessingStatus(String fileProcessingStatus) {
		this.fileProcessingStatus = fileProcessingStatus;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getTimeUpdated() {
		return timeUpdated;
	}
	public void setTimeUpdated(String timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	public int getCreatedByID() {
		return createdByID;
	}
	public void setCreatedByID(int createdByID) {
		this.createdByID = createdByID;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public List<Sheet> getSheets() {
		return sheets;
	}
	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}
     


}
