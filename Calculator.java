package Assisnments;

public class Calculator {
	public void add(int a, int b) {
	
		int c = a + b;
		System.out.println(c);
	}
	 public void add(int a, int b, int c) {
		 int d = a + b + c;
		 System.out.println(d);
	 }
	 
	 public void multiply(int a, int b) {
		 int c = a * b;
		 System.out.println(c);
		 
	 }
	 
	 public void multiply(int c , double d) {
		 double k = c * d;
		 System.out.println(k);
	 }
	 
	 public void sub(int a , int b) {
		 int c = a - b;
		 System.out.println(c);
	 }
	 
	 public void sub(double a , double b) {
		 double c = a - b;
		 System.out.println(c);
	 }
	 
	 public void div(int a , int b) {
		 int c = a/b;
		 System.out.println(c);
	 }
	 
	 public void div(double a, int b) {
	     double c = a/b;
	    System.out.println(c);
	 }
	 
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		System.out.println(cal);
		cal.add(5, 7);
		cal.add(3, 5, 8);
		cal.multiply(40, 20);
		cal.multiply(25, 2525);
		cal.sub(30, 10);
		cal.sub(25630, 22000);
		cal.div(100, 10);
		cal.div(46952, 2);

	}

}
