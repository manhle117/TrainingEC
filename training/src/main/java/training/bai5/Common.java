package training.bai5;


import java.util.Arrays;
import java.util.List;

public class Common {

	public static List<Room> listRooms() {
		return Arrays.asList(
		 new Room("101", TypeRoom.A), 
		new Room("102", TypeRoom.B),
		new Room("103", TypeRoom.C), 
		new Room("104", TypeRoom.B), 
		new Room("105", TypeRoom.A) 
		);
	}

}
