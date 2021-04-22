package Assisnments;

public class Reversestring {

	public static void main(String[] args) {
		String text = "I am a software tester";
        String[]words = text.split(" ");
        //word length 5
        for(int i=0; i<words.length; i++) {
        	if(i%2 == 0) {
        		//to print space too
        		System.out.print(" ");
        	System.out.print(words[i]);	
        	        	}
        	if(i%2 != 0) {
        		System.out.print(" ");
        		char[] charArray = (words[i]).toCharArray();
        		for (int j = charArray.length - 1; j >=0 ; j--) {
					System.out.print(charArray[j]);
				}
        	}
        }

}
}