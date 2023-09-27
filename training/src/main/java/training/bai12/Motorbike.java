package training.bai12;


public class Motorbike extends Vehicle {
  private int wattage;

  public Motorbike(String id, String manufacturer, int yearOfManufacturer, double price, String color, int wattage) {
    super(id, manufacturer, yearOfManufacturer, price, color);
    this.wattage = wattage;
  }

  public int getWattage() {
    return wattage;
  }

  public void setWattage(int wattage) {
    this.wattage = wattage;
  }

  @Override
  public String toString() {
    return "Motorbike{" +
        super.toString() + ", " +
        "wattage=" + wattage +
        '}';
  }
}
