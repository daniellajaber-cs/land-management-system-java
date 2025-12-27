package project1;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class Province {
	
	//PRIVATE ATTRIBUTES 
	private String name;
	private int NumberOfAnestheticLands;
	private AnestheticLand[] L;
	
	//CONSTRUCTOR
	public Province(int size,String s ) {
		this.name=s;
		L= new AnestheticLand[size];
		NumberOfAnestheticLands= 0;
	}
	
	//SETTERS AND GETTERS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfAnestheticLands() {
		return NumberOfAnestheticLands;
	}

	public void setNumberOfAnestheticLands(int numberOfAnestheticLands) {
		NumberOfAnestheticLands = numberOfAnestheticLands;
	}

	public AnestheticLand[] getL() {
		return L;
	}

	public void setL(AnestheticLand[] l) {
		L = l;
	}
	
	//CHECK IF ARRAY OF LANDS IS FULL
	public boolean isFull() {
		for(int i=0;i<L.length;i++) {
			if(L[i] == null) { //finds an empty spot returns false
				return false;
			}
		}
		return true;
	}
	
	//CHECK IF ARRAY OF LANDS  IS EMPTY
	public boolean isEmpty() {
		for(int i=0;i<L.length;i++) {
			if(L[i] != null) { // if there is a land return false
				return false;
			}
		}
		return true;
	}
	
	//ADSS A LAND OBJECT TO THE PROVINCE 
	public boolean AddAnestheticLand(AnestheticLand land) { //adds a new land to the array
		if(!isFull()) { // if theres space
			L[NumberOfAnestheticLands]=land; //stores the  new land and increment 
			NumberOfAnestheticLands++;
			return true; // if added else false 
		}
		return false;
	}
	
	//SEARCH METHOD 
	public int searchLandById(int idLand) { //checks each id 
		for(int i = 0 ; i<NumberOfAnestheticLands; i++) {
			if(L[i].getIdOfLand()==idLand) { //if it finds a match 
				return i ; // returns index that a land is found 
			}
		}
		return -1; //land not found 
	}

	//DELETE METHOD 
	public boolean DeleteAnestheticLand(int idOfland) { //deletes a land using its id 
		int position=searchLandById( idOfland); // uses a search method if land exists
		if(position==-1) { 
			return false ;	
		}
		//if not move lands after the one deleted 
		for(int i = position ; i < NumberOfAnestheticLands-1;i++) {
			L[i]= L[i+1]; //move the land back to fill the deleted spot 
		}
		NumberOfAnestheticLands--; // decrement 
		return true;
	}
	
	
	//DISPLAY DETAILS 
	public void displayAllLands() {
		for(int i=0;i<NumberOfAnestheticLands ; i++) {
			L[i].Display();
		}
	}
	
	
	// NUMBER OF AGRICULTURE LANDS 
	
	//each method loops through all lands and check their type using instance of 
	public int FindNumberOfAgricultureLands() {
		int count =0 ;
		for(int i =0 ; i < NumberOfAnestheticLands; i++) {
			if(L[i] instanceof Agriculture) { //if it is an element in agri object 
				count++;
			}
		}
		return count;
	}
	
	
	// NUMBER OF CONSTRUCTION LANDS 
	public int FindNumberOfConstructionLands() {
		int count=0; 
		for(int i =0; i<NumberOfAnestheticLands; i++) {
			if(L[i] instanceof Construction) {
				count++;
			}
		}
		return count;
	}
	
	//UPDATE LAND INFORMATION
	public boolean UpdateLandInformation(int idLand) {
		int position = searchLandById(idLand); // finds the land using id 
		if(position!=-1) { //true
			L[position].ReadAnestheticLandInformation();  //calls read method to update the information 
			return true;
		}
		return false;
	}
	
	//MERGE TWO LANDS 
	public boolean MergeTwoLands(int idOfLand1,int IdOfLand2) {   // find both lands using id 
		int L1=searchLandById(idOfLand1);
		int L2=searchLandById(IdOfLand2);
		if(L1 != -1 && L2 !=-1 && L1 != L2) { //generates area of each 
			double area1=L[L1].getArea();
			double area2= L[L2].getArea();
			L[L1].setArea(area1 + area2); //merged two lands 
			return DeleteAnestheticLand(IdOfLand2);  // delete the second land so there isnt an extra one once merged
		}
		return false;
	}
	
	//SPLIT LAND 
	public boolean SplitLand(int idPre, int idNew, double Percent) {
		int position= searchLandById(idPre); // old id 
		if(position !=-1) { // if land is found 
			double oldArea= L[position].getArea();
			//calculates new area & remaining 
			double newArea= oldArea * (Percent/100);
			double remainingArea= oldArea-newArea;// calculate new area and remaining 
			
			L[position].setArea(remainingArea); //update the old area 
			
			// check if the land is agri or const using instance of 
			//creat a new land object with newArea and newid and add the other details from both 
			
			if(L[position] instanceof Agriculture) { // to check if the land is agi or const 
				//get values of each 
				String name=L[position].getNameOfPerson();
				double price = L[position].getPriceOfOneMeter();
				String crop = ((Agriculture) L[position]).getCropToBeSeeded(); // this is an agriculture object so type casting is needed to access it 
				
				//create a new agri land 
				//because we have 2 lands so we need to store the new created land in the array
				
				Agriculture newLand= new Agriculture (name,idNew,newArea,price,crop);
				return AddAnestheticLand(newLand); 
				
			}else if(L[position] instanceof Construction ) {
				String name=L[position].getNameOfPerson();
				double price = L[position].getPriceOfOneMeter();
				int levels = ((Construction )L[position]).getNumberOfLevels(); //found in only construction type casting 
				String soil = ((Construction)L[position]).getTypeOfSoil();
			
			//create a new const land 
			Construction newLand= new Construction(name,idNew,newArea,price,levels,soil);
			return AddAnestheticLand(newLand);
			}
		}
		return false; //if land not found 
	}
	
	// STORE DATA 
	//to write a file 
	public void storeData(String AgricultureFileName, String ConstructionFileName) throws IOException {  //create 2 files 
		FileWriter input1= new FileWriter(AgricultureFileName); //goes through the land & its details 
		FileWriter input2= new FileWriter(ConstructionFileName);
		
		for(int i=0; i< NumberOfAnestheticLands;i++) {
			if(L[i] instanceof Agriculture) { //check if its an agri land and access the right attributes 
				input1.write(L[i].toString());  // convert land object to a string and write to file input1
			}else if(L[i] instanceof Construction) { //check if its a const land
				input2.write(L[i].toString());  // write to file input 2 
			}
		}
		input1.close();
		input2.close();
	}
	
	// AGRICULTURE INFO 
	public Agriculture[] TakeAgricultureInfoFromFile(String agriName) throws IOException { //to read agi land data from file 
		Scanner scanner = new Scanner(new File( agriName)); //opened the file using scanner
		int NumberOfLands= scanner.nextInt();
		scanner.nextLine();
		
		Agriculture [] agriculturelands= new Agriculture[NumberOfLands]; //create an AGRICULTURE object to store details of each value 
		
		for(int i=0; i< NumberOfLands; i++) { //stored all agriculture objects into array
			String name = scanner.nextLine();
			int id = scanner.nextInt();
			double area = scanner.nextDouble();
			double price= scanner.nextDouble();
			String crop= scanner.nextLine();
			
			agriculturelands[i] = new Agriculture(name,id,area,price,crop);
		}
		scanner.close();
		return agriculturelands; //returned the array 
	}
	
	//CONSTRUCTION INFO
	public Construction[] TakeConstructionInfoFromFile(String constName) throws IOException {
		Scanner scanner = new Scanner(new File( constName)); //opened the file using scanner
		int NumberOfLands= scanner.nextInt();
		scanner.nextLine();
		Construction [] constructionlands= new Construction[NumberOfLands]; //create a CONSTRUCTION object 
		
		for(int i=0; i< NumberOfLands; i++) { //stored all construction objects into array
			String name = scanner.nextLine();
			int id = scanner.nextInt();
			double area = scanner.nextDouble();
			double price= scanner.nextDouble();
			int levels= scanner.nextInt();
			String soil= scanner.nextLine();
			
			constructionlands[i] = new Construction(name,id,area,price,levels,soil);
		}
		scanner.close();
		return constructionlands; //returned the array 
	}
	
	//PRICE OF AGRICULTURE LAND 
	public double PriceOfAgricultureLandById(String fileName,int id) throws IOException { //new file and reads the number of lands 
		Scanner scanner = new Scanner(new File(fileName));
		int size= scanner.nextInt(); //read number of lands
		scanner.nextLine();
		
		for(int i =0 ; i<size; i++) {
			String name=scanner.nextLine();
			int landId= scanner.nextInt();
			scanner.nextLine();
			double area = scanner.nextDouble();
			scanner.nextLine();
			double pricePerM = scanner.nextDouble();
			scanner.nextLine();
			String crop = scanner.nextLine();
			
			if(landId==id) { //check if id matches
				return area*pricePerM; //calculate and return price
			}
		}
		
		scanner.close();
		return -1; // if land not found 
	}
	
	//PRICE OF CONSTRUCTION LAND 
	public double PriceOfConstructionLandById(String fileName,int id) throws IOException { //new file
		Scanner scanner = new Scanner(new File(fileName));
		int size= scanner.nextInt(); //read number of lands
		scanner.nextLine();
		
		for(int i =0 ; i<size; i++) {
			String name=scanner.nextLine();
			int landId= scanner.nextInt();
			scanner.nextLine();
			double area = scanner.nextDouble();
			scanner.nextLine();
			double pricePerM = scanner.nextDouble();
			scanner.nextLine();
			int levels= scanner.nextInt();
			scanner.nextLine();
			String soil = scanner.nextLine();
			
			if(landId==id) { //check if id matches
				return area*pricePerM; //calculate and return price
			}
		}
		
		scanner.close();
		return -1; // if land not found 
	}
	
	//PRICE OF LAND BY ID
	public double SecondMethodToFindPriceOfLandById(int id) {
		for(int i = 0; i< NumberOfAnestheticLands; i++) { // goes through lands already stored
			if( L[i].getIdOfLand()==id) {
				return L[i].priceOfLand(); // use method from class
			}
		}
		return -1;//return false if id not found 
	}
	
	

}
