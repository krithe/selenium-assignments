package Assisnments;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student id is:" + " " + id);
		
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student id and Name is:" + " " + id +" " +name);
	}
	 public void getStudentInfo(String email, long phonenumber) {
		 System.out.println("Student Email Id and Phonenumber is:"+"  "+email +" "+phonenumber);
	 }

	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo(1200);
		obj.getStudentInfo(1200, "Adithi");
		obj.getStudentInfo("abc@gmail.com", 252624252);

	}

}
