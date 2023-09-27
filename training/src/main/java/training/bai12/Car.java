package training.bai12;

public class Car extends Vehicle {
  private int numberOfSeats;
  private String engineType;

  public Car(String id, String manufacturer, int yearOfManufacturer, double price, String color, int numberOfSeats, String engineType) {
    super(id, manufacturer, yearOfManufacturer, price, color);
    this.numberOfSeats = numberOfSeats;
    this.engineType = engineType;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  @Override
  public String toString() {
    return "Car{" +
        super.toString() + ", " +
        "numberOfSeats=" + numberOfSeats +
        ", engineType='" + engineType + '\'' +
        '}';
  }
}
