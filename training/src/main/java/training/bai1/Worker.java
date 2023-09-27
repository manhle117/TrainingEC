package training.bai1;

public class Worker extends  Officer {
    private EnumLevel level;


    public Worker(EnumLevel level) {
        this.level = level;
    }

    public Worker(String fullName, int age, EnumSex sex, String address, EnumLevel level) {
        super(fullName, age, sex, address);
        this.level = level;
    }

    public EnumLevel getLevel() {
        return level;
    }

    public void setLevel(EnumLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "level=" + level +
                "} " + super.toString();
    }
}
