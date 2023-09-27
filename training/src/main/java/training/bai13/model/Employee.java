package training.bai13.model;

import java.util.List;

public abstract class Employee {
	protected String employeeId;
	protected String fullName;
	protected String birthDay;
	protected String phone;
	protected String email;
	protected int employeeType;
	protected static int employeeCount;
	protected List<Certificate> listCerti;
	
	


	public Employee(String employeeId, String fullName, String birthDay, String phone, String email, int employeeType,
			List<Certificate> listCerti) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		this.listCerti = listCerti;
	}


	public List<Certificate> getListCerti() {
		return listCerti;
	}


	public void setListCerti(List<Certificate> listCerti) {
		this.listCerti = listCerti;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}


	public static int getEmployeeCount() {
		return employeeCount;
	}


	public static void setEmployeeCount(int employeeCount) {
		Employee.employeeCount = employeeCount;
	}
	
	
	
	public abstract void showInfor() ;
	
}
