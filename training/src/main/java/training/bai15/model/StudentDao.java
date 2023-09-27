package training.bai15.model;

public class StudentDao {
    private String departName;
    private String fullName;
    private String studentCode;
    private double averageScore;

    public StudentDao(String departName, String fullName, String studentCode, double averageScore) {
        this.departName = departName;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.averageScore = averageScore;
    }

    public StudentDao(String fullName, String studentCode, double averageScore) {
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.averageScore = averageScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "fullName='" + fullName + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
