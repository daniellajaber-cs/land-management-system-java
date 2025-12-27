package project1;

class Country { //this class has one attribute we use constructors to set it and use g&s to access or change it 
	protected int  CountryNumber;
	
	//CONSTRUCTOR 
	public Country(int num) {
		super();
		this.CountryNumber = num;
	}
	
	public Country() {
		super();
	}
	
	//GETTERS & SETTERS 

	public int getCountryNumber() {
		return CountryNumber;
	}

	public void setCountryNumber(int countryNumber) {
		CountryNumber = countryNumber;
	}
	
	

}
