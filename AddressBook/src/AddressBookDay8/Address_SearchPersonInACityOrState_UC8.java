



package AddressBookDay8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Address_SearchPersonInACityOrState_UC8 {
	
	private static Map<String,ArrayList<Initialization>> bookList = new HashMap<String,ArrayList<Initialization>>();
	private static Map<String,ArrayList<String>> cityList = new HashMap<String,ArrayList<String>>();
	
	private static Map<String,ArrayList<String>> stateList = new HashMap<String,ArrayList<String>>();
	static ArrayList<Initialization> contactDetailsCity = new ArrayList<Initialization>(); 
	static ArrayList<Initialization> contactDetailsState = new ArrayList<Initialization>(); 
	
	private static Initialization getInitialContactDetails() {
		System.out.println("enter contact details ----");

		Scanner scan = new Scanner(System.in);

		System.out.println("enter first name");
		String firstName = scan.nextLine();

		System.out.println("enter last name");
		String lastName = scan.nextLine();

		System.out.println("enter street address");
		String address = scan.nextLine();

		System.out.println("enter city name");
		String cityName = scan.nextLine();

		System.out.println("enter state name");
		String stateName = scan.nextLine();
		System.out.println("enter phone number");
		String phoneNumber = scan.nextLine();

		System.out.println("enter email Address");
		String emailAddress = scan.nextLine();

		System.out.println("enter zip code of address -- interger type");
		int zipCode = scan.nextInt();

		Initialization entry = new Initialization(firstName, lastName, address, cityName, stateName, zipCode,
				phoneNumber, emailAddress);
		return entry;

	}
	
	private static  void getAddressBook() {
		// TODO Auto-generated method stub
	
		
		ArrayList<Initialization> contactDetails = new ArrayList<Initialization>();
		Map<String,ArrayList<Initialization>> bookListLocal = new HashMap<String,ArrayList<Initialization>>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter address book name");
		String bookname = scan.nextLine();
		while(true)
		{
		System.out.println("enter 1 to add more contact");
		   System.out.println("enter 2 to exit ");
		  int option = scan.nextInt();
		  if(option==1)
		  {
			  Initialization contactEntry = getInitialContactDetails();
			  contactDetails.add(contactEntry);
		  }
		  else
		  {
			  break;
		  }
		 		   
		}
		bookList.put(bookname,contactDetails);
		
		
	}
	
	private static Map<String,ArrayList<String>> getPersonsCityWise() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<String> personNames = new ArrayList<String>();

		System.out.println("enter the city name");
		String cityName = scan.nextLine();
		for (String i :bookList.keySet())
		{
           
           contactDetailsCity = bookList.get(i);
           
           for(int j=0;j<contactDetailsCity.size();j++)
           {
        	  Initialization initial = contactDetailsCity.get(j); 
        	  if(initial.addressCity.equals(cityName))
        	  {
        	      personNames.add(initial.firstName+" "+initial.lastName);
        	  }
        		  
           }
           
			
		}

		cityList.put(cityName, personNames);
		return cityList;
		
	}

	
	private static Map<String,ArrayList<String>> getPersonsStateWise() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<String> personNames = new ArrayList<String>();

		System.out.println("enter the state name");
		String stateName = scan.nextLine();
		for (String i :bookList.keySet())
		{
           
           contactDetailsState = bookList.get(i);
           
           for(int j=0;j<contactDetailsState.size();j++)
           {
        	  Initialization initial = contactDetailsState.get(j); 
        	  if(initial.addressCity.equals(stateName))
        	  {
        	      personNames.add(initial.firstName+" "+initial.lastName);
        	  }
        		  
           }
           
			
		}

		cityList.put(stateName, personNames);
		return cityList;
		
	}

	


	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		System.out.println("this is address book program");
		
		while(true)
		{
		   System.out.println("enter 1 to add more address books");
		   System.out.println("enter 2 to exit from address book program");
		   int option = scn.nextInt();
		   if(option==1)
		   {
			   getAddressBook();
			 			   
		   }
		   else
		   {
			   break;
		   }
		}
		
		
		 System.out.println("address books and contact details added successfully ");
		 
		 System.out.println("enter 1 to search person by city");
		 System.out.println("enter 2 to search person by state");
		 int searchoption = scn.nextInt();
		 
		 if (searchoption == 1)
		 {
			cityList= getPersonsCityWise();
			for (String i :cityList.keySet())
			{
			
				System.out.println("city Name is : "+ i );
				System.out.println("persons in the city are ");
				ArrayList<String> persons = cityList.get(i);
				for(int y=0;y<persons.size();y++)
				{
					System.out.println(persons.get(y));
				}
				
			}
			
			
		 }
		 
		  else if (searchoption==2)
		 {
			 stateList = getPersonsStateWise();
		 for (String i :stateList.keySet())
			{
				
				System.out.println("state Name is : "+ i );
				System.out.println("persons in the state are ");
				ArrayList<String> persons = stateList.get(i);
				for(int y=0;y<persons.size();y++)
				{
					System.out.println(persons.get(y));
				}
				
			}	}
		 else
		 {
			 System.out.println("Wrong input");
		 }

		 
		

	}

	
		

}

