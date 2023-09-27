package training.bai1;

public class Officer {
    private String fullName;
    private int age;
    private EnumSex sex;
    private String address;

    public Officer() {}

    public Officer(String fullName, int age, EnumSex sex, String address) {
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EnumSex getSex() {
        return sex;
    }

    public void setSex(EnumSex sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
