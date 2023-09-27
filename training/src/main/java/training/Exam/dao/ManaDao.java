package training.Exam.dao;


import training.Exam.model.*;
import training.bai15.model.Department;
import training.common.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManaDao {
    public static void insertEmployee(Employee employee) {

        String sql = "INSERT INTO `employee` (`empId`, `Account`, `role`, `doB`, `workStartingDate`, `productivityScore`," +
                " `monthlyIncome`, `rewardSalary`, `ResolveIssueNumber`, `OtherTaskNumber`, `AllowanceMana`, `ReviewTaskNumber`," +
                " `SupportTaskNumber`, `AllowanceLeader`, `DoneTaskNumber`)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try (Connection connection = ConnectionUtils.getConnection("incomemanager");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getAccount());
            preparedStatement.setInt(3, employee.getRole());
            preparedStatement.setDate(4, employee.getDoB());
            preparedStatement.setDate(5, employee.getWorkStartingDate());
            preparedStatement.setDouble(6, employee.getProductivityScore());
            preparedStatement.setDouble(7, employee.getMonthlyIncome());
            preparedStatement.setDouble(8, employee.getRewardSalary());
            if (employee.getRole() == 1) {
                ManagementEmp managementEmp = (ManagementEmp) employee;
                preparedStatement.setInt(9, managementEmp.getResolveIssueNumber());
                preparedStatement.setInt(10, managementEmp.getOtherTaskNumber());
                preparedStatement.setNull(11, Types.DOUBLE);
                preparedStatement.setNull(12, Types.INTEGER);
                preparedStatement.setNull(13, Types.INTEGER);
                preparedStatement.setNull(14, Types.DOUBLE);
                preparedStatement.setNull(15, Types.INTEGER);
            } else if (employee.getRole() == 2) {
                Leader leader = (Leader) employee;
                preparedStatement.setNull(9, Types.INTEGER);
                preparedStatement.setNull(10, Types.INTEGER);
                preparedStatement.setNull(11, Types.DOUBLE);
                preparedStatement.setInt(12, leader.getReviewTaskNumber());
                preparedStatement.setInt(13, leader.getSupportTaskNumber());
                preparedStatement.setNull(14, Types.DOUBLE);
                preparedStatement.setNull(15, Types.INTEGER);
            } else {
                Dev dev = (Dev) employee;
                preparedStatement.setNull(9, Types.INTEGER);
                preparedStatement.setNull(10, Types.INTEGER);
                preparedStatement.setNull(11, Types.DOUBLE);
                preparedStatement.setNull(12, Types.INTEGER);
                preparedStatement.setNull(13, Types.INTEGER);
                preparedStatement.setNull(14, Types.DOUBLE);
                preparedStatement.setInt(15, dev.getDoneTaskNumber());
            }
            preparedStatement.executeUpdate();
            System.out.println("Add Empl successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static IncomeDao getIncomeAndRewardSalary(String id) {
        String sql = "SELECT empId,monthlyIncome,rewardSalary FROM employee where empId like ?;";
        IncomeDao incomeDao = null;
        try (Connection connection = ConnectionUtils.getConnection("incomemanager");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String empId = rs.getString("empId");
                double income = rs.getDouble("monthlyIncome");
                double rewardSalary = rs.getDouble("rewardSalary");
                incomeDao = new IncomeDao(income, rewardSalary,empId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  incomeDao;
    }


}
