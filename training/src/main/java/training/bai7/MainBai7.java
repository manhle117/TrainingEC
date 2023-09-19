package training.bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainBai7 {

	public static void main(String[] args) {
		int choose;
		Scanner sc = new Scanner(System.in);
		List<Teacher> listTeacher = new ArrayList<>();
		List<Student> listStudent = new ArrayList<>();
		while (true) {
			System.out.println("\n===============================\n");
			System.out.println("1. Add person");
			System.out.println("2. Show list Student of Teacher ID");
			System.out.println("3. Delete Teacher by TeacherID");
			System.out.println("4. Thoat");
			System.out.println("\n===============================\n");
			System.out.print("Nhap lua chon: ");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1: {
				System.out.println("FullName : ");
				String fullName = sc.nextLine();
				System.out.println("Old: ");
				int old = Integer.parseInt(sc.nextLine());
				System.out.println("Hometown: ");
				String homeTown = sc.nextLine();
				int select;
				boolean isValisSelect = false;
				do {
					System.out.println("You want add : \n1.Teacher \n2.Student");
					select = Integer.parseInt(sc.nextLine());
					if (select == 1) {
						Teacher teacher = new Teacher();
						teacher.addTeacher(listTeacher);
						teacher.setFullName(fullName);
						teacher.setHomeTown(homeTown);
						teacher.setOld(old);
						listTeacher.add(teacher);
						isValisSelect = true;
					} else if (select == 2) {
						if (listTeacher.isEmpty()) {
							System.out.println("Vui lòng tạo giáo viên trước khi thêm học sinh.");
						} else {
							Student student = new Student();
							student.addStudent(listStudent, listTeacher);
							student.setFullName(fullName);
							student.setHomeTown(homeTown);
							student.setOld(old);
							listStudent.add(student);
							isValisSelect = true;
						}
					}
				} while (!isValisSelect);

				break;
			}
			case 2: {
				String teacherId;
				Teacher t = null;
				List<Student> getListStudentOfTeacherId = null;
				while (true) {
					System.out.println("Input Teacher ID want to find");
					teacherId = sc.nextLine();
					String finalTeacherId = teacherId;
					t = findTeacher(teacherId, listTeacher);
					if (t != null) {
						getListStudentOfTeacherId = listStudent.stream()
								.filter(studentOfTeacher -> studentOfTeacher.getTeacherId().equals(finalTeacherId))
								.collect(Collectors.toList());

						break;
					} else {
						System.err.println("Not found TeacherId, please Input again ");
					}
				}

				System.out.println("Student Of TeacherID: " + teacherId);
				System.out.println(t.toString());
				getListStudentOfTeacherId.forEach(System.out::println);
				break;
			}
			case 3: {
				String teacherId;
				Teacher t;
				while (true) {
					System.out.println("Input Teacher ID want to find");
					teacherId = sc.nextLine();
					t = findTeacher(teacherId, listTeacher);
					if (t != null) {
						listTeacher.remove(t);
						break;
					} else {
						System.err.println("Not found TeacherId, please Input again ");
					}
				}
				System.out.println("List teacher after delete:");
				listTeacher.forEach(System.out::println);
			}
			default:
				break;
			}
		}

	}

	private static Teacher findTeacher(String teacherId, List<Teacher> listTeacher) {
		for (Teacher t : listTeacher) {
			if (teacherId.equals(t.getTeacherId())) {
				return t;
			}

		}
		return null;
	}

}
