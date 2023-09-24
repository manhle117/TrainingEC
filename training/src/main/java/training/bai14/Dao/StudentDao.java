package training.bai14.Dao;

import training.bai14.model.GoodStudent;
import training.bai14.model.NormalStudent;
import training.bai14.model.Student;
import training.common.ConnectSingleton;
import training.common.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public void insertStudent(Student student) {
        String sql = "INSERT INTO student (fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
                "type,gpa,bestRewardName,englishScore,entryTestScore)" +
                " values (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = ConnectSingleton.getInstance("qlschool");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setDate(2, student.getDoB());
            preparedStatement.setInt(3, student.getSex());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getUniversityName());
            preparedStatement.setString(6, student.getGradeLevel());
            preparedStatement.setInt(7, student.getType());
            if (student instanceof GoodStudent) {
                GoodStudent goodStudent = (GoodStudent) student;
                preparedStatement.setDouble(8, goodStudent.getGpa());
                preparedStatement.setString(9, goodStudent.getBestRewardName());
                preparedStatement.setNull(10, Types.INTEGER);
                preparedStatement.setNull(11, Types.DOUBLE);
            }
            // if thì else
            if (student instanceof NormalStudent) {
                NormalStudent normalStudent = (NormalStudent) student;
                preparedStatement.setNull(8, Types.DOUBLE);
                preparedStatement.setNull(9, Types.VARCHAR);
                preparedStatement.setInt(10, normalStudent.getEnglishScore());
                preparedStatement.setDouble(11, normalStudent.getEntryTestScore());
            }
            preparedStatement.executeUpdate();
            System.out.println("Add student successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<GoodStudent> getListOfGoodStudent() {
        List<GoodStudent> goodStudentList = new ArrayList<>();
        String sql = "SELECT * FROM student where type = 0";
        GoodStudent goodStudent;
        try (Connection connection = ConnectSingleton.getInstance("qlhs");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                Date doB = rs.getDate("doB");
                int sex = rs.getInt("sex");
                String phoneNumber = rs.getString("phoneNumber");
                String universityName = rs.getString("universityName");
                String gradeLevel = rs.getString("gradeLevel");
                int type = rs.getInt("type");
                double gpa = rs.getDouble("gpa");
                String bestRewardName = rs.getString("bestRewardName");
                goodStudent = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, gpa, bestRewardName);
                goodStudentList.add(goodStudent);
                return goodStudentList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NormalStudent> getListOfNormalStudent() {
        List<NormalStudent> normalStudentList = new ArrayList<>();
        String sql = "SELECT * FROM student where type = 1";
        NormalStudent normalStudent;
        try (Connection conn = ConnectionUtils.getConnection("qlhs");
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();) {
            //(fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
            // "type,gpa,bestRewardName,englishScore,entryTestScore)

            while (rs.next()) {
                String fullName = rs.getString("fullName");
                Date doB = rs.getDate("doB");
                int sex = rs.getInt("sex");
                String phoneNumber = rs.getString("phoneNumber");
                String universityName = rs.getString("universityName");
                String gradeLevel = rs.getString("gradeLevel");
                int type = rs.getInt("type");
                int englishScore = rs.getInt("englishScore");
                double entryTestScore = rs.getDouble("entryTestScore");
                normalStudent = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, englishScore, entryTestScore);
                normalStudentList.add(normalStudent);
                return normalStudentList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student ";
        Student student;
        try (Connection conn = ConnectionUtils.getConnection("qlhs");
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                Date doB = rs.getDate("doB");
                int sex = rs.getInt("sex");
                String phoneNumber = rs.getString("phoneNumber");
                String universityName = rs.getString("universityName");
                String gradeLevel = rs.getString("gradeLevel");
                int type = rs.getInt("type");
                double gpa = rs.getDouble("gpa");
                String bestRewardName = rs.getString("bestRewardName");
                int englishScore = rs.getInt("englishScore");
                double entryTestScore = rs.getDouble("entryTestScore");
                if (type == 0) {
                    student = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, gpa, bestRewardName);
                    students.add(student);
                }
                // if else
                if (type == 1) {
                    student = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, englishScore, entryTestScore);
                    students.add(student);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


}
