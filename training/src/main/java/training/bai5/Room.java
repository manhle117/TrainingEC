package training.bai5;


public class Room {
	private String roomNumber;
	private TypeRoom typeRoom;
	
	
	
	public Room() {
		super();
	}


	public Room(String roomNumber, TypeRoom typeRoom ) {
		super();
		this.roomNumber = roomNumber;
		this.typeRoom = typeRoom;
	

	}


	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public TypeRoom getTypeRoom() {
		return typeRoom;
	}


	public void setTypeRoom(TypeRoom typeRoom) {
		this.typeRoom = typeRoom;
	}


	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", typeRoom=" + typeRoom + "]";
	}

	
	
	
	
	
	
}
