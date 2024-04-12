package api.payload;

import api.payload.FileDetailsByid.FileDetails;

public class FileSearch {
	
	 int projectId;
	   int fileId;
	     String isAbbreviation;
	     String searchText;
	     FileDetails fileDetailsModel;
	     
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
