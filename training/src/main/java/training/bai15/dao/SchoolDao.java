package training.bai15.dao;

import training.bai15.exception.InvalidOrtherException;
import training.bai15.model.*;
import training.common.ConnectSingleton;
import training.common.ConnectionUtils;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class SchoolDao {
    public static List<Department> getListDepartments() {
        String sql = "SELECT * FROM Department";
        Department department = null;
        List<Department> departmentList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
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
        return departmentList;
    }

    public static void insertStudent(Student student) {

        String sql = "INSERT INTO Student(studentCode, fullName, dateOfBirth, yearOfAdmission, entranceScore, departmentId,trainingLocation ) VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
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

    public static Set<Student> getListStudents() {
        String sql = "SELECT * FROM Student";
        Student student = null;

        Set<Student> studentList = new HashSet<>();
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
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
                if (studentCode.substring(0, 2).equalsIgnoreCase("TC")) {
                    student = new StudentTC(id, studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId, trainingLocation);
                    studentList.add(student);
                } else {
                    student = new Student(id, studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
                    studentList.add(student);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;

    }


    public static long getNumberOfStudentCQ() {
        Set<Student> students = SchoolDao.getListStudents();
        long count = students
                .stream()
                .filter(student -> student.getStudentCode().substring(0, 2)
                        .equalsIgnoreCase("CQ"))
                .count();
        return count;
    }

    public static void checkExistsStudentByStudentCode(String studentCode) throws InvalidOrtherException {
        Set<Student> students = SchoolDao.getListStudents();
        boolean found = students.stream().anyMatch(s -> s.getStudentCode().equals(studentCode));
        if (found) {
            throw new InvalidOrtherException("Duplicate student Code, Please input again");
        }

    }

    public static int getCountStudentCQByDepartment(int departmentId) {
        String sql = "SELECT count(1) as count FROM department as d " +
                "join student as s " +
                "on d.departmentId = s.departmentId " +
                "where s.departmentId = ? and substring(s.studentcode,1,2) like \"CQ\"";
        int count = 0;
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, departmentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void insertEnrollment(Enrollment enrollment) {
        String sql = "INSERT INTO enrollment (studentId, semesterName, averageScore) VALUES (?,?,?)";
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, enrollment.getStudentId());
            preparedStatement.setString(2, enrollment.getSemesterName());
            preparedStatement.setDouble(3, enrollment.getAverageScore());
            preparedStatement.executeUpdate();
            System.out.println("Add Enrollment successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudentHasMaxEntryScoreInDepartment() {
        List<Student> listStudent = new ArrayList<>();
        String sql = "SELECT s.departmentId, s.studentCode, s.fullName, s.entranceScore " +
                "FROM Student s " +
                "INNER JOIN " +
                "    (SELECT departmentId, MAX(entranceScore) AS maxEntranceScore " +
                "    FROM Student " +
                "    GROUP BY departmentId) maxScores ON s.departmentId = maxScores.departmentId AND s.entranceScore = maxScores.maxEntranceScore;";
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();) {
            Student student;
            while (rs.next()) {
                int departId = rs.getInt("departmentId");
                String studentCode = rs.getString("studentCode");
                String fullName = rs.getString("fullName");
                double entryCode = rs.getDouble("entranceScore");
                student = new Student(studentCode, fullName, entryCode, departId);
                listStudent.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }

    public static List<StudentDao> getStudentListBySemesterName(String semesterName) {
        String sql = "SELECT s.studentCode,s.fullName,e.averageScore FROM enrollment  as e " +
                "join student as s on e.studentId = s.Id where e.semesterName like ?";
        List<StudentDao> listStudent = new ArrayList<>();
        StudentDao dao;

        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, semesterName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String studentCode = rs.getString("studentCode");
                String fullName = rs.getString("fullName");
                double averageScore = rs.getDouble("averageScore");
                dao = new StudentDao(studentCode, fullName, averageScore);
                listStudent.add(dao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }

    public static List<StudentTC> getStudentListByTrainingLocation(String trainingLocation) {
        String sql = "SELECT s.*\n" +
                "FROM Student s\n" +
                "INNER JOIN Department d ON s.departmentId = d.departmentId\n" +
                "WHERE s.trainingLocation like ?;";
        List<StudentTC> students = new ArrayList<StudentTC>();
        StudentTC studentTC;
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, trainingLocation);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String studentCode = rs.getString("studentCode");
                String fullName = rs.getString("fullName");
                Date doB = rs.getDate("dateOfBirth");
                int yearOfAdmission = rs.getInt("yearOfAdmission");
                double entranceScore = rs.getDouble("entranceScore");
                int departmentId = rs.getInt("departmentId");
                String location = rs.getString("trainingLocation");
                studentTC = new StudentTC(studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId, location);
                students.add(studentTC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<DepartmentDao> listStudentHasAverageHigherThan8() {
        String sql = "SELECT d.departmentName,s.studentCode, s.fullName, e.averageScore\n" +
                "FROM Student s\n" +
                "INNER JOIN (\n" +
                "    SELECT studentId, MAX(semesterName) AS latestSemester\n" +
                "    FROM enrollment\n" +
                "    GROUP BY studentId\n" +
                ") latest ON s.Id = latest.studentId inner join department d on d.departmentId = s.departmentId\n" +
                "INNER JOIN enrollment as e ON s.Id = e.studentId AND latest.latestSemester = e.semesterName\n" +
                "WHERE e.averageScore >= 8.0;";
        List<DepartmentDao> listStudent = new ArrayList<>();
        DepartmentDao departmentDao;
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
        ) {
            while (rs.next()) {
                String depName = rs.getString("departmentName");
                String studentCode = rs.getString("studentCode");
                String fullName = rs.getString("fullName");
                double averageScore = rs.getDouble("averageScore");
                departmentDao = new DepartmentDao(depName, studentCode, fullName, averageScore);
                listStudent.add(departmentDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }

    public static List<StudentDao> getStudentHasAverageScoreHighestInDep() {
        String sql = "select max(e.averageScore) as maxAve,s.fullName,s.studentCode,d.departmentName from student s \n" +
                "join department d on s.departmentId = d.departmentId \n" +
                "join enrollment e on s.Id = e.studentId\n" +
                "group by d.departmentName,s.fullName,s.studentCode";
        List<StudentDao> students = new ArrayList<>();
        StudentDao dao;
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
        ) {
            while (rs.next()) {
                double maxAve = rs.getDouble("maxAve");
                String fullName = rs.getString("fullName");
                String studentCode = rs.getString("studentCode");
                String depName = rs.getString("departmentName");
                dao = new StudentDao(depName, fullName, studentCode, maxAve);
                students.add(dao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Map<Integer,Integer> getNumberOfStudentByYear() {
        String sql = "select count(studentCode) as numOfStu,yearOfAdmission from student \n" +
                "group by yearOfAdmission";
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        try (Connection connection = ConnectionUtils.getConnection("universitymanagement");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
        ) {
            while (rs.next()) {
                map.put(rs.getInt("yearOfAdmission"),rs.getInt("numOfStu"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
