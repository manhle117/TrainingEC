package training.common;

import java.util.List;

public class InputUtils {
	public static int inputNumber(String message) {
		System.out.println(message);
		return Integer.parseInt(ScannerSingletonPattern.getInstance().nextLine());
	}
	public static String inputString(String message) {
		System.out.println(message);
		return ScannerSingletonPattern.getInstance().nextLine();
	}
	public static double inputDouble(String message) {
		System.out.println(message);
		return Double.parseDouble(ScannerSingletonPattern.getInstance().nextLine());
	}
	
	
}
