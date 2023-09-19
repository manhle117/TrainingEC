package training.bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<RoomDetail> listRoomDetail = new ArrayList<>();
		
		int choose;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n===============================\n");
			System.out.println("1. Thue phong");
			System.out.println("2. Xem danh sach");
			System.out.println("3. Xoa khach");
			System.out.println("4. Thoat");
			System.out.println("\n===============================\n");
			System.out.print("Nhap lua chon: ");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Common.listRooms().forEach(System.out::println);
				Person person;
				List<Person> listPeople = new ArrayList<>();
				System.out.println("Room number: ");
				String roomNumber = sc.nextLine();
				Room room = Common.listRooms().stream()
						.filter(roomFind -> roomFind.getRoomNumber().equalsIgnoreCase(roomNumber)).findAny().get();
				System.out.println("Number of Day rent: ");
				Integer dayHire = Integer.parseInt(sc.nextLine());
				System.out.println("Number of person: ");
				Integer numberPerson = Integer.parseInt(sc.nextLine());
				String fullName;
				String cmnd;
				Integer old;
				int i;

				for (i = 1; i <= numberPerson; i++) {
					System.out.println("Nhap thong tin cua nguoi " + i);
					System.out.println("Cmnd: ");
					cmnd = sc.nextLine();
					System.out.println("FullName: ");
					fullName = sc.nextLine();
					System.out.println("Old: ");
					old = Integer.parseInt(sc.nextLine());
					person = new Person(cmnd, fullName, old);
					listPeople.add(person);
				}
				listRoomDetail.add(new RoomDetail(dayHire, room, listPeople));
				break;
			case 2:
				listRoomDetail.forEach(System.out::println);
				break;
			case 3:
				System.out.println("Nhap CMND muon xoa: ");
				String idCard = sc.nextLine();
		
				listRoomDetail.removeIf(personRoom -> personRoom.getListPerson().stream().anyMatch(x -> x.getCmnd().equals(idCard)));
				break;
			case 4:
				System.out.println("Bye");
				return;
			default:
				break;
			}

		}

	}

}
