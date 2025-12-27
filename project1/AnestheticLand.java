package project1;

import java.util.Scanner;

public abstract class AnestheticLand implements LandPrice {
	//abstract class for both agri & const lands 
	
	// ATTRIBUTES
	protected String NameOfPerson;
	protected int idOfLand;
	protected double area;
	protected double PriceOfOneMeter;
	
	//CONSTRUCTOR
	public AnestheticLand(String NameOfPerson,int idOfLand, double area, double PriceOfOneMeter ) {
		this.NameOfPerson= NameOfPerson;
		this.idOfLand=idOfLand;
		this.area= area;
		this.PriceOfOneMeter= PriceOfOneMeter;
	}
	
	public AnestheticLand() {
		NameOfPerson= " ";
		idOfLand= 0; 
		area= 0.0; 
		PriceOfOneMeter= 0.0;
	}
	
	//COPY CONSTRUCTOR 
	//create a new land 
	public AnestheticLand(AnestheticLand L) {
		NameOfPerson= L.NameOfPerson;
		idOfLand= L.idOfLand; 
		area= L.area; 
		PriceOfOneMeter= L.PriceOfOneMeter;
	}

	//GETTERS & SETTERS
	public String getNameOfPerson() {
		return NameOfPerson;
	}

	public void setNameOfPerson(String nameOfPerson) {
		NameOfPerson = nameOfPerson;
	}

	public int getIdOfLand() {
		return idOfLand;
	}

	public void setIdOfLand(int idOfLand) {
		this.idOfLand = idOfLand;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPriceOfOneMeter() {
		return PriceOfOneMeter;
	}

	public void setPriceOfOneMeter(double priceOfOneMeter) {
		PriceOfOneMeter = priceOfOneMeter;
	}
	
	//DISPLAY 
	public  void Display() {
		System.out.println(" Owners name:"+ NameOfPerson);
		System.out.println(" Land ID: "+ idOfLand);
		System.out.println(" Area of land : "+ area);
		System.out.println(" Price per meter (m): "+ PriceOfOneMeter);
	}
	
	//READ INFO 
	public void ReadAnestheticLandInformation() {
		Scanner scanner= new Scanner(System.in);
		System.out.println(" Please fill out the following information!");
		
		System.out.println("  Please enter name of person: ");
		setNameOfPerson(scanner.nextLine());
		
		System.out.println(" Please enter land ID: ");
		setIdOfLand(scanner.nextInt());
		
		System.out.println(" Please enter area of land: ");
		setArea(scanner.nextDouble());
		
		System.out.println(" Please enter price/meter (m): ");
		setPriceOfOneMeter(scanner.nextDouble());
		
	}
	
	

}
