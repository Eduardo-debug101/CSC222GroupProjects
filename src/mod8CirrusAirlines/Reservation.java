package mod8CirrusAirlines;

import java.time.LocalDate;

public class Reservation {
	private int id;
	private String name;
	private LocalDate date;
	
	public Reservation() {
	}
	
	public Reservation(int i, String n, LocalDate d) {
		id = i;
		name = n;
		date = d;
	}

	@Override
	// Auto generated toString; change if needed - Eduardo 11/26
	public String toString() {
		return "Reservation [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	//Getters and setters - Eduardo 11/26
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
