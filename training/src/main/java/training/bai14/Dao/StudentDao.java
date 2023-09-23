package training.bai14.Dao;

import com.mysql.cj.xdevapi.Type;
import training.bai14.model.GoodStudent;
import training.bai14.model.NormalStudent;
import training.bai14.model.Student;
import training.common.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    // chuyển thành cục bộ
    List<NormalStudent> normalStudentList = new ArrayList<>();
    List<GoodStudent> goodStudentList = new ArrayList<>();

    public void insertStudent(Student student) {
        try {
            //gộp 2 dòng tiếp theo
            Connection conn = null;
            conn = ConnectionUtils.getConnection("qlhs");
            String sql = "INSERT INTO student (fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
                    "type,gpa,bestRewardName,englishScore,entryTestScore)" +
                    " values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
        } finally {
            //thiếu tham số
            ConnectionUtils.closeConnection();
        }
    }

    public List<GoodStudent> getListOfGoodStudent() {
        // tạo đối tươn goodStudent
        Student student;
        try {
            //(fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
            // "type,gpa,bestRewardName,englishScore,entryTestScore)
            Connection conn = ConnectionUtils.getConnection("qlhs");
            String sql = "SELECT * FROM student where type = 0";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
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
                student = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, gpa, bestRewardName);
                goodStudentList.add((GoodStudent) student);
                return goodStudentList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //truyền tham số
            ConnectionUtils.closeConnection();
        }
        return null;
    }

    public List<NormalStudent> getListOfNormalStudent() {

        Student student;
        try {
            //(fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
            // "type,gpa,bestRewardName,englishScore,entryTestScore)
            Connection conn = ConnectionUtils.getConnection("qlhs");
            String sql = "SELECT * FROM student where type = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
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
                student = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type, englishScore, entryTestScore);
                normalStudentList.add((NormalStudent) student);
                return normalStudentList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.closeConnection();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        Student student;
        try {
            //(fullName,doB,sex,phoneNumber,universityName,gradeLevel," +
            // "type,gpa,bestRewardName,englishScore,entryTestScore)
            Connection conn = ConnectionUtils.getConnection("qlhs");
            String sql = "SELECT * FROM student ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
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
        } finally {
            //
            ConnectionUtils.closeConnection();
        }
        return students;
    }

    public static void updateTest() {
        try {
            Connection conn = ConnectionUtils.getConnection("qlhs");
            String sql = "select * from student WHERE (id = '1')";

            PreparedStatement preparedStatement =
                    conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = preparedStatement.executeQuery();
            rs.updateString("fullName","Hieu");
            rs.updateRow();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
