package Assisnments;

import java.util.Collections;
import java.util.TreeMap;

public class employeeInfo {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> emp = new TreeMap<Integer, String>(Collections.reverseOrder());
		
		emp.put(100, "Hari");
		emp.put(101, "Naveen");
		emp.put(102, "Sam");
		emp.put(104, "Balaji");
		
		System.out.println("TreeMap Contains:" + emp);
		
		
	}

}
