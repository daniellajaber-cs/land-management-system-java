package project1;

import java.util.Scanner;

class Construction extends AnestheticLand{
	
	//EXTRA ATTRIBUTES 
	private int numberOfLevels;
	private String typeOfSoil;
	
	//CONSTRUCTOR 
	
	public Construction (String NameOfPerson,int idOfLand, double area, double PriceOfOneMeter,int nbLv,String soil ) {
		super(NameOfPerson,idOfLand,area, PriceOfOneMeter);
		this.numberOfLevels = nbLv;
		this.typeOfSoil = soil;
	}
	
	public Construction() {
		super();
		numberOfLevels=0;
		typeOfSoil= " ";
	}
	
	public Construction(int t, String soil ) {
		this.numberOfLevels = t ;
		this.typeOfSoil= soil;
	}
	
	//GETTERS & SETTERS 
	public int getNumberOfLevels() {
		return numberOfLevels;
	}

	public void setNumberOfLevels(int numberOfLevels) {
		this.numberOfLevels = numberOfLevels;
	}

	public String getTypeOfSoil() {
		return typeOfSoil;
	}

	public void setTypeOfSoil(String typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	
	//PRICE OF LAND 
	@Override
	// a method coming from the superclass
		public double priceOfLand() {
			return getArea( )* getPriceOfOneMeter();
	}
	
	//DISPLAY DETAILS 
	public void Display() {
		super.Display();
		System.out.println(" Number of Levels: " + numberOfLevels);
		System.out.println(" Type of soil: "+ typeOfSoil);
	}
	
	// READ DETAILS 
		public void ReadDetailsOfConstructionLand() {
			Scanner scanner = new Scanner(System.in);
			//use setters to update values 
			super.ReadAnestheticLandInformation();
			
			System.out.println(" Please enter number of levels:  ");
			numberOfLevels= scanner.nextInt();
			
			System.out.println(" Please enter the type of soil:");
			typeOfSoil=scanner.nextLine();
			
		}

		

}
