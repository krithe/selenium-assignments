package Assisnments;

public class Removeduplicates {

	public static void main(String[] args) {
		String text = "we learn java basics as part of java sessions in java week1";
			String[] words = text.split(" ");
		for(int i=0; i<words.length;i++) {//we[0] stable for entire sec loop
			for(int j=i+1; j<words.length; j++){//learn[1],java[2],basics[3].....
			if(words[i].equals(words[j])) {
				words[j]="";
				
			}
			}
			System.out.print(words[i]+ " ");
		}
		
	}

}
