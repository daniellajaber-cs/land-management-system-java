package project1;

import java.util.Scanner;

class Agriculture extends AnestheticLand {
	// EXTRA ATTRIBUTE 
	private String cropToBeSeeded;
	
	//CONSTRUCTOR 
	public Agriculture (String NameOfPerson,int idOfLand, double area, double PriceOfOneMeter, String crop) {
		super(NameOfPerson,idOfLand,area, PriceOfOneMeter); //superclass Anesthetic 
		this.cropToBeSeeded=crop;
	}
	
	//DEFAULT 
	public Agriculture() {
		super();
		cropToBeSeeded= " ";
	}
	
	public Agriculture (String j ) {
		this.cropToBeSeeded=j;
	}

	
	//GETTER & SETTERS 
	public String getCropToBeSeeded() {
		return cropToBeSeeded;
	}

	public void setCropToBeSeeded(String cropToBeSeeded) {
		this.cropToBeSeeded = cropToBeSeeded;
	}
	
	
	//PRICE OF LAND 
	public double priceOfLand() {
		return getArea( )* getPriceOfOneMeter();
	}
	

	//DISPLAY DETAILS 
	@Override
	public void Display() {
		super.Display();
		System.out.println(" Crops to be seeded: " + cropToBeSeeded);
	}
	
	// READ DETAILS 

	public void ReadDetailsOfAgricultureLand() {
		Scanner scanner = new Scanner(System.in);
		
		super.ReadAnestheticLandInformation();
		
		System.out.println(" Please enter crop to be seeded: ");
		cropToBeSeeded= scanner.nextLine();
		
	}
	
	
	
}
