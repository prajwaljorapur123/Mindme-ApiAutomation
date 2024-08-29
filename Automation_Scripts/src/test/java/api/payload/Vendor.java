package api.payload;

import java.util.List;

public class Vendor {

	 int companyId;
     List<String> workType;
     String searchVendorText;
     String issueSummary;
     String pageNo;
     String pageSize;
     
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public List<String> getWorkType() {
		return workType;
	}
	public void setWorkType(List<String> workType) {
		this.workType = workType;
	}
	public String getSearchVendorText() {
		return searchVendorText;
	}
	public void setSearchVendorText(String searchVendorText) {
		this.searchVendorText = searchVendorText;
	}
	public String getIssueSummary() {
		return issueSummary;
	}
	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
}
