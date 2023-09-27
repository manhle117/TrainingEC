package training.bai1;

import training.common.InputUtils;

import java.util.List;

public class MainBai1 {

    public static void main(String[] args) {
        OfficerManagement management = new OfficerManagement();

        while (true) {
            System.out.println("\n\n\n=== menu ===");
            System.out.println("1. add new officer");
            System.out.println("2. find officer by full name");
            System.out.println("3. show list officers");
            System.out.println("4. stop");
            String choose = InputUtils.inputString("Input choose: ");

            switch (choose) {
                case "1": {
                    Officer newOfficer = inputOfficer();
                    management.addNewOfficer(newOfficer);
                    break;
                }

                case "2": {
                    String fullName = InputUtils.inputString("Input fullName: ");
                    List<Officer> resultFind = management.findOfficerByFullName(fullName);
                    resultFind.forEach(System.out::println);
                    break;
                }

                case "3": {
                    management.showAllOfficers();
                    break;
                }

                case "4": {
                    System.out.println("Bye");
                    return;
                }

                default:
                    break;
            }
        }
    }

    private static Officer inputOfficer() {
        String type = "";
        while (true) {
            type = InputUtils.inputString("Input type officer (worker, engineer, employee): ");
            if ("worker".equals(type) || "employee".equals(type) || "engineer".equals(type)) {
                break;
            } else {
                System.err.println("type invalid, please input again !!!");
            }
        }

        String fullName = InputUtils.inputString("full name: ");
        int age = InputUtils.inputNumber("age: ");
        EnumSex sex = null;

        while (true) {
            try {
                sex = EnumSex.valueOf(InputUtils.inputString("sex (MALE, FEMALE, OTHER): "));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("sex invalid, please input again input again");
            }
        }

        String address = InputUtils.inputString("address: ");

        switch (type) {
            case "worker":
                EnumLevel level = null;
                while (true) {
                    try {
                        level = EnumLevel.valueOf(
                                InputUtils.inputString("level (ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN): ")
                        );
                        break;
                    } catch (IllegalArgumentException e) {
                        System.err.println("level invalid, please input again input again");
                    }
                }
                return new Worker(fullName, age, sex, address, level);

            case "engineer":
                String trainingIndustry = InputUtils.inputString("trainingIndustry: ");
                return new Engineer(fullName, age, sex, address, trainingIndustry);

            case "employee":
                String workName = InputUtils.inputString("workName: ");
                return new Employee(fullName, age, sex, address, workName);

            default:
                break;
        }
        return null;
    }
}

