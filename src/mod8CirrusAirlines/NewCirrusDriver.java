package mod8CirrusAirlines;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewCirrusDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<NewPlane> planesList = new ArrayList<>();
		NewMenuInfo mi = new NewMenuInfo();
		boolean dataLoaded = false;
		int ans = 0;
		while (true) {
			try {
				menu();
				System.out.println("CHOICE:");
				ans = scan.nextInt();

				switch (ans) {
				case 0:
					mi.loadPresetData(cust, planesList);
					System.out.println("Data was successfully loaded!");
					dataLoaded = true;
					break;
				case 1:
					if (dataLoaded) {
						cust.add(mi.createCustomer());
					} else {
						System.out.println("You must load some data first.");
					}
					break;
				case 2:
					if (dataLoaded) {
						mi.createReservation(cust, planesList);
					} else {
						System.out.println("You must load some data first.");
					}
					break;
				case 3:
					if (dataLoaded) {
						mi.openSeats(planesList);
					} else {
						System.out.println("You must load some data first.");
					}
					break;
				case 4:
					if (dataLoaded) {
						System.out.println("Which date are you inquiring about?  "
								+ "Type 1 for 12/1/2022, 2 for 12/2/2022, or 3 for 12/3/2022.");
						int resDate = scan.nextInt();

						if (resDate >= 1 && resDate <= 3) { // Date is valid
							NewPlane currentPlane = planesList.get(resDate - 1);
							currentPlane.printAllPlaneSeating();
						}
					} else {
						System.out.println("You must load some data first.");
					}
					break;
				case 5:
					if (dataLoaded) {
						mi.cancelReservation(cust, planesList);
					} else {
						System.out.println("You must load some data first.");
					}
					break;
				case 6:
					mi.saveFile(planesList);
					break;
				case 7:
					cust = mi.readText(planesList);
					dataLoaded = true;
					break;
				case 8:
					System.out.println("See you later!");
					System.exit(0);
				default:
					throw new Exception();
				}
			} 
			catch (Exception ex) {
				scan.nextLine();
				System.err.println("\nException: " + ex);
				System.out.println("The input must be integers between 0 and 8. Try again.\n");	
			}
		}
	}

	public static void menu() {
		System.out.println("\nCircus Airlines");
		System.out.println("\n0.  Load preset data.");
		System.out.println("1.  Add new customer.");
		System.out.println("2.  Create a reservation.");
		System.out.println("3.  Print seats available.");
		System.out.println("4.  Show plane loading.");
		System.out.println("5.  Extra: Cancel a reservation.");
		System.out.println("6.  Save plane data.");
		System.out.println("7.  Load plane data.");
		System.out.println("8.  Exit.\n");
	}

}
