package mod8CirrusAirlines;

public class Reservation {
    private int id;
    private Customer cust;
    private String seat;

    private static int nextNum = 100;

    public Reservation() {
        id = nextNum;
        nextNum++;
    }

    public Reservation(Customer c, String s) {
        id = nextNum;
        nextNum++;
        cust = c;
        seat = s;
    }

    public Reservation(Customer c, String s, int i) {
        cust = c;
        seat = s;
        id = i;
    }

    public String toStringF(){
        return cust.toStringF() + "|" + id + "|" + seat;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
