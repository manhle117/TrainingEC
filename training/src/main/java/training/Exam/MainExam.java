package training.Exam;

import training.Exam.dao.ManaDao;
import training.Exam.exception.InvalidDOBExceptionException;
import training.Exam.exception.InvalidOrtherException;
import training.Exam.model.*;
import training.bai15.dao.SchoolDao;
import training.bai15.model.Enrollment;
import training.bai15.model.Student;
import training.common.InputUtils;

import java.sql.Date;

public class MainExam {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add New Employee");
            System.out.println("2. Cal RewardSalary, Income of Employee");
            int choice = InputUtils.inputNumber("Choose (1-12): ");
            switch (choice) {
                case 1:
                    Employee employee = addNewEmployee();
                    ManaDao.insertEmployee(employee);
                    break;

                case 2:
                    String empId ;
                    while (true) {
                        try {
                            empId = InputUtils.inputString("Input empId: ");
                            Validator.empIdCheck(empId);
                            break;
                        } catch (InvalidOrtherException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    IncomeDao incomeDao = ManaDao.getIncomeAndRewardSalary(empId);
                    if(incomeDao == null){
                        System.out.println("Not found Employee!!!");
                    }else{
                        System.out.println(incomeDao.getEmpId()+ ", Income: "+ incomeDao.getIncome()+ ", Reward: "+ incomeDao.getRewardSalary());

                    }
                    break;
                default:
                    System.out.println("Invalid input, choose again!!.");
            }
        }
    }

    private static Employee addNewEmployee() {
        Employee employee = null;

        String employeeId = "";
        String account = "";
        int role;
        Date doB;
        Date workStartingDate;
        double productivityScore;
        int reviewTaskNumber;
        int supportTaskNumber;
        int DoneTaskNumber;
        int resolveIssueNumber;
        int otherTaskNumber;
        while (true) {
            try {
                employeeId = InputUtils.inputString("Input empId: ");
                Validator.empIdCheck(employeeId);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        account = InputUtils.inputString("Input Account: ");
        String dateOBInput;
        while (true) {
            try {
                dateOBInput = InputUtils.inputString("Input doB (dd/MM/yyyy): ");
                doB = Validator.checkDateStart(dateOBInput);
                break;
            } catch (InvalidDOBExceptionException e) {
                System.out.println(e.getMessage());
            }
        }
        String workStartingDateInput;
        while (true) {
            try {
                workStartingDateInput = InputUtils.inputString("Input doB (dd/MM/yyyy): ");
                workStartingDate = Validator.checkDateStart(workStartingDateInput);
                break;
            } catch (InvalidDOBExceptionException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                productivityScore = InputUtils.inputDouble("Input productivityScore (0.8 - 1.2): ");
                Validator.checkProductivityScore(productivityScore);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                role = InputUtils.inputNumber("Input role (1: Management, 2: Leader, 3: Dev): ");
                Validator.checkRoleValid(role);
                break;
            } catch (InvalidOrtherException e) {
                System.out.println(e.getMessage());
            }
        }
        if (role == 1) {
            while (true) {
                try {
                    resolveIssueNumber = InputUtils.inputNumber("Input resolveIssueNumber( greater than 0): ");
                    Validator.checkIntGreaterThan0(resolveIssueNumber);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    otherTaskNumber = InputUtils.inputNumber("Input otherTaskNumber( greater than 0): ");
                    Validator.checkIntGreaterThan0(otherTaskNumber);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            double incomeManager = ManagementEmp.calMonthlyIncome(otherTaskNumber, resolveIssueNumber, productivityScore);
            double rewardManager = Employee.getRewardSalary(productivityScore);
            employee = new ManagementEmp(employeeId, account, role, doB, workStartingDate, productivityScore, incomeManager, rewardManager, resolveIssueNumber, otherTaskNumber);
        } else if (role == 2) {
            while (true) {
                try {
                    reviewTaskNumber = InputUtils.inputNumber("Input reviewTaskNumber: ");
                    Validator.checkIntGreaterThan0(reviewTaskNumber);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    supportTaskNumber = InputUtils.inputNumber("Input supportTaskNumber: ");
                    Validator.checkIntGreaterThan0(supportTaskNumber);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            double incomeLead = Leader.calMonthlyIncome(reviewTaskNumber, supportTaskNumber, productivityScore);
            double rewardLead = Leader.getRewardSalary(productivityScore);
            employee = new Leader(employeeId, account, role, doB, workStartingDate, productivityScore, incomeLead, rewardLead, reviewTaskNumber, supportTaskNumber);

        } else {
            while (true) {
                try {
                    DoneTaskNumber = InputUtils.inputNumber("Input DoneTaskNumber: ");
                    Validator.checkIntGreaterThan0(DoneTaskNumber);
                    break;
                } catch (InvalidOrtherException e) {
                    System.out.println(e.getMessage());
                }
            }
            double incomeDev = Dev.calMonthlyIncome(DoneTaskNumber, productivityScore);
            double rewardDev = Dev.getRewardSalary(productivityScore);
            employee = new Dev(employeeId, account, role, doB, workStartingDate, productivityScore, incomeDev, rewardDev, DoneTaskNumber);
        }

        return employee;
    }
}
