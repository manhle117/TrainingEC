package training.bai9;

import java.util.ArrayList;
import java.util.List;

import training.common.InputUtils;

public class MainBai9 {
	public static void main(String[] args) {
		String choose;
		List<Customer> listCustomer = new ArrayList<>();

		while (true) {
			System.out.println("\n===============================\n");
			System.out.println("1. Add Customer");
			System.out.println("2. Show list Customer");
			System.out.println("3. Delete customer by electricityMeter Id");
			System.out.println("4. update customer by numOfElectricityMeter");
			System.out.println("5. calculate price each customer by numOfElectricityMeter");
			System.out.println("6. Stop");
			System.out.println("\n===============================\n");
			choose = InputUtils.inputString("Input Your choice: ");

			switch (choose) {
			case "1": {
				addNewCustomer(listCustomer);
				break;
			}

			case "2": {
				showListCustomer(listCustomer);
				break;
			}

			case "3": {
				int electricityMeterId = InputUtils.inputNumber("input electricityMeterId: ");
				removeCustomerByNumOfElectricityMeter(listCustomer, electricityMeterId);
				break;
			}

			case "4": {
				int electricityMeterId = InputUtils.inputNumber("input electricityMeterId: ");
				updateCustomerByNumOfElectricityMeter(listCustomer, electricityMeterId);
				break;
			}

			case "5": {
				int electricityMeterId = InputUtils.inputNumber("input electricityMeterId: ");
				calculateCustomerByNumOfElectricityMeter(listCustomer, electricityMeterId);
				break;
			}

			case "6": {
				return;
			}

			default:
				break;
			}
		}
	}

	private static void calculateCustomerByNumOfElectricityMeter(List<Customer> listCustomer, int electricityMeterId) {
		Customer cus = listCustomer.stream().filter(customer -> customer.getelectricityMeterId() == electricityMeterId)
				.findFirst().get();
		if (cus != null) {
			int oldElectric = InputUtils.inputNumber("Input old Electric: ");
			int newElectric = InputUtils.inputNumber("Input new Electric: ");
			Bill bill = new Bill(cus, oldElectric, newElectric);
			System.out.println("Bill: " + bill.toString());

		} else {
			System.err.println("No customer find out, please input again!!");
		}

	}

	private static void updateCustomerByNumOfElectricityMeter(List<Customer> listCustomer, int electricityMeterId) {
		Customer cus = listCustomer.stream().filter(customer -> customer.getelectricityMeterId() == electricityMeterId)
				.findFirst().get();
		if (cus == null) {
			System.out.println("No Customer find out, please input again!!");
		} else {
			System.out.println("Old Information: " + cus.toString());
			System.out.println("--------Input New Infor------");
			String fullName = InputUtils.inputString("Input fullName: ");
			String address = InputUtils.inputString("Input Address: ");
			cus.setAddress(address);
			cus.setFullName(fullName);
			updateCustomer(listCustomer, cus);
			System.out.println("List Customer after Update: ");
			listCustomer.forEach(System.out::println);
		}
	}

	private static void updateCustomer(List<Customer> listCustomer, Customer cus) {
		for (Customer customer : listCustomer) {
			if (customer.getelectricityMeterId() == cus.getelectricityMeterId()) {
				customer.setAddress(cus.getAddress());
				customer.setFullName(cus.getFullName());
			}
		}

	}

	private static void removeCustomerByNumOfElectricityMeter(List<Customer> listCustomer, int electricityMeterId) {
		Customer cus = listCustomer.stream().filter(customer -> customer.getelectricityMeterId() == electricityMeterId)
				.findFirst().get();
		if (cus != null) {
			listCustomer.removeIf(customer -> customer.getelectricityMeterId() == electricityMeterId);
			System.out.println("List after Remove : ");
			listCustomer.forEach(System.out::println);
		}else {
			System.out.println("No Customer find out, please input again!!");
		}
	}

	private static void showListCustomer(List<Customer> listCustomer) {
		listCustomer.forEach(System.out::println);
	}

	private static void addNewCustomer(List<Customer> listCustomer) {
		boolean isExistElectricityMeterId = false;
		String fullName = InputUtils.inputString("Input fullName: ");
		String address = InputUtils.inputString("Input Address: ");
		int electricityMeterId;
		while (true) {
			electricityMeterId = InputUtils.inputNumber("Input electricityMeterId: ");
			for (Customer customer : listCustomer) {
				if (customer.getelectricityMeterId() == electricityMeterId) {
					isExistElectricityMeterId = true;
					System.out.println("Duplicate electricityMeterId, please input again!! ");
				} else {
					break;
				}
			}
			if (!isExistElectricityMeterId) {
				break;
			}
		}
		Customer cus = new Customer(fullName, address, electricityMeterId);
		listCustomer.add(cus);

	}
}
