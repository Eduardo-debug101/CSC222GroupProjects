package mod8CirrusAirlines;

public class Customer {
	private String first;
	private String last;
	private int id;
	
	private static int nextNum = 100;
	
	public Customer() {
		id = nextNum;
		nextNum++;
	}
	
	
	public Customer(String f, String l) {
		id = nextNum;
		nextNum++;
		first = f;
		last = l;
	}

	public Customer(String f, String l, int i) {
		first = f;
		last = l;
		id = i;
	}

	@Override
	// Auto generated toString; change if needed - Eduardo 11/26
	public String toString() {
		return "Customer [first=" + first + ", last=" + last + ", id=" + id + "]";
	}


	public String toStringF(){
		return first + "|" + last + "|" + id;
	}

	//Getters and setters - Eduardo 11/26
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

