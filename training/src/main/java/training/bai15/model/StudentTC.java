package training.bai15.model;

import java.sql.Date;

public class StudentTC extends  Student{
    private String trainingLocation;

    public StudentTC() {
    }


    public StudentTC( String studentCode, String fullName, Date doB, int yearOfAdmission, double entranceScore, int departmentId, String trainingLocation) {
        super( studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
        this.trainingLocation = trainingLocation;
    }

    public StudentTC(int id, String studentCode, String fullName, Date doB, int yearOfAdmission, double entranceScore, int departmentId, String trainingLocation) {
        super(id, studentCode, fullName, doB, yearOfAdmission, entranceScore, departmentId);
        this.trainingLocation = trainingLocation;
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }

    @Override
    public String toString() {
        return "StudentTC{" +
                 super.toString() +
                "trainingLocation='" + trainingLocation + '\'' +
                "} " ;
    }
}
