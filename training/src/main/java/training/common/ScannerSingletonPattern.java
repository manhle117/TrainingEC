package training.common;

import java.util.Scanner;

public class ScannerSingletonPattern {
	private static Scanner instance = null;
	
	private ScannerSingletonPattern() {}
	public static Scanner getInstance() {
		if(instance == null) {
			instance = new Scanner(System.in);
		}
		return instance;
	}
}
