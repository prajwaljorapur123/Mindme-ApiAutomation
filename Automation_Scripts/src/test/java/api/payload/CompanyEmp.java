package api.payload;
import java.util.List;

public class CompanyEmp {
	

	
	    String empType;
	     String firstName;
	     String lastName;
	     String designation;
	     String countryCode;
	     String email;
	     String phone;
	    List<Integer> permissionIds;
	     String imageId;

	    // Getters and Setters
	    public String getEmpType() {
	        return empType;
	    }

	    public void setEmpType(String empType) {
	        this.empType = empType;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getDesignation() {
	        return designation;
	    }

	    public void setDesignation(String designation) {
	        this.designation = designation;
	    }

	    public String getCountryCode() {
	        return countryCode;
	    }

	    public void setCountryCode(String countryCode) {
	        this.countryCode = countryCode;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public List<Integer> getPermissionIds() {
	        return permissionIds;
	    }

	    public void setPermissionIds(List<Integer> permissionIds) {
	        this.permissionIds = permissionIds;
	    }

	    public String getImageId() {
	        return imageId;
	    }

	    public void setImageId(String imageId) {
	        this.imageId = imageId;
	    }
	}



