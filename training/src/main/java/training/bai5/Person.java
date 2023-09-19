package training.bai5;

public class Person {
	private String cmnd;
	private String hoTen;
	private int	tuoi;
	
	
	public Person() {
		super();
	}
	public Person(String cmnd, String hoTen, int tuoi) {
		super();
		this.cmnd = cmnd;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return "Person [cmnd=" + cmnd + ", hoTen=" + hoTen + ", tuoi=" + tuoi + "]";
	}
	
}
