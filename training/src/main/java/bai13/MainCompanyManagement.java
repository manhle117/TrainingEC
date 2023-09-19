package bai13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import bai13.exception.BirthDayException;
import bai13.exception.EmailException;
import bai13.exception.FullNameException;
import bai13.exception.PhoneException;
import bai13.model.*;
import training.common.InputUtils;

public class MainCompanyManagement {

	public static void main(String[] args) throws  Exception {
		EmployeeManagement employeeManagement = new EmployeeManagement();
		 int choice;
	        do {
	            System.out.println("----- Employee Management System -----");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Update Employee");
	            System.out.println("3. Delete Employee");
	            System.out.println("4. Find All Employees");
				System.out.println("5. Find Intern Employees");
	            System.out.println("6. Find Experience Employees");
	            System.out.println("7. Find Fresher Employees");
	            System.out.println("0. Exit");
	            choice = InputUtils.inputNumber("Input your choice: ");

	            switch (choice) {
	                case 1:
	                    // Chức năng thêm nhân viên
	                    // Gọi phương thức thêm nhân viên từ hệ thống quản lý nhân viên
	                    Employee employee = addEmployee();
						employeeManagement.addEmployee(employee);
	                    break;
	                case 2:
	                    // Chức năng cập nhật thông tin nhân viên
	                    // Gọi phương thức cập nhật thông tin nhân viên từ hệ thống quản lý nhân viên
						String employeeIdEdit = InputUtils.inputString("Input employeeId want edit");
						Employee isExisting = employeeManagement.findEmployeeByEmployeeId(employeeIdEdit);
						if (isExisting!= null) {
							System.out.println("Input New Information: ");
							Employee employeeEdit = addEmployee();
                            employeeManagement.updateEmployee(employeeIdEdit,employeeEdit);
                        }else {
							System.out.println("Not found employee");
						}
	                    break;
	                case 3:
	                    // Chức năng xóa nhân viên
	                    // Gọi phương thức xóa nhân viên từ hệ thống quản lý nhân viên
	                   	String employeeIdDelete = InputUtils.inputString("Input employeeId want delete");
						   if (employeeManagement.deleteEmployee(employeeIdDelete)){
							   System.out.println("Employee deleted");
						   }else {
							   System.out.println("Not found employee");
						   }

	                    break;
					case 4:
						employeeManagement.showAllEmployees();
						break;
	                case 5:
	                  employeeManagement.getListIntern().forEach(System.out::println);

	                    break;
	                case 6:
						employeeManagement.getListExperience().forEach(System.out::println);

	                    break;
	                case 7:
						employeeManagement.getListFresher().forEach(System.out::println);
	                    break;
	                case 0:
	                    System.out.println("Thank you for using the Employee Management System!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        } while (choice != 0);
	}

	private static Employee addEmployee() throws FullNameException {
		//ID, FullName, BirthDay,Phone, Email, Employee_type,Employee_count
		List<Certificate> listCerti = new ArrayList<>();
		Employee employee = null;
		String empId = InputUtils.inputString("Input Employee ID: ");
		String fullName ="";
		while (true){
			try{
				fullName = InputUtils.inputString("Input fullName: ");
				Validator.fullName(fullName);
				break;
			}catch (FullNameException e){
				System.err.println(e.getMessage());
			}
		}
		String birthDay ="";
		while (true){
			try {
				  birthDay = InputUtils.inputString("Input birthDay: ");
				Validator.birth(birthDay);
				break;
			}catch (BirthDayException e){
				System.out.println(e.getMessage());
			}
		}
		String phone = "";
		while (true) {
			try {
				phone = InputUtils.inputString("Input phone number (10 numberic): ");
				Validator.phone(phone);
				break;
			} catch (PhoneException e) {
				System.err.println(e.getMessage());
			}
		}
		String email = "";
		while (true) {
			try {
				email = InputUtils.inputString("Input email: ");
				Validator.email(email);
				break;
			} catch (EmailException e) {
				System.err.println(e.getMessage());
			}
		}
		int numberOfCerti = InputUtils.inputNumber("Input numer of certificate: ");
		Certificate certi =null;
		for(int i = 0; i < numberOfCerti; i++) {
			int certiId = InputUtils.inputNumber("Input certificateID: ");
			String certiName = InputUtils.inputString("Input certiName: ");
            String certiDate = "";
            while (true) {
                try {
                    certiDate = InputUtils.inputString("Input certiDate: ");
                    Validator.birth(certiDate);
                    break;
                } catch (BirthDayException e) {
                    System.err.println(e.getMessage());
                }
            }
            String certiRank = InputUtils.inputString("Input certiRank: ");

             certi = new Certificate(certiId,certiName, certiDate, certiRank);
            listCerti.add(certi);
		}
		int employeeType = -1;
		while (true) {
			employeeType
					= InputUtils.inputNumber("Choice Type employee (0: Experience, 1: Fresher, 2: Intern): ");
			if (employeeType < 0 || employeeType > 2) {
				System.err.println("Not valid, must be between 0 and 2.");
			} else {
				break;
			}
		}
		if (employeeType == 0) {
			int expInYear = InputUtils.inputNumber("Input Year of Experience : ");
			String proSkill = InputUtils.inputString("Input proSkill: ");

			employee = new Experience(empId,fullName,birthDay,phone,email,employeeType,listCerti,expInYear,proSkill);
		} else if (employeeType == 1) {
			String graduationDate = "";
			while (true) {
				try {
					graduationDate = InputUtils.inputString("Input graduationDate: ");
					Validator.birth(graduationDate);
					break;
				} catch (BirthDayException e) {
					System.err.println(e.getMessage());
				}
			}
			String graduationRank = InputUtils.inputString("Input graduationRank: ");
			String education = InputUtils.inputString("Input University: ");

			employee = new Fresher(empId,fullName, birthDay, phone, email,employeeType,listCerti, graduationDate, graduationRank, education);
		} else {
			String majors = InputUtils.inputString("Nhập chuyên ngành đang học: ");
			int semester = InputUtils.inputNumber("Nhập học kì đang học: ");
			String universityName = InputUtils.inputString("Nhập tên trường đang học: ");

			employee = new Intern(empId,fullName, birthDay, phone, email, employeeType, listCerti,majors, semester, universityName);
		}



        return employee;
    }



}
