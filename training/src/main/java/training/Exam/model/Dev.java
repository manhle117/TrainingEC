package training.Exam.model;

import java.sql.Date;

public class Dev extends Employee{
    private int DoneTaskNumber;

    public Dev(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int doneTaskNumber) {
        super(empId, account, role, doB, workStartingDate, productivityScore, monthlyIncome, rewardSalary);
        DoneTaskNumber = doneTaskNumber;
    }

    public int getDoneTaskNumber() {
        return DoneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        DoneTaskNumber = doneTaskNumber;
    }

    public static double calMonthlyIncome(int doneTaskNumber,double productivityScore) {
        return (doneTaskNumber * 1500000) + Employee.getRewardSalary(productivityScore);
    }

    @Override
    public String toString() {
        return "Dev{" +
                ", empId='" + empId + '\'' +
                ", account='" + account + '\'' +
                ", role=" + role +
                ", doB=" + doB +
                ", workStartingDate=" + workStartingDate +
                ", productivityScore=" + productivityScore +
                ", monthlyIncome=" + monthlyIncome +
                ", rewardSalary=" + rewardSalary +
                "DoneTaskNumber=" + DoneTaskNumber +
                "} " + super.toString();
    }
}
