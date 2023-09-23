package training.bai14.model;

import java.sql.Date;

public class NormalStudent extends Student{
    //điểm TOEIC (englishScore),
    // điểm thi đầu vào chuyên môn do công ty tổ chức thi (entryTestScore) theo thang điểm 10.
    private int englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, Date doB, int sex, String phoneNumber, String universityName, String gradeLevel, int type, int englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel, type);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return "NormalStudent{" +
                ", fullName='" + fullName + '\'' +
                ", doB=" + doB +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                "englishScore=" + englishScore +
                ", entryTestScore=" + entryTestScore +
                '}';
    }

    @Override
    public void ShowMyInfor() {
        System.out.println(toString());
    }
}
