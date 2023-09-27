package training.bai4;

import training.common.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private final List<Family> families;
    private final List<String> cmnds;

    public Town() {
        families = new ArrayList<>();
        cmnds = new ArrayList<>();
    }

    public void addFamily(int numOfFamily) {
        for (int i = 1; i <= numOfFamily; i++) {
            System.err.println("enter information family " + i);
            Family newFamily = inputFamily();
            families.add(newFamily);
        }
    }

    public void showInformationFamilies() {
        int length = families.size();
        for (int i = 0; i < length; i++) {
            System.err.println("Family " + (i + 1));
            System.out.println("address: " + families.get(i).getAddress());
            families
                    .get(i)
                    .getPersons()
                    .forEach(System.out::println);
        }
    }

    private Family inputFamily() {
        String address = InputUtils.inputString("address: ");
        int numOfPerson = InputUtils.inputNumber("numOfPerson: ");
        List<Person> persons = inputPersons(numOfPerson);
        return new Family(address, persons);
    }

    private List<Person> inputPersons(int numOfPerson) {
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= numOfPerson; i++) {
            System.out.println(">>> enter information person " + i);
            Person newPerson = inputPerson();
            persons.add(newPerson);
        }
        return persons;
    }

    private Person inputPerson() {
        String cmnd = "";
        while (true) {
            cmnd = InputUtils.inputString("cmnd: ");
            if (isCmndExist(cmnd)) {
                System.err.println("already exists, please enter again");
            } else {
                cmnds.add(cmnd);
                break;
            }
        }
        String name = InputUtils.inputString("name: ");
        int age = InputUtils.inputNumber("age: ");
        String jobName = InputUtils.inputString("jobName: ");
        return new Person(name, age,jobName,cmnd);
    }

    private boolean isCmndExist(String cmnd) {
        return cmnds
                .stream()
                .anyMatch(cm -> cm.equals(cmnd));
    }
}
