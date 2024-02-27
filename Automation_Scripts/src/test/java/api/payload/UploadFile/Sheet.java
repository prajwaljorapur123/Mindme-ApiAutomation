package api.payload.UploadFile;

import java.util.List;

public class Sheet {
	String sheetName;
    String valuePosition;
    String approach;
    List<Header> headers;
    
    public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getValuePosition() {
		return valuePosition;
	}
	public void setValuePosition(String valuePosition) {
		this.valuePosition = valuePosition;
	}
	public String getApproach() {
		return approach;
	}
	public void setApproach(String approach) {
		this.approach = approach;
	}
	public List<Header> getHeaders() {
		return headers;
	}
	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}
	

}
