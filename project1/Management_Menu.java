package project1;

import java.io.IOException;
import java.util.Scanner;

public class Management_Menu {

	public static void main(String[] args) throws IOException {
	Scanner scanner= new Scanner(System.in);
	//INITIALIZE PROVINCE 
	
	System.out.println("---- WELCOME TO THE LAND MANAGEMENT FILING SYSTEM !----");
	
	System.out.println(" Please enter province name: ");
	String proName= scanner.nextLine();

	System.out.println(" Please enter the maximum number of lands: ");
	int maxLand= scanner.nextInt();
	
	Province province = new Province(maxLand,proName);
	
	System.out.println(" Please choose one of option below ( 1 or 2 ) : ");
	System.out.println(" Option 1 --> Fill entire operations to fill ");
	System.out.println(" Option 2 --> Choose a specific operation : ");
	int option = scanner.nextInt();
	
	if(option==1) {
		
		System.out.println(" \n === ADD AGRICULTURE LAND ===");
		Agriculture agriculture = new Agriculture();
		agriculture.ReadDetailsOfAgricultureLand();
		province.AddAnestheticLand(agriculture);
		System.out.println(" Added ID for agriculture land : "+ agriculture.getIdOfLand());
		
		
	
		System.out.println(" \n === ADD CONSTRUCTION LAND ===");
		Construction construction = new Construction ();
		construction.ReadDetailsOfConstructionLand();
		province.AddAnestheticLand(construction);
		System.out.println(" Added ID for construction  land : "+ construction.getIdOfLand());
		
		
	 
		System.out.println(" \n === DELETE LAND ===");
		System.out.println(" Please enter the land ID to delete: ");
		int deleteID= scanner.nextInt();
		scanner.nextLine();
		if(province.DeleteAnestheticLand(deleteID)) {
			System.out.println(" Done! Land ID " + deleteID + " deleted. ");
		}else {
			System.out.println(" Sorry! Land ID"+ deleteID + " not found");
		}
	
	
		System.out.println(" \n === SEARCH LAND BY ID === ");
		System.out.println(" Please enter land ID to search :  ");
		int searchLandID= scanner.nextInt();
		scanner.nextLine();
		int sLandID= province.searchLandById(searchLandID);
		if(sLandID !=-1) {
			province.getL()[sLandID].Display();
		}else {
			System.out.println(" Sorry! Land ID "+ searchLandID + " not found .");
		}
		
		
	
		System.out.println(" \n ===DISPLAY ALL LANDS ===");
		province.displayAllLands();
		
		
	
		System.out.println(" Number of Agriculture lands : "+ province.FindNumberOfAgricultureLands());
		
		
	
		System.out.println(" Number of Construction lands : "+ province.FindNumberOfConstructionLands());
		
		
	
		System.out.println(" \n === UPDATE LAND INFOTMATION ===");
		System.out.println(" Please enter the land ID to update : ");
		int updateID= scanner.nextInt();
		scanner.nextLine();
		if(province.UpdateLandInformation(updateID)) {
			System.out.println(" Done! Land ID "+ updateID + " updated. ");
		}else {
			System.out.println(" Sorry! Land ID "+ updateID + " not found. Try again. ");
		}
		
		
	
		System.out.println(" \n ===MERGE TWO LAND ===");
		System.out.println(" Please enter the first land ID : ");
		int land1= scanner.nextInt();
		System.out.println(" Please enter the second land ID : ");
		int land2= scanner.nextInt();
		scanner.nextLine();
		if(province.MergeTwoLands(land1, land2)) {
			System.out.println(" Lands are merged to ID : " + land1);
		}else { 
			System.out.println(" Sorry! Merging of two lands failed . Try again ");
		}
		
		
	
		System.out.println("\n === SPLITING OF LANDS ===");
		System.out.print("Please enter the old land ID: ");
        int eLandID = scanner.nextInt();
        System.out.print(" Please enter new land ID: ");
        int newLandID = scanner.nextInt();
        System.out.print(" Please enter percentage to split: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine();
        if (province.SplitLand(eLandID, newLandID, percentage)) {
            System.out.println("Land split Done!New ID : " + newLandID );
        }else {
            System.out.println(" Sorry ! Split failed. Try again ");
        }
        
    
    	System.out.println(" \n ===STORE DTA IN FILE ===");
    	System.out.println(" Please enter agriculture filename: ");
    	String agricultureFileName= scanner.nextLine();
    	System.out.println(" Please enter construction filename: ");
    	String constructionFileName= scanner.nextLine();
    	province.storeData(agricultureFileName, constructionFileName);
    	System.out.println(" Done! Data has been stored in file ");
    	
    	
    
    	System.out.println("\n === TAKE AGRICULTURE INFORMATION FROM FILE ===");
        System.out.print(" Please enter filename: ");
        String agriFile = scanner.nextLine();
        Agriculture[] agricultureArray = province.TakeAgricultureInfoFromFile(agriFile);
        for (int i=0; i< agricultureArray.length ; i++) {
        	agricultureArray[i].Display();
        }
        
        
        
     
        System.out.println("\n === TAKE CONSTRUCTION INFORMATION FROM FILE ===");
        System.out.print(" Please enter filename: ");
        String constFile = scanner.nextLine();
        Agriculture[] constructionArray = province.TakeAgricultureInfoFromFile(constFile);
        for (int i=0; i< constructionArray.length ; i++) {
        	constructionArray[i].Display();
        }
        
        
     
    	System.out.println(" \n ===PRICE OF AGRICULTURE LAND BY ID ");
    	System.out.println(" Please enter filename: ");
    	String fileagriculture = scanner.nextLine();
    	scanner.nextLine();
    	System.out.println(" Please enter the land ID: ");
    	int agriID= scanner.nextInt();
    	scanner.nextLine();
    	double agriPrice= province.PriceOfAgricultureLandById(fileagriculture, agriID);
    	System.out.println(" Price of agriculture land by ID : "+ agriPrice );
    	
    	

    	System.out.println(" \n ===PRICE OF CONSTRUCTION LAND BY ID ");
    	System.out.println(" Please enter filename: ");
    	String fileconstruction = scanner.nextLine();
    	scanner.nextLine();
    	System.out.println(" Please enter the land ID: ");
    	int constID= scanner.nextInt();
    	scanner.nextLine();
    	double constPrice= province.PriceOfConstructionLandById(fileconstruction, constID);
    	System.out.println(" Price of construction  land by ID : "+ constPrice );
    
    	
 
    	System.out.println(" /n=== PRICE OF LAND BY ID ( IN MEMORY) ===");
    	System.out.println(" Please enter land ID: ");
    	int landID2= scanner.nextInt();
    	scanner.nextLine();
    	double memoryPrice= province.SecondMethodToFindPriceOfLandById(landID2);
    	System.out.println(memoryPrice >=0 ? " Price of land by ID ( in memory ) : "+ memoryPrice : " Sorry! Land by ID not found . Try again ");
    	
    	System.out.println(" Existing the system. Thank you foe filling out the form !");
    	
	}else if( option ==2 ) {

	int operation =-1;
	while (operation != 0) {
		
	System.out.println(" Operations Available:  ");
	System.out.println(" 0- EXIST");
	System.out.println(" 1- ADD  AGRICULTURE LAND ");
	System.out.println(" 2- ADD CONSTRUCTION LAND ");
	System.out.println(" 3- DELETE LAND ");
	System.out.println(" 4- SEARCH LAND BY ID ");
	System.out.println(" 5- DISPLAY ALL LAND ");
	System.out.println(" 6- COUNT AGRICULTURE LANDS ");
	System.out.println(" 7- COUNT CONSTRUCTION LANDS ");
	System.out.println(" 8- UPDATE LAND INFORMATION  ");
	System.out.println(" 9- MERGE TW0 LANDS ");
	System.out.println(" 10- SPLIT LANDS ");
	System.out.println(" 11- STORE DATA IN FILES");
	System.out.println(" 12- TAKE AGRICULTURE INFO FROM FILE");
	System.out.println(" 13- TAKE CONSTRUCTION INFO FROM FILE");
	System.out.println(" 14- PRICE OF AGRICULTURE LAND BY ID ");
	System.out.println(" 15- PRICE OF CONSTRUCTION LAND BY ID ");
	System.out.println(" 16- PRICE OF LAND BY ID (IN MEMORY )");
	
	
	System.out.println(" Please choose an operation(1-16): ");
	operation= scanner.nextInt();
	
	
	switch(operation) {
	case 0: 
		System.out.println(" Exiting the system .Thank you for filling the system .");
		break;
		
	case 1: 
		System.out.println(" \n === ADD AGRICULTURE LAND ===");
		Agriculture agriculture = new Agriculture();
		agriculture.ReadDetailsOfAgricultureLand();
		province.AddAnestheticLand(agriculture);
		System.out.println(" Added ID for agriculture land : "+ agriculture.getIdOfLand());
		break;
		
	case 2: 
		System.out.println(" \n === ADD CONSTRUCTION LAND ===");
		Construction construction = new Construction ();
		construction.ReadDetailsOfConstructionLand();
		province.AddAnestheticLand(construction);
		System.out.println(" Added ID for construction  land : "+ construction.getIdOfLand());
		break;
		
	case 3: 
		System.out.println(" \n === DELETE LAND ===");
		System.out.println(" Please enter the land ID to delete: ");
		int deleteID= scanner.nextInt();
		scanner.nextLine();
		if(province.DeleteAnestheticLand(deleteID)) {
			System.out.println(" Done! Land ID " + deleteID + " deleted. ");
		}else {
			System.out.println(" Sorry! Land ID"+ deleteID + " not found");
		}
	break;
	
	case 4 : 
		System.out.println(" \n === SEARCH LAND BY ID === ");
		System.out.println(" Please enter land ID to search :  ");
		int searchLandID= scanner.nextInt();
		scanner.nextLine();
		int sLandID= province.searchLandById(searchLandID);
		if(sLandID !=-1) {
			province.getL()[sLandID].Display();
		}else {
			System.out.println(" Sorry! Land ID "+ searchLandID + " not found .");
		}
		break;
		
	case 5 : 
		System.out.println(" \n ===DISPLAY ALL LANDS ===");
		province.displayAllLands();
		break;
		
	case 6: 
		System.out.println(" Number of Agriculture lands : "+ province.FindNumberOfAgricultureLands());
		break;
		
	case 7: 
		System.out.println(" Number of Construction lands : "+ province.FindNumberOfConstructionLands());
		break; 
		
	case 8: 
		System.out.println(" \n === UPDATE LAND INFOTMATION ===");
		System.out.println(" Please enter the land ID to update : ");
		int updateID= scanner.nextInt();
		scanner.nextLine();
		if(province.UpdateLandInformation(updateID)) {
			System.out.println(" Done! Land ID "+ updateID + " updated. ");
		}else {
			System.out.println(" Sorry! Land ID "+ updateID + " noy found ");
		}
		break;
		
	case 9: 
		System.out.println(" \n ===MERGE TWO LAND ===");
		System.out.println(" Please enter the first land ID : ");
		int land1= scanner.nextInt();
		System.out.println(" Please enter the second land ID : ");
		int land2= scanner.nextInt();
		scanner.nextLine();
		if(province.MergeTwoLands(land1, land2)) {
			System.out.println(" Lands are merged to ID : " + land1);
		}else { 
			System.out.println(" Sorry! Merging of two lands failed . Try again ");
		}
		break;
		
	case 10: 
		System.out.println("\n === SPLITING OF LANDS ===");
		System.out.print("Please enter the old land ID: ");
        int eLandID = scanner.nextInt();
        System.out.print(" Please enter new land ID: ");
        int newLandID = scanner.nextInt();
        System.out.print(" Please enter percentage to split: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine();
        if (province.SplitLand(eLandID, newLandID, percentage))
            System.out.println("Land split Done!New ID : " + newLandID );
        else
            System.out.println(" Sorry ! Split failed. Try again ");
        break;
        
    case 11:
    	System.out.println(" \n ===STORE DTA IN FILE ===");
    	System.out.println(" Please enter agriculture filename: ");
    	String agricultureFileName= scanner.nextLine();
    	System.out.println(" Please enter construction filename: ");
    	String constructionFileName= scanner.nextLine();
    	province.storeData(agricultureFileName, constructionFileName);
    	System.out.println(" Done! Data has been stored in file ");
    	break;
    	
    case 12: 
    	System.out.println("\n === TAKE AGRICULTURE INFORMATION FROM FILE ===");
        System.out.print(" Please enter filename: ");
        String agriFile = scanner.nextLine();
        Agriculture[] agricultureArray = province.TakeAgricultureInfoFromFile(agriFile);
        for (int i=0; i< agricultureArray.length ; i++) {
        	agricultureArray[i].Display();
        }
        break;
        
        
    case 13: 
        System.out.println("\n === TAKE CONSTRUCTION INFORMATION FROM FILE ===");
        System.out.print(" Please enter filename: ");
        String constFile = scanner.nextLine();
        Agriculture[] constructionArray = province.TakeAgricultureInfoFromFile(constFile);
        for (int i=0; i< constructionArray.length ; i++) {
        	constructionArray[i].Display();
        }
        break;
        
    case 14: 
    	System.out.println(" \n ===PRICE OF AGRICULTURE LAND BY ID ");
    	System.out.println(" Please enter filename: ");
    	String fileagriculture = scanner.nextLine();
    	scanner.nextLine();
    	System.out.println(" Please enter the land ID: ");
    	int agriID= scanner.nextInt();
    	scanner.nextLine();
    	double agriPrice= province.PriceOfAgricultureLandById(fileagriculture, agriID);
    	System.out.println(" Price of agriculture land by ID : "+ agriPrice );
    	break;
    	
    case 15: 
    	System.out.println(" \n ===PRICE OF CONSTRUCTION LAND BY ID ");
    	System.out.println(" Please enter filename: ");
    	String fileconstruction = scanner.nextLine();
    	scanner.nextLine();
    	System.out.println(" Please enter the land ID: ");
    	int constID= scanner.nextInt();
    	scanner.nextLine();
    	double constPrice= province.PriceOfConstructionLandById(fileconstruction, constID);
    	System.out.println(" Price of construction  land by ID : "+ constPrice );
    	break;
    	
    case 16: 
    	System.out.println(" /n=== PRICE OF LAND BY ID ( IN MEMORY) ===");
    	System.out.println(" Please enter land ID: ");
    	int landID2= scanner.nextInt();
    	scanner.nextLine();
    	double memoryPrice= province.SecondMethodToFindPriceOfLandById(landID2);
    	System.out.println(memoryPrice >=0 ? " Price of land by ID ( in memory ) : "+ memoryPrice : " Sorry! Land by ID not found . Try again ");
    	break;
    	
    	default:
    		System.out.println(" ERROR . you have entered an invalid choice . Please try again ");
	
	}
	}
	
	}else {
		System.out.println(" Sorry invalid choice .Please enter a number between (1-16) .");
	}
	
	scanner.close();
}
}


	
	
