package training.Exam.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class ManagementEmp extends Employee {
    int resolveIssueNumber;
    int otherTaskNumber;
    double allowance;

    public ManagementEmp(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int resolveIssueNumber, int otherTaskNumber, double allowance) {
        super(empId, account, role, doB, workStartingDate, productivityScore, monthlyIncome, rewardSalary);
        this.resolveIssueNumber = resolveIssueNumber;
        this.otherTaskNumber = otherTaskNumber;
        this.allowance = allowance;
    }

    public ManagementEmp(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int resolveIssueNumber, int otherTaskNumber) {
        super(empId, account, role, doB, workStartingDate, productivityScore, monthlyIncome, rewardSalary);
        this.resolveIssueNumber = resolveIssueNumber;
        this.otherTaskNumber = otherTaskNumber;
    }

    public int getResolveIssueNumber() {
        return resolveIssueNumber;
    }

    public void setResolveIssueNumber(int resolveIssueNumber) {
        this.resolveIssueNumber = resolveIssueNumber;
    }

    public int getOtherTaskNumber() {
        return otherTaskNumber;
    }

    public void setOtherTaskNumber(int otherTaskNumber) {
        this.otherTaskNumber = otherTaskNumber;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }


    public static double calMonthlyIncome(int resolveIssueNumber,int otherTaskNumber,double productivityScore) {
       double monthlyIncome = (resolveIssueNumber * 5000000) + (otherTaskNumber * 500000) + Employee.getRewardSalary(productivityScore) ;
        return monthlyIncome;
    }
     public static double calAllowance(Date workStartingDate,double productivityScore){
         LocalDate startingLocalDate = workStartingDate.toLocalDate();
         LocalDate currentDate = LocalDate.now();
         long monthsWorked = Period.between(startingLocalDate, currentDate).toTotalMonths();
         if (monthsWorked >= 36) {
             return 2500000 * productivityScore;
         } else if (monthsWorked >= 12 && monthsWorked < 36) {
             return 1800000 * productivityScore;
         } else if (monthsWorked < 12) {
             return 1200000 * productivityScore;
         } else {
             return 0; // Nếu không nằm trong các điều kiện trên
         }
     }

    @Override
    public String toString() {
        return "ManagementEmp{" +
                "resolveIssueNumber=" + resolveIssueNumber +
                ", otherTaskNumber=" + otherTaskNumber +
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
