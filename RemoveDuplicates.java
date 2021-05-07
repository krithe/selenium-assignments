package Assisnments;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String str = "PayPal India";
		char[] charArray = str.toCharArray();

		// Declare set

		Set<Character> ch = new LinkedHashSet<Character>(); //for insertion order use linkedhashset(eg in order p,a,y.. adds space..) 
		for (Character eachcharacter : charArray) {
			ch.add(eachcharacter);
		}
		System.out.println(ch);
		System.out.println("*****"); // for differentiation
		for (Character chars : ch) {

			// To remove space

			if (chars != ' ') {
				System.out.print(chars);
			}
		}
	}
}
