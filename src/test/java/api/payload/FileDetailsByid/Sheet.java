package api.payload.FileDetailsByid;

import java.util.List;

public class Sheet {
	    int sheetId;
     String sheetName;
     String approach;
     String valuePosition;
    List<Header> headers;
    
	public int getSheetId() {
		return sheetId;
	}
	public void setSheetId(int sheetId) {
		this.sheetId = sheetId;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getApproach() {
		return approach;
	}
	public void setApproach(String approach) {
		this.approach = approach;
	}
	public String getValuePosition() {
		return valuePosition;
	}
	public void setValuePosition(String valuePosition) {
		this.valuePosition = valuePosition;
	}
	public List<Header> getHeaders() {
		return headers;
	}
	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}
    
    

}
