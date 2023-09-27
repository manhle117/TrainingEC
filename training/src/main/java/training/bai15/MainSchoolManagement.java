package training.bai15;


import training.bai15.dao.SchoolDao;
import training.bai15.exception.InvalidDOBExceptionException;
import training.bai15.exception.InvalidFullNameException;
import training.bai15.exception.InvalidOrtherException;
import training.bai15.model.*;
import training.common.InputUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainSchoolManagement {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add New Student");
            System.out.println("2. Add new Enrollment");
            System.out.println("3. Show all Students");
            System.out.println("4. Count all Student CQ ");
            System.out.println("5. Get Student Highest entranceScore in Department");
            System.out.println("6. Get Average Score of Student by semester Name");
            System.out.println("7. Get StudentList By Training Location");
            System.out.println("8. Get list Student Has Average Higher Than 8");
            System.out.println("9. Get Student has average highest in Department");
            System.out.println("10. Sort by Year ");
            System.out.println("11. Number of students in Year ");
            System.out.println("12. Exit");
            int choice = InputUtils.inputNumber("Choose (1-12): ");

            switch (choice) {
                case 1:
                    //convert sang class Object
                    Student student = addNewStudent();
                    SchoolDao.insertStudent(student);
                    break;

                case 2:
                    Enrollment enrollment = addnewEnrollment();
                    SchoolDao.insertEnrollment(enrollment);
                    break;

                case 3: {
                    Set<Student> studentList = SchoolDao.getListStudents();
                    studentList.forEach(System.out::println);
                    break;
                }

                case 4: {
                    List<Department> listDepartments = SchoolDao.getListDepartments();
                    for (int i = 0; i < listDepartments.size(); i++) {
                        System.out.println(i + 1 + ". " + listDepartments.get(i).getDepartmentName());
                    }
                    int departmentId = 0;
                    while (true) {
                        try {
                            departmentId = InputUtils.inputNumber("Enter department id: ");
                            if (departmentId < 0 || departmentId > listDepartments.size()) {
                                throw new InvalidOrtherException("Invalid input, choose again!!.");
                            }
                            break;
                        } catch (InvalidOrtherException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    int count = SchoolDao.getCountStudentCQByDepartment(departmentId);
                    System.out.println("Number of Student CQ in Department: " + count);
                    break;
                }
                case 5:
                    List<Student> listStudent = SchoolDao.getStudentHasMaxEntryScoreInDepartment();
                    listStudent.forEach(System.out::println);
                    break;
                case 6:
                    String semesterName = InputUtils.inputString("Input semesterName: ");
                    List<StudentDao> listStudentDao = SchoolDao.getStudentListBySemesterName(semesterName);
                    if (listStudentDao.isEmpty()) {
                        System.err.println("Have no student in this semester " + semesterName);
                    } else {
                        listStudentDao.forEach(s -> {
                            System.out.println("Student Code: " + s.getStudentCode() +
                                    ", Full name: " + s.getFullName() + ", averageScore: " + s.getAverageScore());
                        });
                    }
                    break;
                case 7: {
                    String trainingLocation;
                    while (true) {
                        try {
                            trainingLocation = InputUtils.inputString("Enter training location: ");
                            Validator.stringNormal(trainingLocation);
                            break;
                        } catch (InvalidOrtherException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    List<StudentTC> listStudentTC = SchoolDao.getStudentListByTrainingLocation(trainingLocation);
                    if (listStudentTC.isEmpty()) {
                        System.err.println("Have no student in this training location " + trainingLocation);
                    } else {
                        listStudentTC.forEach(System.out::println);
                    }
                    break;
                }
                case 8: {
                    List<DepartmentDao> listStu = SchoolDao.listStudentHasAverageHigherThan8();
                    listStu.forEach(System.out::println);
                }
                case 9: {
                    List<StudentDao> listStud = SchoolDao.getStudentHasAverageScoreHighestInDep();
                    listStud.forEach(System.out::println);
                }
                case 10: {
                    Set<Student> list = SchoolDao.getListStudents();
//                    Set<Student> sortedList = list.stream()
//                            .sorted(Comparator.comparing(Student::getStudentCode)
//                                    .thenComparing(Comparator.comparing(Student::getYearOfAdmission).reversed()))
//                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    Set<Student> sortedList = list.stream()
                            .sorted(Comparator.comparing(Student::getYearOfAdmission).reversed())
                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    sortedList.forEach(System.out::println);
                    break;
                }
                case 11: {
                    Map<Integer, Integer> map = SchoolDao.getNumberOfStudentByYear();
                    map.forEach((key,value) -> {
                        System.out.println(key + ": " + value);
                    });
                    break;
                }
                case 12:
                    java.util.Date dateNow = new java.util.Date();
                    System.out.println(dateNow);
                case 13:
                    System.out.println("Close Project");
                    return;
                default:
                    System.out.println("Invalid input, choose again!!.");
            }
        }
    }

    private static Enrollment addnewEnrollment() {
        Set<Student> listStudent = SchoolDao.getListStudents();
        boolean isExistsStudent;
        listStudent.forEach(student -> {
            System.out.println("Id: " + student.getId() + ", StudentCode: " + student.getStudentCode() + ", StudentName: " + student.getFullName());
        });

        int choose;
        while (true) {
            try {
                choose = InputUtils.inputNumber("Choose Student: ");
                isExistsStudent = findStudentById(listStudent, choose);
                if (!isExistsStudent) {
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
            } catch (InvalidOrtherException e) {
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

    public static Boolean findStudentById(Set<Student> listStudent, int choose) {
        for (Student student : listStudent) {
            if (student.getId() == choose) {
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
                SchoolDao.checkExistsStudentByStudentCode(studentCode);
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
        for (int i = 0; i < listDepartment.size(); i++) {
            System.out.println(i + 1 + ". " + listDepartment.get(i).getDepartmentName());
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
                    Validator.stringNormal(trainingLocation);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            return new StudentTC(studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId, trainingLocation);
        }
        return new Student(studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
    }


}
