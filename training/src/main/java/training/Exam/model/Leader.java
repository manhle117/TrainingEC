package training.Exam.model;

import java.sql.Date;

public class Leader extends Employee{
    private int reviewTaskNumber;
    private int supportTaskNumber;
    private double allowance;

    public Leader(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int reviewTaskNumber, int supportTaskNumber, double allowance) {
        super(empId, account, role, doB, workStartingDate, productivityScore, monthlyIncome, rewardSalary);
        this.reviewTaskNumber = reviewTaskNumber;
        this.supportTaskNumber = supportTaskNumber;
        this.allowance = allowance;
    }

    public Leader(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int reviewTaskNumber, int supportTaskNumber) {
        super(empId, account, role, doB, workStartingDate, productivityScore, monthlyIncome, rewardSalary);
        this.reviewTaskNumber = reviewTaskNumber;
        this.supportTaskNumber = supportTaskNumber;
    }

    public int getReviewTaskNumber() {
        return reviewTaskNumber;
    }

    public void setReviewTaskNumber(int reviewTaskNumber) {
        this.reviewTaskNumber = reviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return supportTaskNumber;
    }

    public void setSupportTaskNumber(int supportTaskNumber) {
        this.supportTaskNumber = supportTaskNumber;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }


    public static double calMonthlyIncome(int reviewTaskNumber, int supportTaskNumber, double productivityScore) {
      double  monthlyIncome = (reviewTaskNumber * 4000000) + (supportTaskNumber * 400.000) + Employee.getRewardSalary(productivityScore) ;
        return monthlyIncome;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "reviewTaskNumber=" + reviewTaskNumber +
                ", supportTaskNumber=" + supportTaskNumber +
                ", allowance=" + allowance +
                ", empId='" + empId + '\'' +
                ", account='" + account + '\'' +
                ", role=" + role +
                ", doB=" + doB +
                ", workStartingDate=" + workStartingDate +
                ", productivityScore=" + productivityScore +
                ", monthlyIncome=" + monthlyIncome +
                ", rewardSalary=" + rewardSalary +
                "} " + super.toString();
    }
}
