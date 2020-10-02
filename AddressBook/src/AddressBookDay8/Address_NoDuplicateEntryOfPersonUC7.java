package AddressBookDay8;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;


public class Address_NoDuplicateEntryOfPersonUC7 {

	// HASHMAP created to store contact details
	private ArrayList<Initialization> contactArrayList = new ArrayList<>();
		private Map<String,Initialization> contactList = new HashMap<String,Initialization>();
		private static Map<String,Address_NoDuplicateEntryOfPersonUC7> bookList = new HashMap<String,Address_NoDuplicateEntryOfPersonUC7>();
		
	

		// method to take input of contact details
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
		// method to add contact details in linked list

		private void addContact(Initialization contact) {
			contactList.put(contact.firstName+" "+contact.lastName,contact);
			System.out.println("contact added whose name is :  " + contact.firstName + " " + contact.lastName);

		}
		// method to display all entries of arraylist

		private void displayContactDetails(Initialization con) {
			
				System.out.println("");
				System.out.println("contact details ");
				
				System.out.println("first name is :" + con.firstName);
				System.out.println(" last name is :" + con.lastName);

				System.out.println(" address is :" + con.address);

				System.out.println(" city name is :" + con.addressCity);

				System.out.println(" state name is :" + con.addressState);

				System.out.println(" zip code is  :" + con.addresszip);

				System.out.println(" phone number is :" + con.phoneNumber);

				System.out.println(" email address is :" + con.email);
			}
			
		
		private static void printAllAddressBooks() {
			Scanner scan =  new Scanner(System.in);
			ArrayList<String> keyNames =new  ArrayList<String>();

		for (String i :bookList.keySet())
		{
           keyNames.add(i);
			
		}
		for(int j=0;j<keyNames.size();j++)
		{
			String bName = keyNames.get(j);
			bookList.get(keyNames.get(j)).printAddressBook();

						}
		}

			
		private void printAddressBook() {
			// TODO Auto-generated method stub
		     for (String i :bookList.keySet())
			{
	          System.out.println("book name is : "+i);
	          for(int j=0;j<contactArrayList.size();j++)
			     {
			    	 displayContactDetails(contactArrayList.get(j));
			     }
	          
	          
				
			}
		     
		     for(int j=0;j<contactArrayList.size();j++)
		     {
		    	 displayContactDetails(contactArrayList.get(j));
		     }
			
		}
		private static Address_NoDuplicateEntryOfPersonUC7 getAddressBook()
		{
			Address_NoDuplicateEntryOfPersonUC7 bookEntry = new Address_NoDuplicateEntryOfPersonUC7();
			Scanner scan =  new Scanner(System.in);
			System.out.println("Enter address book unique");
			String bookName = scan.nextLine();
			bookList.put(bookName,bookEntry);
			return bookEntry;
			
		}
		private boolean duplicateExists(Initialization initialContactDetails) {
			// TODO Auto-generated method stub
			String fName = initialContactDetails.getFirstName(), lName = initialContactDetails.getLastName();
			List<Object> duplicate = contactArrayList.stream().filter(cd -> (cd.getFirstName().equals(fName) && cd.getLastName().equals(lName))).collect(Collectors.toList());
			if(duplicate.size()!=0)
			{
				System.out.println("Contact with this name already exists, not added");
				return true;
			}
			else
			{
			return false;
			}
		}

		
		private void addContactDetails(Initialization initialContactDetails) {
			// TODO Auto-generated method stub
			
			if(this.duplicateExists(initialContactDetails)==true)
			{
				return;
			}
			else
			{
			contactArrayList.add(initialContactDetails);
			contactList.put(initialContactDetails.firstName+" "+initialContactDetails.lastName, initialContactDetails);
			}
		}

		
		private static void getAddressBookContactDetails() {
			// TODO Auto-generated method stub
			Scanner scan =  new Scanner(System.in);
			ArrayList<String> keyNames =new  ArrayList<String>();

		for (String i :bookList.keySet())
		{
           keyNames.add(i);
			
		}
		
		for(int j=0;j<keyNames.size();j++)
		{
			String bName = keyNames.get(j);
			while(true) {
				System.out.println("Select "
						+ "\n1. Adding contact details"
						+ "\n2. Exit"
						+ "\n to the addressbook : " + keyNames.get(j));

				int addContact = scan.nextInt();
				scan.nextLine();
				if( addContact == 2 )
				{
					break;
				}
				else
				{
			bookList.get(keyNames.get(j)).addContactDetails(getInitialContactDetails());
				}
			}
		}
			
			
		}


				// main method
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			
			System.out.println("this is address book program");
			
			while(true)
			{
			   System.out.println("enter 1 to add more address books");
			   System.out.println("enter 2 to exit from address book program");
			   int option = scn.nextInt();
			   if(option==1)
			   {
				  Address_NoDuplicateEntryOfPersonUC7 bookEntry = getAddressBook(); 
			   }
			   else
			   {
				   break;
			   }
			}
			
			  getAddressBookContactDetails();
			  printAllAddressBooks();
			  
			
			
			 
			 

									
					
					}
			}

