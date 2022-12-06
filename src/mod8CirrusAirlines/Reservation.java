package mod8CirrusAirlines;

import java.time.LocalDate;

public class Reservation {
	private int id;
	private Customer cust;
	private LocalDate date;
	private String seat;
	
	private static int nextNum = 100;
	
	public Reservation() {
		id = nextNum;
		nextNum++;
	}
	
	public Reservation(Customer c, LocalDate d, String s) {
		id = nextNum;
		nextNum++;
		cust = c;
		date = d;
		seat = s;
	}

	@Override
	// Auto generated toString; change if needed - Eduardo 11/26
	public String toString() {
		return "Reservation [id=" + id + ", cust=" + cust + ", date=" + date + ", seat=" + seat + "]";
	}
	
	//Getters and setters - Eduardo 11/26
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
}
