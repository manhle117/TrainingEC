package training.bai12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TrafficManager {
  private final List<Vehicle> vehicles;

  public TrafficManager() {
    vehicles = new ArrayList<>();
  }

  public boolean isIdExist(String id) {
    return vehicles
        .stream()
        .anyMatch(ver -> ver.getId().equals(id));
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public List<Vehicle> findByManufacturerOrColor(String keySearch) {
    return vehicles
        .stream()
        .filter(ver -> ver.getColor().equals(keySearch) || ver.getManufacturer().equals(keySearch))
        .collect(Collectors.toList());
  }

  public void showVehicle() {
    vehicles.forEach(System.out::println);
  }
}
