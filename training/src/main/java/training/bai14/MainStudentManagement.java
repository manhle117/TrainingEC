package training.bai14;

import training.bai14.Dao.StudentDao;
import training.bai14.exception.InvalidDOBExceptionException;
import training.bai14.exception.InvalidFullNameException;
import training.bai14.exception.InvalidOrtherException;
import training.bai14.exception.InvalidPhoneNumberException;
import training.bai14.model.GoodStudent;
import training.bai14.model.NormalStudent;
import training.bai14.model.Student;
import training.common.InputUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MainStudentManagement {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        StudentDao studentDao = new StudentDao();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Chọn ứng viên trúng tuyển");
            System.out.println("3. Hiển thị thông tin tất cả sinh viên");
            System.out.println("4. Thoát");
            int choice = InputUtils.inputNumber("Chọn tùy chọn (1-4): ");

            switch (choice) {
                case 1:
                    //convert sang class Object
                    Student student = addNewStudent();
                    studentDao.insertStudent(student);
                    break;

                case 2:
                    int numCandidatesToHire = InputUtils.inputNumber("Number of student want to hire: ");
                    studentManagement.selectStudent(numCandidatesToHire);
                    break;

                case 3:
                    List<Student> studentList = studentManagement.showInforAllStudent();
                    studentList.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Bye.");
                    System.exit(0);

                default:
                    System.out.println("Invalid input, choose again!!.");
            }
        }
    }

    private static Student addNewStudent() {
        Student student = null;
        String fullName = "";
        while (true) {
            try {
                fullName = InputUtils.inputString("Input Full Name: ");
                Validator.fullName(fullName);
                break;
            } catch (InvalidFullNameException e) {
                System.err.println(e.getMessage());
                ;
            }
        }
        String doBInput = "";
        Date doB = null;
        while (true) {
            try {
                doBInput = InputUtils.inputString("Input Date of birth: ");
                doB = parseDate(doBInput);
                break;
            } catch (InvalidDOBExceptionException e) {
                System.err.println(e.getMessage());
            }
        }
        int sex;
        while (true) {
            try {
                sex = InputUtils.inputNumber("Input sex(0: male; 1: female; 2:Other): ");
                Validator.sex(sex);
                break;
            } catch (InvalidOrtherException e) {
                System.err.println(e.getMessage());
            }
        }
        String phoneNumber = "";
        while (true) {
            try {
                phoneNumber = InputUtils.inputString("Input phone number: ");
                Validator.phone(phoneNumber);
                break;
            } catch (InvalidPhoneNumberException e) {
                System.err.println(e.getMessage());
            }
        }
        String universityName = "";
        while (true) {
            try {
                universityName = InputUtils.inputString("Input university Name: ");
                Validator.stringNormal(universityName);
                break;
            } catch (InvalidOrtherException e) {
                System.err.println(e.getMessage());
            }
        }
        String gradeLevel = "";
        while (true) {
            try {
                gradeLevel = InputUtils.inputString("Input grade Level: ");
                Validator.stringNormal(gradeLevel);
                break;
            } catch (InvalidOrtherException e) {
                System.err.println(e.getMessage());
            }
        }

        int type;
        while (true) {
            type = InputUtils.inputNumber("Choice Type employee (0: GoodStudent, 1: NormalStudent): ");
            if (type < 0 || type > 1) {
                System.err.println("Not valid, must be between 0 and 1.");
            } else {
                break;
            }
        }
        if (type == 0) {
            double gpa;
            while (true) {
                try {
                    gpa = InputUtils.inputDouble("Input gpa: ");
                    Validator.checkDouble(gpa);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }

            String bestRewardName = InputUtils.inputString("Input bestRewardName");
            student = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, gpa, bestRewardName);

        } else if (type == 1) {
            int englishScore = InputUtils.inputNumber("Input englishScore: ");
            double entryTestScore;
            while (true) {
                try {
                    entryTestScore = InputUtils.inputDouble("Input entryTestScore: ");
                    Validator.checkDouble(entryTestScore);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            student = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, englishScore, entryTestScore);
        }
        return student;
    }

    private static Date parseDate(String dateInput) throws InvalidDOBExceptionException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            java.util.Date date = dateFormat.parse(dateInput);
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new InvalidDOBExceptionException("Invalid date input(dd/MM/yyyy ), please try again!");
        }
    }
}



