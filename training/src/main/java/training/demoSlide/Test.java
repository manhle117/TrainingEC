package training.demoSlide;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

	
		 public static void main(String[] args) {
		        List<String> list = new ArrayList<>();
		        list.add("A");
		        list.add("B");
		        list.add("C");

		        Iterator<String> iterator = list.iterator();

		        while (iterator.hasNext()) {
		            String element = iterator.next();
		            System.out.println(element);
		            list.remove(element); // Thay đổi tập hợp trong quá trình lặp
		        }
		 }
}
