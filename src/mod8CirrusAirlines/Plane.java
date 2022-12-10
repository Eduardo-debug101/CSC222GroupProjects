package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Plane {
	private Reservation[][] seats = new Reservation[4][];
	private LocalDate flightDate;

	public Plane() {
	}

	public Plane(Reservation[][] seating, LocalDate flightDate) {
		this.flightDate = flightDate;
		seats = seating;
	}

	public Plane(LocalDate flightDate) {
		seats[0] = new Reservation[2];
		seats[1] = new Reservation[2];
		seats[2] = new Reservation[8];
		seats[3] = new Reservation[8];
		this.flightDate = flightDate;
	}
	
	public String toString() {
		return "Plane [seats=" + Arrays.toString(seats) + ", flightDate=" + flightDate + "]";
	}

	public ArrayList<String> toStringF() {
		ArrayList<String> seatInfo = new ArrayList<>();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];
				if (current != null)
					seatInfo.add(current.toStringF() + "|" + flightDate.getMonthValue() + "/"
							+ flightDate.getDayOfMonth() + "/" + flightDate.getYear());
			}
		}
		return seatInfo;
	}

	// remember to change this in the future - Eduardo 12/5

	public void printSomeSeating() {
		System.out.println("The following seats are open.");
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				char colLetter = (char) (col + 65);
				String prefix = colLetter + "" + (row + 1);

				if (row == 0 || row == 1) {
					if (col == 0) {
						if (current == null) {
							System.out.print(prefix + " ");
						}
					} else {
						prefix = "H" + "" + (row + 1);
						if (current == null) {
							System.out.print(prefix + " ");
						}
					}

				} else {
					if (current == null) {
						System.out.print(prefix + " ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printAllPlaneSeating() {
		System.out.println(
				"Here are the seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
		System.out.println();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				char colLetter = (char) (col + 65);
				String prefix = colLetter + "" + (row + 1) + "-";

				if (row == 0 || row == 1) {
					if (col == 0) {
						if (current == null) {
							System.out.print(prefix + "000" + "                                                  ");
						} else {
							System.out.print(prefix + current.getCust().getId()
									+ "                                                  ");
						}
					} else {
						prefix = "H" + "" + (row + 1) + "-";
						if (current == null) {
							System.out.print(prefix + "000" + "  ");
						} else {
							System.out.print(prefix + current.getCust().getId() + "  ");
						}
					}

				} else {

					if (seats[row][col] == null) {
						System.out.print(prefix + "000" + "  ");
					} else {
						System.out.print(prefix + current.getCust().getId() + "  ");

					}

				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printFirstClassSeating() {
		System.out.println(
				"Here are the first class seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
		System.out.println();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				if (row == 0 || row == 1) {
					if (col == 0 || col == 1) {
						char colLetter = (char) (col + 65);
						String prefix = colLetter + "" + (row + 1) + "-";
						if (col == 1) {
							prefix = 'H' + "" + (row + 1) + "-";
						}
						if (current == null) {
							System.out.print(prefix + "000" + "  ");
							if (col == 0) {
								System.out.print("AISLE  ");
							}

						} else {
							System.out.print(prefix + current.getCust().getId() + "  ");
							if (col == 0) {
								System.out.print("AISLE  ");
							}
						}
					}
				}
			}
			System.out.println();
		}
	}

	public void printEcoWindowSeats() {
		System.out.println(
				"Here are the economy window seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
		System.out.println();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				if (row > 1) {
					if (col == 0 || col == 7) {
						char colLetter = (char) (col + 65);
						String prefix = colLetter + "" + (row + 1) + "-";
						if (current == null) {
							System.out.print(prefix + "000" + "  ");
							if (col == 0) {
								System.out.print("AISLE  ");
							}

						} else {
							System.out.print(prefix + current.getCust().getId() + "  ");
							if (col == 0) {
								System.out.print("AISLE  ");
							}
						}
					}
				}
			}
			System.out.println();
		}
	}

	public void printEcoAisleSeats() {
		System.out.println(
				"Here are the economy aisle seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
		System.out.println();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				if (row > 1) {
					if (col == 3 || col == 4) {
						char colLetter = (char) (col + 65);
						String prefix = colLetter + "" + (row + 1) + "-";
						if (current == null) {
							System.out.print(prefix + "000" + "  ");
							if (col == 3) {
								System.out.print("AISLE  ");
							}

						} else {
							System.out.print(prefix + current.getCust().getId() + "  ");
							if (col == 3) {
								System.out.print("AISLE  ");
							}
						}
					}
				}
			}
			System.out.println();
		}
	}

	public void printEcoNormalSeats() {
		System.out.println(
				"Here are the economy normal seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
		System.out.println();
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Reservation current = seats[row][col];

				if (row > 1) {
					if (col != 0 && col != 3 && col != 4 && col != 7) {
						char colLetter = (char) (col + 65);
						String prefix = colLetter + "" + (row + 1) + "-";
						if (current == null) {
							System.out.print(prefix + "000" + "  ");
						} else {
							System.out.print(prefix + current.getCust().getId() + "  ");
						}
					}
				}
			}
			System.out.println();
		}
	}

	public Reservation[][] getSeats() {
		return seats;
	}

	public void setSeats(Reservation[][] seats) {
		this.seats = seats;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

}
