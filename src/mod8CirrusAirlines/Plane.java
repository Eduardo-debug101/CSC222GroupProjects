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
	// Need some work. Should handle rows with different columns numbers. - Eduardo 12/7
	public void printArray() {
		System.out.println("Here are the seats in this plane. X's means reserved and O's mean available.");
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < seats[0].length; col++)
				if (seats[0][col] == null || seats[1][col] == null) {
					System.out.print("O" + "   ");
				} 
//				else if (seats[2][col] == null || seats[3][col] == null) {
//					System.out.print("O" + "   ");
//				}
				else {
					System.out.print(seats[row][col].getSeat());
				}
			System.out.println();
		}
		System.out.println();
		
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < seats[2].length; col++)
				if (seats[2][col] == null || seats[3][col] == null) {
					System.out.print("O" + "   ");
				}
				else {
					System.out.print(seats[row][col].getSeat());
				}
			System.out.println();
		}
		System.out.println();
	}

	public Reservation[][] getSeats() {
		return seats;
	}

	public void setSeats(Reservation[][] seats) {
		this.seats = seats;
	}
}
