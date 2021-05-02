package Assisnments;

public class desktop implements Hardware,Software {
	
	public void desktopModel() {
		System.out.println("HP");
	}
	
	public void softwareResources() {
		System.out.println("Software");
		
	}
	public void hardwareResources() {
		System.out.println("Hardware");
		
	}
public static void main(String args[]) {
		desktop dsk = new desktop();
		dsk.softwareResources();
		dsk.hardwareResources();
		
	}
		
	}

