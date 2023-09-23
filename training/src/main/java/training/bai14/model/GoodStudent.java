package training.bai14.model;

import java.sql.Date;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;


    public GoodStudent(String fullName, Date doB, int sex, String phoneNumber, String universityName, String gradeLevel, int type, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                ", fullName='" + fullName + '\'' +
                ", doB=" + doB +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                "gpa=" + gpa +
                ", bestRewardName='" + bestRewardName + '\'' +
                '}';
    }

    @Override
    public void ShowMyInfor() {
        System.out.println(toString());
    }
}
