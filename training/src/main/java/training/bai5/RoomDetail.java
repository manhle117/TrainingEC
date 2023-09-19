package training.bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomDetail {
	private int dayHire;
	private Room room;
	private List<Person> listPerson;
	
	
	public RoomDetail() {
		super();
	}

	
	
	public RoomDetail(int dayHire, Room room, List<Person> listPerson) {
		super();
		this.dayHire = dayHire;
		this.room = room;
		this.listPerson = listPerson;
	}



	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getDayHire() {
		return dayHire;
	}
	public void setDayHire(int dayHire) {
		this.dayHire = dayHire;
	}
	public List<Person> getListPerson() {
		return listPerson;
	}
	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}
	



	@Override
	public String toString() {
		return "RoomDetail [dayHire=" + dayHire + ", room=" + room + ", listPerson=" + listPerson + ",Money="+ getMoney()+ "]";
	}
	public Integer getMoney() {
		if(room.getTypeRoom().toString().equals("A")) {
			return dayHire*500;
		}else if(room.getTypeRoom().toString().equals("B")) {
			return dayHire*300;
		}else {
			return dayHire*100;
		}
	}

	
}
