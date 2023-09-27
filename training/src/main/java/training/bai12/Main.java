package training.bai12;



import training.common.InputUtils;

import java.util.List;


public class Main {
  private static final TrafficManager trafficManager = new TrafficManager();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new vehicle");
      System.out.println("2. display vehicles");
      System.out.println("3. find vehicle by color or manufacturer");
      System.out.println("4. stop");
      String choose = InputUtils.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          Vehicle newVehicle = inputVehicle();
          trafficManager.addVehicle(newVehicle);
          break;
        }

        case "2": {
          trafficManager.showVehicle();
          break;
        }

        case "3": {
          String keySearch = InputUtils.inputString("key search: ");
          List<Vehicle> resultFind = trafficManager.findByManufacturerOrColor(keySearch);
          if (resultFind.isEmpty()) {
            System.err.println("don't find vehicle by key: " + keySearch);
          } else {
            resultFind.forEach(System.out::println);
          }
          break;
        }

        case "4": {
          return;
        }

        default:
          break;
      }
    }
  }

  private static Vehicle inputVehicle() {
    Vehicle vehicle = null;
    String type = "";
    while (true) {
      type = InputUtils.inputString(">>> type(car, motor, truck): ");
      if ("car".equals(type) || "motor".equals(type) || "truck".equals(type)) {
        break;
      } else {
        System.err.println("input invalid, please enter again");
      }
    }
    String id = "";
    while (true) {
      id = InputUtils.inputString("id: ");
      if (trafficManager.isIdExist((id))) {
        System.err.println("already exists id, please enter again");
      } else {
        break;
      }
    }
    String manufacturer = InputUtils.inputString("manufacturer: ");
    int yearOfManufacturer = InputUtils.inputNumber("yearOfManufact: ");
    double price = InputUtils.inputDouble("price: ");
    String color = InputUtils.inputString("color: ");
    switch (type) {
      case "car":
        int numberOfSeats = InputUtils.inputNumber("numberOfSeats: ");
        String engineType = InputUtils.inputString("engineType: ");
        vehicle = new Car(id, manufacturer, yearOfManufacturer, price, color, numberOfSeats, engineType);
        break;

      case "motor":
        int wattage = InputUtils.inputNumber("wattage: ");
        vehicle = new Motorbike(id, manufacturer, yearOfManufacturer, price, color, wattage);
        break;

      case "truck":
        int payload = InputUtils.inputNumber("payload: ");
        vehicle = new Truck(id, manufacturer, yearOfManufacturer, price, color, payload);
        break;

      default:
        break;
    }
    return vehicle;
  }
}
