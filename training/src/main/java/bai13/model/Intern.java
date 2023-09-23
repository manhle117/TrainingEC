package bai13.model;

import java.util.Date;
import java.util.List;

public class Intern extends Employee{
	private String majors;
	private int semester;
	private String universityName;
	

	

	public Intern(String employeeId, String fullName, String birthDay, String phone, String email, int employeeType,
			List<Certificate> listCerti, String majors, int semester, String universityName) {
		super(employeeId, fullName, birthDay, phone, email, employeeType, listCerti);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}


	public String getMajors() {
		return majors;
	}


	public void setMajors(String majors) {
		this.majors = majors;
	}


	public int getSemester() {
		return semester;
	}


	public void setSemester(int semester) {
		this.semester = semester;
	}


	public String getUniversityName() {
		return universityName;
	}


	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}


	@Override
	public String toString() {
		return "Intern{" +
				", employeeId='" + employeeId + '\'' +
				", fullName='" + fullName + '\'' +
				", birthDay='" + birthDay + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", employeeType=" + employeeType +
				", listCerti=" + listCerti +
				"majors='" + majors + '\'' +
				", semester=" + semester +
				", universityName='" + universityName + '\'' +

				'}';
	}

	@Override
	public void showInfor() {
		// TODO Auto-generated method stub
		
	}
	
}
