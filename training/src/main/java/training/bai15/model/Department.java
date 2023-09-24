package training.bai15.model;

import java.util.Comparator;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Student> studentList;
    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(String departmentName, List<Student> studentList) {
        this.departmentName = departmentName;
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    public Student findStudentWithHighestEntranceScore() {
        return studentList.stream()
                .max(Comparator.comparingDouble(Student::getEntranceScore))
                .orElse(null);
    }
}
