package Assisnments;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String name = "madam";
      String reverse = "";
      for(int i=name.length()-1; i>=0; i--) {
    	  reverse = reverse+name.charAt(i);
      }
      if(name.equals(reverse)) {
    	System.out.println("The string is a palindrome:");	
	}
    	else {
      System.out.println("The string is not a palindrome:");
	}

}}
