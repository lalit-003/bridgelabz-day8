package AddressBookDay8;

import java.util.ArrayList;
import java.util.LinkedList;

public class Address_CreateContactBook_UC1 {

	// linked list created

	private LinkedList<Initialization> membertacts = new LinkedList<>();

	// method to add member details in Linkedlist

	public void addmembertactDetails(String firstName, String lastName,String address, String addressCity, String addressState,
			int addresszip, String phoneNumber, String email) {
		Initialization member = new Initialization(firstName, lastName,address, addressCity, addressState, addresszip,
				phoneNumber, email);
		membertacts.add(member);
		System.out.println("Hurray ! member added");
         display(member);
	}
	// method  to display details of member book entries

	public void display(Initialization member) {
		System.out.println("first name is :" + member.firstName);
		System.out.println(" last name is :" + member.lastName);
		
		System.out.println(" address is :" + member.address);


		System.out.println(" city name is :" + member.addressCity);

		System.out.println(" state name is :" + member.addressState);

		System.out.println(" zip code is  :" + member.addresszip);

		System.out.println(" phone number is :" + member.phoneNumber);

		System.out.println(" email address is :" + member.email);


	}

// main function
	public static void main(String[] args) {

		Address_CreateContactBook_UC1 entry1 = new Address_CreateContactBook_UC1();

		// entries of new member 
		entry1.addmembertactDetails("sumit", "phogat","H.NO. 26", "makarani", "haryana", 124367, "9087654590", "sumit@abc");
		// printing out details of member added
		

	}
}
