package training.Exam.model;

import java.sql.Date;

public abstract class Employee {
    protected String empId;
    protected String account;
    protected int role; //1: Management, 2: Leader, 3: Dev
    protected Date doB;
    protected Date workStartingDate;
    protected double productivityScore; // (0.8 - 1.2)
    protected double monthlyIncome;
    protected double rewardSalary;

    public Employee(String empId, String account, int role, Date doB, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary) {
        this.empId = empId;
        this.account = account;
        this.role = role;
        this.doB = doB;
        this.workStartingDate = workStartingDate;
        this.productivityScore = productivityScore;
        this.monthlyIncome = monthlyIncome;
        this.rewardSalary = rewardSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public Date getWorkStartingDate() {
        return workStartingDate;
    }

    public void setWorkStartingDate(Date workStartingDate) {
        this.workStartingDate = workStartingDate;
    }

    public double getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(double productivityScore) {
        this.productivityScore = productivityScore;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setRewardSalary(double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public double getRewardSalary() {
        return rewardSalary;
    }

    public static double getRewardSalary(double productivityScore ){
        double rewardSalary;
      return  rewardSalary = productivityScore * 1500000;
    }

}
