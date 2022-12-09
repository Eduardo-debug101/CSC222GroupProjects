package mod8CirrusAirlines;

import java.util.ArrayList;
import java.util.Scanner;

public class CirrusDriver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Customer> cust = new ArrayList<Customer>();
		Reservation[][] seats = new Reservation[4][];
		seats[0] = new Reservation[2];
		seats[1] = new Reservation[2];
		seats[2] = new Reservation[8];
		seats[3] = new Reservation[8];
		MenuInfo mi = new MenuInfo();
		
		int ans = 0;
		while (true) {
				menu();

				System.out.println("CHOICE:");
				ans = scan.nextInt();
				
				if (ans == 0) {
					mi.loadPresetData(cust, seats);
					System.out.println("Data was successfully loaded!");
				}
					
				else if (ans == 1) 
					cust = mi.loadData();	
				
				else if (ans == 2) {
					mi.createReservations(cust,seats);
				}
					
				else if (ans == 3) {

			        }
				
					
				else if (ans == 4) {
					//Added bones of printing the available seats.  Still under development.
					//We will want to build a way of showing a different array for each date. -CH
					mi.printSeats(seats);
					
				}
				
				// We need a custom method here. Save this for last. - Eduardo 11/26
				else if(ans == 5) {
					System.out.println("Coming soon! :)");
				}
								
				else if (ans == 6) {
					System.out.println("See you later!");
					System.exit(0);
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
		// Print a unique message once this part is finished - Eduardo 11/26
		System.out.println("5.  Unknown");
		System.out.println("6.  Exit\n");
	}

}
