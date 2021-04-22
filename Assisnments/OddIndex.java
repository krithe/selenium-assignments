package Assisnments;

public class OddIndex {

	public static void main(String[] args) {
		String test = "changeme";
	
		char[] characters = test.toCharArray();
		System.out.println(characters.length);
		for (int i = 0; i<characters.length; i++) {
					if (i%2 != 0) {
						System.out.print(Character.toUpperCase(characters[i]));
					}
					else
					{ 
						System.out.print(characters[i]);
					}
				//System.out.print(Character.toUpperCase(characters[i])); to print horizontal(remove ln)
				
		}
		
	}
}


