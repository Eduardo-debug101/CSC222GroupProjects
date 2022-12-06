package mod8CirrusAirlines;

public class Plane {
	private Reservation[][] seats;
	
	public Plane() {
	}
	
	public Plane(Reservation[][] s) {
		seats = s;
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
}



