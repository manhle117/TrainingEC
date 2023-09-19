package bai13;

import bai13.model.Employee;
import bai13.model.Experience;
import bai13.model.Fresher;
import bai13.model.Intern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private final List<Employee> listEmployee;

    public EmployeeManagement(){
        this.listEmployee = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        listEmployee.add(employee);
    }
    public void showAllEmployees(){
        listEmployee.forEach(Employee::showInfor);
    }
    public Employee findEmployeeByEmployeeId(String employeeId){
        for (Employee employee : listEmployee) {
            if (employee.getEmployeeId().equals(employeeId)){
                return employee;
            }
        }
        return null;
    }
    public void updateEmployee(String employeeId, Employee updatedEmployee){
        int size = listEmployee.size();
        for (int i = 0; i < size; i++) {
            Employee employee = listEmployee.get(i);
            if (employee.getEmployeeId().equals(employeeId)) {
                updatedEmployee.setEmployeeId(employee.getEmployeeId());
                listEmployee.set(i, updatedEmployee);
                return;
            }
    }
}
    public  boolean deleteEmployee(String employeeId){
        Iterator<Employee> iterator = listEmployee.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee.getEmployeeId().equals(employeeId)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public List<Employee> getListIntern() {
        return listEmployee.stream().filter(Intern.class::isInstance).collect(Collectors.toList());
    }
    public List<Employee> getListFresher() {
        return listEmployee.stream().filter(Fresher.class::isInstance).collect(Collectors.toList());
    }
    public List<Employee> getListExperience() {
        return listEmployee.stream().filter(Experience.class::isInstance).collect(Collectors.toList());
    }
}
