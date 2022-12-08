package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MenuInfo {

	public void loadPresetData(ArrayList<Customer> custList, Reservation[][] reservList) {
		Customer cust1 = new Customer("Christina", "Hart");
		Customer cust2 = new Customer("Rosario", "Barrett");
		Customer cust3 = new Customer("Christine", "Mckinney");
		Customer cust4 = new Customer("Gus", "Carter");
		Customer cust5 = new Customer("Ward", "Cook");

		Reservation resv1 = new Reservation(cust1, LocalDate.of(2022, 12, 1), "B1");
		Reservation resv2 = new Reservation(cust2, LocalDate.of(2022, 12, 1), "D3");
		Reservation resv3 = new Reservation(cust3, LocalDate.of(2022, 12, 2), "B1");
		Reservation resv4 = new Reservation(cust4, LocalDate.of(2022, 12, 3), "A1");
		Reservation resv5 = new Reservation(cust5, LocalDate.of(2022, 12, 3), "D4");

		int num1Col = columnNum(resv1.getSeat());
		int num1Row = rowNum(resv1.getSeat());

		int num2Col = columnNum(resv2.getSeat());
		int num2Row = rowNum(resv2.getSeat());

		int num3Col = columnNum(resv3.getSeat());
		int num3Row = rowNum(resv3.getSeat());

		int num4Col = columnNum(resv4.getSeat());
		int num4Row = rowNum(resv4.getSeat());

		int num5Col = columnNum(resv5.getSeat());
		int num5Row = rowNum(resv5.getSeat());

		// We need to find a way to get the second num in the seat code Ex) B1 ---> 1 -
		// Eduardo 12/6
		custList.add(cust1);
		custList.add(cust2);
		custList.add(cust3);
		custList.add(cust4);
		custList.add(cust5);

		reservList[num1Row - 1][num1Col - 1] = resv1;
		reservList[num2Row - 1][num2Col - 1] = resv2;
		reservList[num3Row - 1][num3Col - 1] = resv3;
		reservList[num4Row - 1][num4Col - 1] = resv4;
		reservList[num5Row - 1][num5Col - 1] = resv5;
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
		// Changed cust.get(cust.size() - 1).getId() to custFav.getID() as a new ID is
		// created for that customer when it is initialized - BW
		System.out.println("Your id number is " + custFav.getId() + ".");
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

	public int rowNum(String in) {
		String rowString = "" + in.charAt(1);
		int row = (int) Integer.parseInt(rowString);
		return row;
	}

	// This method will print the number of seats that are available. - Eduardo 12/7
	public void printSeats(Reservation[][] s) {
		Scanner scan = new Scanner(System.in);

		System.out.println(
				"Which date are you inquiring about?  " + "Type 1 for 12/1/2022, 2 for 12/2/2022, or 3 for 12/3/2022.");

		int resDate = scan.nextInt();

		Plane p = new Plane(s);
		p.printArray();
		
}
}