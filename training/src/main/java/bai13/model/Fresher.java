package bai13.model;

import java.util.Date;
import java.util.List;

public class Fresher extends Employee {
	private String graduationDate;
	private String graduationRank;
	private String university;
	
	



	public Fresher(String employeeId, String fullName, String birthDay, String phone, String email, int employeeType,
			List<Certificate> listCerti, String graduationDate, String graduationRank, String university) {
		super(employeeId, fullName, birthDay, phone, email, employeeType, listCerti);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.university = university;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}


	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	@Override
	public String toString() {
		return "Fresher{" +
				", employeeId='" + employeeId + '\'' +
				", fullName='" + fullName + '\'' +
				", birthDay='" + birthDay + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", employeeType=" + employeeType +
				", listCerti=" + listCerti +
				"graduationDate='" + graduationDate + '\'' +
				", graduationRank='" + graduationRank + '\'' +
				", university='" + university + '\'' +
				'}';
	}

	@Override
	public void showInfor() {
		System.out.println(toString());
	}
	
}
