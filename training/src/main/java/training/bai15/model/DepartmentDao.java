package training.bai15.model;

public class DepartmentDao {
    private String departmentName;
    private String studentCode;
    private String fullName;
    private double averageScore;

    public DepartmentDao(String departmentName, String studentCode, String fullName, double averageScore) {
        this.departmentName = departmentName;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.averageScore = averageScore;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "DepartmentDao{" +
                "departmentName='" + departmentName + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}
