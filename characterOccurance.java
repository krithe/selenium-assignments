package Assisnments;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class characterOccurance {

	public static void main(String[] args) {
		String phrase = "welcome to selenium automation";
		char[] charArray = phrase.toCharArray();
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i = 0; i < charArray.length; i++) {
			if(!map.containsKey(charArray[i])) { //for existing key
			map.put(charArray[i], 1);
					 
			}
			else {
				int value = map.get(charArray[i]);
				value += 1;
				map.put(charArray[i], value);
			}
			
			
		}
		
		System.out.println(map);    
	}

}