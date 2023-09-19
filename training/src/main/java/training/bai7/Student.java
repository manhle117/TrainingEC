package training.bai7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class Student extends Person {
	private String studentId;
	private String teacherId;
	
	
	public Student() {
		super();
	}


	


	public Student(String fullName, int old, String homeTown, String studentId, String teacherId) {
		super(fullName, old, homeTown);
		this.studentId = studentId;
		this.teacherId = teacherId;
	}



	public Student(String studentId, String teacherId) {
		super();
		this.studentId = studentId;
		this.teacherId = teacherId;
	}





	public String getTeacherId() {
		return teacherId;
	}





	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}





	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	



	@Override
	public String toString() {
		return "Student [FullName =" + getFullName()  + ", teacherId=" + teacherId
				+ ", studentId=" + studentId + ", Old=" + getOld() + ", getHomeTown=" + getHomeTown()
				+ "]";
	}





	public void addStudent(List<Student> listStudent,List<Teacher> listTeacher) {
		Scanner sc = new Scanner(System.in);
		Optional<Student> newList = null;
		while(true) {
			System.out.println("StudentId");
			studentId = sc.nextLine();   
			newList = listStudent.stream().filter(x -> x.getStudentId().equals(studentId)).findFirst();
			if(newList.isEmpty()) {
				break;
			}else {
				System.err.println("Duplicate Student Id, please input again");
			}	
		}
		boolean isExistTeacher = false;
		while(true) {
			System.out.println("teacherId");
			teacherId =sc.nextLine();
			for (Teacher teacher : listTeacher) {
				if(teacher.getTeacherId().equals(teacherId)) {
					isExistTeacher = true;
					break;
				}
			}
			if(isExistTeacher) {
				break;
			}else {
				System.err.println("Not Exist teacher, please input again");
			}	
		}
		
		
	}
	
	
}
