package training.bai15;


import training.bai15.dao.SchoolDao;
import training.bai15.exception.InvalidDOBExceptionException;
import training.bai15.exception.InvalidFullNameException;
import training.bai15.exception.InvalidOrtherException;
import training.bai15.model.Department;
import training.bai15.model.Enrollment;
import training.bai15.model.Student;
import training.bai15.model.StudentTC;
import training.common.InputUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MainSchoolManagement {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add New Student");
            System.out.println("2. Add new Enrollment");
            System.out.println("3. Show all Students");
            System.out.println("4. Count all Student CQ ");
            System.out.println("4. Thoát");
            int choice = InputUtils.inputNumber("Chọn tùy chọn (1-4): ");

            switch (choice) {
                case 1:
                    //convert sang class Object
                    Student student = addNewStudent();
                    SchoolDao.insertStudent(student);
                    break;

                case 2:
                    Enrollment enrollment = addnewEnrollment();
                    break;

                case 3: {
                    List<Student> studentList = SchoolDao.getListStudents();
                    studentList.forEach(System.out::println);
                    break;
                }

                case 4: {
                   long count = SchoolDao.getNumberOfStudentCQ();
                    System.out.println("Number of Student CQ: "+ count);
                }
                case 5:
//                    StudentDao.updateTest();
                    break;
                default:
                    System.out.println("Invalid input, choose again!!.");
            }
        }
    }

    private static Enrollment addnewEnrollment() {
        List<Student> listStudent = SchoolDao.getListStudents();
        boolean isExistsStudent;
        for (int i = 1; i <= listStudent.size(); i++) {
            System.out.println("Id: "+ listStudent.get(i).getId() + ", StudentCode: " + listStudent.get(i).getStudentCode() + ", Student Name:  " + listStudent.get(i).getFullName());
        }
        int choose;
        while (true){
            try{
                choose = InputUtils.inputNumber("Choose Student: ");
                isExistsStudent =  findStudent(listStudent,choose);
                if(!isExistsStudent){
                    throw new InvalidOrtherException("Invalid Input, please choose the number in front of the students!!");
                }
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        String semesterName = "";
        while (true) {
            try {
                semesterName = InputUtils.inputString("Enter semester name: ");
                Validator.stringNormal(semesterName);
                break;
            }catch (InvalidOrtherException e){
                System.out.println(e.getMessage());
            }
        }
        double averageScore = 0;
        while (true) {
            try {
                averageScore = InputUtils.inputDouble("Enter average score: ");
                Validator.checkDouble(averageScore);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Enrollment(choose, semesterName, averageScore);
    }

    public static Boolean findStudent(List<Student> listStudent, int choose) {
        for (Student student : listStudent) {
            if(student.getId() == choose ){
                return true;
            }
        }
        return false;
    }

    private static Student addNewStudent() {
        String studentCode = "";
        String fullName = "";
        Date doB = null;
        int yearOfAdmission;
        double entranceScore;
        int departmentId;
        List<Department> listDepartment = SchoolDao.getListDepartments();

        while (true) {

            try {
                studentCode = InputUtils.inputString("Enter student code: ");
                Validator.checkCode(studentCode);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                fullName = InputUtils.inputString("Enter full name: ");
                Validator.fullName(fullName);
                break;
            } catch (InvalidFullNameException e) {
                System.out.println(e.getMessage());
            }
        }
        String dateInput = "";
        while (true) {
            try {
                dateInput = InputUtils.inputString("Enter doB: ");
                doB = Validator.parseDate(dateInput);
                break;
            } catch (InvalidDOBExceptionException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                yearOfAdmission = InputUtils.inputNumber("Enter year of admission: ");
                Validator.checkYearOfAdmission(yearOfAdmission);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                entranceScore = InputUtils.inputDouble("Enter entrance score: ");
                Validator.checkDouble(entranceScore);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 1; i <= listDepartment.size(); i++) {
            System.out.println(i + ". " + listDepartment.get(i).getDepartmentName());
        }
        while (true) {
            try {
                departmentId = InputUtils.inputNumber("Enter department id: ");
                if (departmentId < 0 || departmentId > listDepartment.size()) {
                    throw new InvalidOrtherException("Invalid input, choose again!!.");
                }
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        if (studentCode.substring(0, 2).equals("TC")) {
            String trainingLocation;
            while (true) {
                try {
                    trainingLocation = InputUtils.inputString("Enter training location: ");
                    Validator.fullName(trainingLocation);
                    break;
                } catch (InvalidFullNameException e) {
                    System.out.println(e.getMessage());
                }
            }
          return  new StudentTC(studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId, trainingLocation);
        }
        return new Student(studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
    }


}
