package training.bai13.model;

import java.util.List;

public class Experience extends Employee {
	private int expInYear;
	private String proSkill;
	
	



	public Experience(String employeeId, String fullName, String birthDay, String phone, String email, int employeeType,
			List<Certificate> listCerti, int expInYear, String proSkill) {
		super(employeeId, fullName, birthDay, phone, email, employeeType, listCerti);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}


	public int getExpInYear() {
		return expInYear;
	}


	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}


	public String getProSkill() {
		return proSkill;
	}


	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}


	@Override
	public String toString() {
		return "Experience{" +
				", employeeId='" + employeeId + '\'' +
				", fullName='" + fullName + '\'' +
				", birthDay='" + birthDay + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", employeeType=" + employeeType +
				", listCerti=" + listCerti +
				"expInYear=" + expInYear +
				", proSkill='" + proSkill + '\'' +
				'}';
	}

	@Override
	public void showInfor() {
		System.out.println(toString());
	}
}
