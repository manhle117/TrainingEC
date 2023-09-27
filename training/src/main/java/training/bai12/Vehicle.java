package training.bai12;


public class Vehicle {
  private String id;
  private String manufacturer;
  private int yearOfManufacturer;
  private double price;
  private String color;

  public Vehicle(String id, String manufacturer, int yearOfManufacturer, double price, String color) {
    this.id = id;
    this.manufacturer = manufacturer;
    this.yearOfManufacturer = yearOfManufacturer;
    this.price = price;
    this.color = color;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public int getYearOfManufacturer() {
    return yearOfManufacturer;
  }

  public void setYearOfManufacturer(int yearOfManufacturer) {
    this.yearOfManufacturer = yearOfManufacturer;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id='" + id + '\'' +
        ", manufacturer='" + manufacturer + '\'' +
        ", yearOfManufacturer=" + yearOfManufacturer +
        ", price=" + price +
        ", color='" + color + '\'' +
        '}';
  }
}
