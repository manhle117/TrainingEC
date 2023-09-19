package training.bai7;

public abstract class Person {
	private String fullName;
	private int old;
	private String homeTown;
	
	
	public Person() {
		super();
	}


	public Person(String fullName, int old, String homeTown) {
		super();
		this.fullName = fullName;
		this.old = old;
		this.homeTown = homeTown;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getOld() {
		return old;
	}


	public void setOld(int old) {
		this.old = old;
	}


	public String getHomeTown() {
		return homeTown;
	}


	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	
	
}
