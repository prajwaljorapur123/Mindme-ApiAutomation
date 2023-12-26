package api.payload;

public class Employee {
	int eid;
	String firstName;
	 String lastName;
	 String email;
	 String countryCode;
	 String phone;
	 int[] permissionIds ;
	 String designation;
	 String imageId;
	 
	 public int geteid() {
			return eid;
		} 
	 public void seteid(int eid) {
			this.eid = eid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int[] getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(int[] permissionIds) {
		this.permissionIds = permissionIds;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

 
 
}
