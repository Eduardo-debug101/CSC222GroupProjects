package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MenuInfo {

	public void loadPresetData(ArrayList<Customer> c, Reservation[][] s) {
		Customer cust1 = new Customer("Christina", "Hart");
		Customer cust2 = new Customer("Rosario", "Barrett");
		Customer cust3 = new Customer("Christine", "Mckinney");
		Customer cust4 = new Customer("Gus", "Carter");
		Customer cust5 = new Customer("Ward", "Cook");
		Reservation resv1 = new Reservation(cust1, LocalDate.of(2022, 12, 1), "B1");
		Reservation resv2 = new Reservation(cust2, LocalDate.of(2022, 12, 1), "D3");
		Reservation resv3 = new Reservation(cust3, LocalDate.of(2022, 12, 2), "B1");
		Reservation resv4 = new Reservation(cust4, LocalDate.of(2022, 12, 3), "A1");
		Reservation resv5 = new Reservation(cust5, LocalDate.of(2022, 12, 3), "G4");
		int num1 = columnNum(resv1.getSeat());
		int num2 = columnNum(resv2.getSeat());
		int num3 = columnNum(resv3.getSeat());
		int num4 = columnNum(resv4.getSeat());
		int num5 = columnNum(resv5.getSeat());
		// We need to find a way to get the second num in the seat code Ex) B1 ---> 1 - Eduardo 12/6
		c.add(cust1);
		c.add(cust2);
		c.add(cust3);
		c.add(cust4);
		c.add(cust5);
//		s[num1][num1b] = resv1;
//		s[num2][num2b] = resv2;
//		s[num3][num3b] = resv3;
//		s[num4][num4b] = resv4;
//		s[num5][num5b] = resv5;
	}

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
		System.out.println("Your id number is " + cust.get(cust.size() - 1).getId() + ".");
		return cust;
	}

	// Creates a reservation object for new or current customers - Eduardo 12/5
	public void createReservations(ArrayList<Customer> c) {
		Scanner scan = new Scanner(System.in);
		// Creates ragged array of reservation objects - Eduardo 12/5
		// Might need tweaking for more accuracy
		Reservation[][] seats = new Reservation[4][];
		// Creates columns for each row. Aisle is not included. - Eduardo 12/5
		seats[0] = new Reservation[2];
		seats[1] = new Reservation[2];
		seats[2] = new Reservation[4];
		seats[3] = new Reservation[4];
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
				} else if (flag == true) {
					// Insert print 2d array

				} else {
					System.out.println("Input unacceptable. Try again.");
				}

			} else if (idKnown.equalsIgnoreCase("no")) {
				System.out.println("Customer's first name?");
				String first = scan.nextLine();
				System.out.println("Customer's last name?");
				String last = scan.nextLine();
				if (c.contains(first) && c.contains(last)) {
					// Insert print 2d array

				}
			} else {
				System.out.println("Customer not found. Try again.");
			}

		} else if (status.equalsIgnoreCase("New")) {
			c = loadData();
			// Insert print 2d array

		} else {
			System.out.println("Input unacceptable. Try again.");
		}
	}

	// This method will turn the first letters into number. Ex) A=1, B=2, C=3... -
	// Eduardo 12/6
	public int columnNum(String input) {
		String temp = input.toLowerCase();
		char ch = temp.charAt(0);
		int position = ch - 'a' + 1;
		return position;
	}
	
		
}