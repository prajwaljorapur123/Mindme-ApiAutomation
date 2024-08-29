package api.payload;

import java.util.List;

public class DvsFilter {
	 String fieldName;
     String operator;
     List<String> value;
     
     // Getters and setters
     
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}


}
