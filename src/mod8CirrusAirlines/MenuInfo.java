package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MenuInfo {

	// Creates a customer object and is added to an arraylist in main driver -
	// Eduardo 12/5
	public ArrayList<Customer> loadData() {
		ArrayList<Customer> cust = new ArrayList<Customer>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Customer's first name?");
		String first = scan.nextLine();
		System.out.println("Customer's last name?");
		String last = scan.nextLine();

		Customer custFav = new Customer(first, last);
		cust.add(custFav);
		System.out.println("Congrats, you have successfully added a customer into our database!");
		System.out.println("Your id number is " + cust.get(cust.size()-1).getId() + ".");
		return cust;
	}

	// Creates a reservation object for new or current customers - Eduardo 12/5
	public void createReservations(ArrayList<Customer> c) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Current or new customer?");
		String status = scan.nextLine();
		if (status.equalsIgnoreCase("Current")) {
			System.out.println("Do you know your ID#? (yes/no)");
			String idKnown = scan.nextLine();
			if (idKnown.equalsIgnoreCase("yes")) {
				System.out.println("What is your ID number?");
				int idNum = scan.nextInt();
				boolean flag = false;
				for (int i = 0; i < c.size(); i++) {
					if (idNum == c.get(i).getId()) {
						flag = true;
						System.out.println("Id found.");
					}
				}
				
				if (flag == false) {
					System.out.println("Customer not found. Try again.");
				}
				
			} else if (idKnown.equalsIgnoreCase("no")) {
				System.out.println("Customer's first name?");
				String first = scan.nextLine();
				System.out.println("Customer's last name?");
				String last = scan.nextLine();
				if (c.contains(first) && c.contains(last)) {

				}
			} else {
				System.out.println("Customer not found. Try again.");
			}

		} else if (status.equalsIgnoreCase("New")) {
			c = loadData();

		} else {
			System.out.println("Input unacceptable. Try again.");
		}
	}

}
