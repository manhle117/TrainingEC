package training.bai4;

import training.common.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is sudo code. To overview how to do it.
// You can finish by fill you code

public class MainBai4 {
    private static final Town town = new Town();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n\n\n=== menu ===");
            System.out.println("1. add family");
            System.out.println("2. display information family");
            System.out.println("5. stop");
            String choose = InputUtils.inputString("Input your choose: ");

            switch (choose) {
                case "1": {
                    int numOfFamilies = InputUtils.inputNumber("numOfFamilies: ");
                    town.addFamily(numOfFamilies);
                    break;
                }

                case "2": {
                    town.showInformationFamilies();
                    break;
                }

                case "3": {
                    return;
                }

                default:
                    break;
            }
        }
    }
}
