package training.bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import training.common.InputUtils;

public class MainBai6 {

	public static void main(String[] args) {
		int choose;
		List<Student> listStudent = new ArrayList<>();
		while (true) {
			System.out.println("\n===============================\n");
			System.out.println("1. Add Student");
			System.out.println("2. Show list Student ");
			System.out.println("3. Show list Student by old");
			System.out.println("4. Show number of Student by old and Hometown");
			System.out.println("5. Thoat");
			System.out.println("\n===============================\n");
			choose = InputUtils.inputNumber("Input Selection: ");
			switch (choose) {
			case 1: {
				Student student = new Student();
				student.addNewStudent();
				listStudent.add(student);
				break;
			}
			case 2: {
				listStudent.forEach(System.out::println);
				break;
			}
			case 3: {
				int oldFind = InputUtils.inputNumber("Input old want to find: ");
				findListStudentByOld(oldFind, listStudent);
				break;
			}
			case 4: {
				int old = InputUtils.inputNumber("Input old want to find: ");
				String hometown = InputUtils.inputString("Input Hometown to find");
				countStudentByOldAndHometown(old,hometown,listStudent);
				break;
			}
			}
		}
	}

	private static void countStudentByOldAndHometown(int old, String hometown, List<Student> listStudent) {
		List<Student> listStudentExpected = listStudent.stream()
									.filter(student -> student.getOld() == old)
									.filter(student -> student.getHomeTown().equalsIgnoreCase(hometown))
									.collect(Collectors.toList());	
		System.out.println("Number of Student Expected: "+ listStudentExpected.size());
		listStudentExpected.forEach(System.out::println);
		
	}

	private static void findListStudentByOld(int oldFind, List<Student> listStudent) {
		List<Student> listStudentFound = listStudent.stream().filter(studentFound -> studentFound.getOld() == oldFind)
				.collect(Collectors.toList());
		if(listStudentFound.isEmpty()) {
			System.out.println("No student find out");
		}else {
		listStudentFound.forEach(System.out::println);
		}
	}
}
