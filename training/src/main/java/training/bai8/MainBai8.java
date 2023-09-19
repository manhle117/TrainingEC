package training.bai8;

import java.util.ArrayList;
import java.util.List;

import training.bai7.Teacher;
import training.bai9.Customer;
import training.common.InputUtils;

public class MainBai8 {
	
	public static void main(String[] args) {
		String choose;
		List<LibCard> listCard = new ArrayList<>();

		while (true) {
			System.out.println("\n===============================\n");
			System.out.println("1. Add New LibCard");
			System.out.println("2. Show list Card");
			System.out.println("3. Delete card by Id");
			System.out.println("4. Stop");
			System.out.println("\n===============================\n");
			choose = InputUtils.inputString("Input Your choice: ");

			switch (choose) {
			case "1": {
				addNewLibCard(listCard);
				break;
			}

			case "2": {
				listCard.forEach(System.out::println);
				break;
			}

			case "3": {
				String cardId = InputUtils.inputString("Input cardId: ");
				removeCardById(listCard,cardId);
				break;
			}

			case "4": {
				return;
			}

			default:
				break;
			}
		}
	}

	private static void removeCardById(List<LibCard> listCard,String cardId) {
		LibCard libCard = listCard.stream().filter(card -> card.getCardId() == cardId)
				.findFirst().get();
		if (libCard != null) {
			listCard.removeIf(card -> card.getCardId() == cardId);
			System.out.println("List after Remove : ");
			listCard.forEach(System.out::println);
		}else {
			System.out.println("No Customer find out, please input again!!");
		}
	}

	private static void addNewLibCard(List<LibCard> listCard) {
		boolean isExistLibCard = false;
		String cardId;
		while(true) {
			 cardId = InputUtils.inputString("Input CardId");
			for (LibCard libCard : listCard) {
				if(libCard.getCardId().equals(cardId)) {
					isExistLibCard = true;
					break;
				}
			}
			if(isExistLibCard) {
				break;
			}else {
				System.err.println(" Exist Card, please input again");
			}	
		}
		int rentDay = InputUtils.inputNumber("Input rentDay");
		int returnDay = InputUtils.inputNumber("Input return Day");
		int deadLine = InputUtils.inputNumber("Input deadLine");
		String bookId = InputUtils.inputString("Input Book ID");
		String fullName = InputUtils.inputString("Input Full name student: ");
		String classId = InputUtils.inputString("Input Class Id: ");
		int age = InputUtils.inputNumber("Input age: ");
		Student student = new Student(fullName, classId, age);
		LibCard libCard = new LibCard(cardId, rentDay, returnDay, deadLine, bookId, student);
		listCard.add(libCard);
	}
}
