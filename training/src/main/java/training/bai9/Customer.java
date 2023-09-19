package training.bai9;

public class Customer {
	 private String fullName;
	  private String address;
	  private int electricityMeterId;

	  public Customer(String fullName, String address, int electricityMeterId) {
	    this.fullName = fullName;
	    this.address = address;
	    this.electricityMeterId = electricityMeterId;
	  }

	  public String getFullName() {
	    return fullName;
	  }

	  public void setFullName(String fullName) {
	    this.fullName = fullName;
	  }

	  public String getAddress() {
	    return address;
	  }

	  public void setAddress(String address) {
	    this.address = address;
	  }

	  public int getelectricityMeterId() {
	    return electricityMeterId;
	  }

	  public void setelectricityMeterId(int electricityMeterId) {
	    this.electricityMeterId = electricityMeterId;
	  }

	  @Override
	  public String toString() {
	    return "Customer{" +
	        "fullName='" + fullName + '\'' +
	        ", address='" + address + '\'' +
	        ", electricityMeterId=" + electricityMeterId +
	        '}';
	  }
	 
}
