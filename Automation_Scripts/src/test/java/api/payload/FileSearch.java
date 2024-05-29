package api.payload;

import api.payload.FileDetailsByid.FileDetails;

public class FileSearch {
	
	 int projectId;
	   int fileId;
	     String isAbbreviation;
	     String searchText;
	     FileDetails fileDetailsModel;
	     String fileType;
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
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		public int getFileId() {
			return fileId;
		}
		public void setFileId(int fileId) {
			this.fileId = fileId;
		}
		public String getIsAbbreviation() {
			return isAbbreviation;
		}
		public void setIsAbbreviation(String isAbbreviation) {
			this.isAbbreviation = isAbbreviation;
		}
		public String getSearchText() {
			return searchText;
		}
		public void setSearchText(String searchText) {
			this.searchText = searchText;
		}
		public FileDetails getFileDetailsModel() {
			return fileDetailsModel;
		}
		public void setFileDetailsModel(FileDetails fileDetailsModel) {
			this.fileDetailsModel = fileDetailsModel;
		}
		

}
