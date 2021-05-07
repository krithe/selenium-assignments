package Assisnments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortingUsingCollection {

	public static void main(String[] args) {
		String[] input = { "HCL", "Wipro", "Aspire Systems", "CTS" };

		// declaring an empty list for adding the string values
		List<String> lst = new ArrayList<String>();

		//iterating for adding the value into the list
		for (int i = 0; i < input.length; i++) {
			lst.add(input[i]);
		}
		
		//printing the size of the 
		System.out.println(lst.size());
		Collections.sort(lst);
		System.out.println(lst);
		for (int i = lst.size() - 1; i >= 0; i--) {
			String string = lst.get(i);
			System.out.print(string + ",");
		}
	}

}
//Wipro, HCL , CTS, Aspire Systems/