package training.bai6;

import training.common.InputUtils;

public class Student {
	private String fullName;
	private int old;
	private String homeTown;
	private String idClass;
	
	public Student() {
		super();
	}


	public Student(String fullName, int old, String homeTown, String idClass) {
		super();
		this.fullName = fullName;
		this.old = old;
		this.homeTown = homeTown;
		this.idClass = idClass;
	}


	public String getIdClass() {
		return idClass;
	}


	public void setIdClass(String idClass) {
		this.idClass = idClass;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@Override
	public String toString() {
		return "Student [fullName=" + fullName + ", old=" + old + ", homeTown=" + homeTown + "]";
	}
	
	public void addNewStudent() {
		fullName = InputUtils.inputString("Input fullName: ");
		old = InputUtils.inputNumber("Input Old: ");
		homeTown = InputUtils.inputString("Input hometown");
		idClass = InputUtils.inputString("Input idClass");
	}
	
	
	
}
