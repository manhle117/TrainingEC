package training.bai4;

import java.util.List;

public class Family {
    private List<Person> persons;
    private String address;



    public Family(String address, List<Person> persons) {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Family{" +
                "persons=" + persons +
                ", address='" + address + '\'' +
                '}';
    }
}
