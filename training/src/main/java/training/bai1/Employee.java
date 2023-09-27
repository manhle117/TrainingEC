package training.bai1;

public class Employee extends Officer {
    private String workName;

    public Employee(String workName) {
        this.workName = workName;
    }

    public Employee(String fullName, int age, EnumSex sex, String address, String workName) {
        super(fullName, age, sex, address);
        this.workName = workName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workName='" + workName + '\'' +
                "} " + super.toString();
    }
}
