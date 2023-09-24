package training.bai15.model;

import java.sql.Date;

public class Student {
    private int id;
    private String studentCode;
    private String fullName;
    private Date doB;
    private int yearOfAdmission;
    private double entranceScore;
    private int departmentId;

    public Student() {
    }

    public Student( String studentCode, String fullName, Date doB, int yearOfAdmission, double entranceScore, int departmentId) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.doB = doB;
        this.yearOfAdmission = yearOfAdmission;
        this.entranceScore = entranceScore;
        this.departmentId = departmentId;
    }

    public Student(int id, String studentCode, String fullName, Date doB, int yearOfAdmission, double entranceScore, int departmentId) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.doB = doB;
        this.yearOfAdmission = yearOfAdmission;
        this.entranceScore = entranceScore;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public double getEntranceScore() {
        return entranceScore;
    }

    public void setEntranceScore(double entranceScore) {
        this.entranceScore = entranceScore;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", doB=" + doB +
                ", yearOfAdmission='" + yearOfAdmission + '\'' +
                ", entranceScore=" + entranceScore +
                ", departmentId=" + departmentId +
                '}';
    }

}
