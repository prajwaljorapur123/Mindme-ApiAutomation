package api.payload.FileDetailsByid;

public class Header {
	
	 int headerId;
  String position;
     String dataType;
     String headerName;
     
     public int getHeaderId() {
		return headerId;
	}
	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getMadeUpName() {
		return madeUpName;
	}
	public void setMadeUpName(String madeUpName) {
		this.madeUpName = madeUpName;
	}
	String madeUpName;

}
