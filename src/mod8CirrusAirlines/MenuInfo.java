package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MenuInfo {
	
	
	
	public ArrayList<Customer> loadData() {
		ArrayList<Customer> cust = new ArrayList<Customer>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Customer's first name?");
		String first = scan.nextLine();
		System.out.println("Customer's last name?");
		String last = scan.nextLine();
		
		Customer custFav = new Customer(first, last);
		System.out.println("Congrats, you have successfully added a customer into our database!");
		return cust;
	}


}
