package mod8CirrusAirlines;

public class Reservation {
    private Customer cust;
    private String seat;

    public Reservation() {
    }

    public Reservation(Customer c, String s) {
        cust = c;
        seat = s;
    }
    
	public String toString() {
		return "Reservation [cust=" + cust + ", seat=" + seat + "]";
	}

	public String toStringF(){
        return cust.toStringF() + "|" + seat;
    }

    //Getters and setters - Eduardo 11/26

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
