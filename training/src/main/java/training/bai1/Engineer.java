package training.bai1;

public class Engineer extends Officer{
    private String trainingIndustry;

    public Engineer(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    public Engineer(String fullName, int age, EnumSex sex, String address, String trainingIndustry) {
        super(fullName, age, sex, address);
        this.trainingIndustry = trainingIndustry;
    }

    public String getTrainingIndustry() {
        return trainingIndustry;
    }

    public void setTrainingIndustry(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                super.toString() + "," +
                "trainingIndustry='" + trainingIndustry + '\'' +
                '}';
    }
}
