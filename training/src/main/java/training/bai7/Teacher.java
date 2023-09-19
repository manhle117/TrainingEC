package training.bai7;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Teacher extends Person {
	private String teacherId;
	private double salary;
	private double bonusSalary;
	private double fineMoney;
	private String classId;

	public Teacher() {
		super();
	}

	public Teacher(String fullName, int old, String homeTown, String teacherId, double salary, double bonusSalary,
			double fineMoney, String classId) {
		super(fullName, old, homeTown);
		this.teacherId = teacherId;
		this.salary = salary;
		this.bonusSalary = bonusSalary;
		this.fineMoney = fineMoney;
		this.classId = classId;
	}

	public Teacher(String teacherId, double salary, double bonusSalary, double fineMoney, String classId) {
		super();
		this.teacherId = teacherId;
		this.salary = salary;
		this.bonusSalary = bonusSalary;
		this.fineMoney = fineMoney;
		this.classId = classId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public double getBonusSalary() {
		return bonusSalary;
	}

	public void setBonusSalary(double bonusSalary) {
		this.bonusSalary = bonusSalary;
	}

	public double getFineMoney() {
		return fineMoney;
	}

	public void setFineMoney(double fineMoney) {
		this.fineMoney = fineMoney;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Double getSalary() {

		return salary + bonusSalary - fineMoney;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", FullName=" + getFullName() + ", Old=" + getOld() + ", HomeTown="
				+ getHomeTown() + ", salary=" + salary + ", bonusSalary=" + bonusSalary + ", fineMoney=" + fineMoney
				+ ", classId=" + classId + ", Real Salary=" + getSalary()

				+ "]";
	}

	public void addTeacher(List<Teacher> listTeacher) {
		Scanner sc = new Scanner(System.in);
		Optional<Teacher> newList = null;
		while(true) {
			System.out.println("Teacher ID: ");
			teacherId = sc.nextLine();
			newList = listTeacher.stream().filter(x -> x.getTeacherId().equals(teacherId)).findFirst();
			if(newList.isEmpty()) {
				break;
			}else {
				System.err.println("Duplicate Student Id, please input again");
			}	
		}
		
		System.out.println("Class ID: ");
		classId = sc.nextLine();
		System.out.println("Salary: ");
		salary = Double.parseDouble(sc.nextLine());
		System.out.println("Bonus Salary: ");
		bonusSalary = Double.parseDouble(sc.nextLine());
		System.out.println("Fine Salary: ");
		fineMoney = Double.parseDouble(sc.nextLine());

	}

}
