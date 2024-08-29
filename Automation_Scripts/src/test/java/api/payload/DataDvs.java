package api.payload;

import java.util.List;

import api.payload.FileDetailsByid.FileDetails;

public class DataDvs {
	 int projectId;
     boolean isCommunity;
     String isAbbreviation;
     String searchText;
     List<DvsFilter> filtersDataReq;
     int pageNo;
     int pageSize;
     String fileType;
     FileDetails fileDetailsModel;
     
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public boolean getIsCommunity() {
		return isCommunity;
	}
	public void setIsCommunity(boolean isCommunity) {
		this.isCommunity = isCommunity;
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
	public List<DvsFilter> getFiltersDataReq() {
		return filtersDataReq;
	}
	public void setFiltersDataReq(List<DvsFilter> filtersDataReq) {
		this.filtersDataReq = filtersDataReq;
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
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public FileDetails getFileDetailsModel() {
		return fileDetailsModel;
	}
	public void setFileDetailsModel(FileDetails fileDetailsModel) {
		this.fileDetailsModel = fileDetailsModel;
	}
     
     

}


