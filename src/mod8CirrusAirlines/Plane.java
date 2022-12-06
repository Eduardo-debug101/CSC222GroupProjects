package mod8CirrusAirlines;

import java.time.LocalDate;

public class Plane {
	private Reservation[][] seats;
	private LocalDate date;
	
	public Plane() {
	}
	
	public Plane(Reservation[][] s, LocalDate d) {
		seats = s;
		date = d;
	}
	
	// remember to change this in the future - Eduardo 12/5
	public String toString() {
		return "";
	}

	public Reservation[][] getSeats() {
		return seats;
	}

	public void setSeats(Reservation[][] seats) {
		this.seats = seats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}


