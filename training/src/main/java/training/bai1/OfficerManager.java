package training.bai1;

import java.util.List;

public interface OfficerManager {
    void addNewOfficer(Officer newOfficer);
    List<Officer> findOfficerByFullName(String fullName);
    void showAllOfficers();
}
