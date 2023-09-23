package training.bai15.model;

public class Enrollment {
    private int studentId;
    private String semesterName;
    private double averageScore;

    public Enrollment(int studentId, String semesterName, double averageScore) {
        this.studentId = studentId;
        this.semesterName = semesterName;
        this.averageScore = averageScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentId=" + studentId +
                ", semesterName='" + semesterName + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}
