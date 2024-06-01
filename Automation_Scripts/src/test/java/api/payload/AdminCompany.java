package api.payload;
import java.util.List;
public class AdminCompany {
	

	
	     String companyName;
	     String password;
	     String deviceId;
	     String deviceType;
	     String imageId;
	     int empLimit;
	     String expireDate;
	     CompanyEmp addEmployee;
	     
	     int id;
	     String phone;
	     
	     public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		String name;
	     int pageNo;
	     int pageSize;
	     int searchType;

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public int getSearchType() {
			return searchType;
		}

		public void setSearchType(int searchType) {
			this.searchType = searchType;
		}

		// Getters and Setters
	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getDeviceId() {
	        return deviceId;
	    }

	    public void setDeviceId(String deviceId) {
	        this.deviceId = deviceId;
	    }

	    public String getDeviceType() {
	        return deviceType;
	    }

	    public void setDeviceType(String deviceType) {
	        this.deviceType = deviceType;
	    }

	    public String getImageId() {
	        return imageId;
	    }

	    public void setImageId(String imageId) {
	        this.imageId = imageId;
	    }

	    public int getEmpLimit() {
	        return empLimit;
	    }

	    public void setEmpLimit(int empLimit) {
	        this.empLimit = empLimit;
	    }

	    public String getExpireDate() {
	        return expireDate;
	    }

	    public void setExpireDate(String expireDate) {
	        this.expireDate = expireDate;
	    }

	    public CompanyEmp getAddEmployee() {
	        return addEmployee;
	    }

	    public void setAddEmployee(CompanyEmp addEmployee) {
	        this.addEmployee = addEmployee;
	    }
	}



