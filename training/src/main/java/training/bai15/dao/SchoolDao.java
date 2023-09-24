package training.bai15.dao;

import training.bai15.model.Department;
import training.bai15.model.Student;
import training.bai15.model.StudentTC;
import training.common.ConnectSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolDao {
    public static List<Department> getListDepartments() {
        String sql = "SELECT * FROM Department";
        Department department = null;
        List<Department> departmentList = new ArrayList<>();
        try (Connection connection = ConnectSingleton.getInstance("qlschool");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
        ) {
            while (rs.next()) {
                int departmentId = rs.getInt("departmentId");
                String departmentName = rs.getString("departmentName");
                department = new Department(departmentName);
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertStudent(Student student) {

        String sql = "INSERT INTO Student(studentCode, fullName, dateOfBirth, yearOfAdmission, entranceScore, departmentId,trainingLocation ) VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = ConnectSingleton.getInstance("qlschool");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, student.getStudentCode());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setDate(3, student.getDoB());
            preparedStatement.setInt(4, student.getYearOfAdmission());
            preparedStatement.setDouble(5, student.getEntranceScore());
            preparedStatement.setInt(6, student.getDepartmentId());
            if (student instanceof StudentTC) {
                StudentTC studentTC = (StudentTC) student;
                preparedStatement.setString(7, studentTC.getTrainingLocation());
            } else {
                preparedStatement.setNull(7, Types.VARCHAR);
            }
            preparedStatement.executeUpdate();
            System.out.println("Add Student successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getListStudents() {
        String sql = "SELECT * FROM Student";
        Student student = null;

        List<Student> studentList = new ArrayList<>();
        try (Connection connection = ConnectSingleton.getInstance("qlschool");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String studentCode = rs.getString("studentCode");
                String fullName = rs.getString("fullName");
                Date doB = rs.getDate("dateOfBirth");
                int yearOfAdmission = rs.getInt("yearOfAdmission");
                double entranceScore = rs.getDouble("entranceScore");
                int departmentId = rs.getInt("departmentId");
                String trainingLocation = rs.getString("trainingLocation");
                if (trainingLocation != null) {
                    student = new StudentTC(id, studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId, trainingLocation);
                    studentList.add(student);
                }
                student = new Student(id, studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;

    }

    public static long getNumberOfStudentCQ() {
        List<Student> students = SchoolDao.getListStudents();
        long count = students
                .stream()
                .filter(student -> student.getStudentCode().substring(0,2)
                        .equalsIgnoreCase("CQ"))
                .count();
        return count;
    }


}
