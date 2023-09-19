package training.bai5;

import java.util.List;

public class Hotel {
	private List<Room> listRoom;

	
	
	public Hotel() {
		super();
	}

	public Hotel(List<Room> listRoom) {
		super();
		this.listRoom = listRoom;
	}

	public List<Room> getListRoom() {
		return listRoom;
	}

	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}
	
}
