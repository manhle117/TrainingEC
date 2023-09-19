package training.bai8;

public class LibCard {
	private String cardId;
	private int rentDate;
	private int returnDate;
	private int deadLine;
	private String bookId;
	private Student student;

	public LibCard(String cardId, int rentDate, int returnDate, int deadLine, String bookId, Student student) {
		super();
		this.cardId = cardId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.deadLine = deadLine;
		this.bookId = bookId;
		this.student = student;
	}
	
	
	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public int getRentDate() {
		return rentDate;
	}
	public void setRentDate(int rentDate) {
		this.rentDate = rentDate;
	}
	public int getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}
	public int getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "LibCard [cardId=" + cardId + ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", deadLine="
				+ deadLine + ", student=" + student + "]";
	}
	
	
	
}
