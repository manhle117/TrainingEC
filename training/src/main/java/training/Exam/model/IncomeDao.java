package training.Exam.model;

public class IncomeDao {
    private double income;
    private double RewardSalary;
    private String empId;

    public IncomeDao(double income, double rewardSalary, String empId) {
        this.income = income;
        RewardSalary = rewardSalary;
        this.empId = empId;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getRewardSalary() {
        return RewardSalary;
    }

    public void setRewardSalary(double rewardSalary) {
        RewardSalary = rewardSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "IncomeDao{" +
                "income=" + income +
                ", RewardSalary=" + RewardSalary +
                ", empId='" + empId + '\'' +
                '}';
    }
}
