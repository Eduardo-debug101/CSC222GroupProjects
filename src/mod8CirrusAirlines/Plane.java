package mod8CirrusAirlines;

import java.time.LocalDate;

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
	    // Tweaked it more today. Should be mostly accurate. - Eduardo 12/8
	    public void printArray() {
	        System.out.println("Here are the seats in this plane. O's mean available and the numbers represent customer's ids.");
	        for (int row = 0; row < 2; row++) {
	            for (int col = 0; col < seats[0].length; col++) {
	                if (seats[row][col] == null) {
	                    System.out.print("O" + "\t\t\t    ");
	                } else {
	                    System.out.print(seats[row][col].getCust().getId() + "\t\t\t    ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();

	        for (int row = 2; row < 4; row++) {
	            for (int col = 0; col < seats[2].length; col++) {
	                if (seats[row][col] == null) {
	                    System.out.print("O" + "   ");
	                } else {
	                    System.out.print(seats[row][col].getCust().getId() + " ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    public void printPlaneSeating() {
	        System.out.println("Here are the seats in this plane. O's mean available and the numbers represent customer's ids:");
	        System.out.println();
	        for (int row = 0; row < seats.length; row++) {
	            for (int col = 0; col < seats[row].length; col++)
	                if((row == 0 || row == 1) && col == 0){
	                    if(seats[row][col] == null){
	                        System.out.print("000" + "                                ");
	                    }else{
	                        System.out.print(seats[row][col].getCust().getId() + "                                ");

	                    }
	                }else{
	                    if(seats[row][col] == null){
	                        System.out.print("000" + "  ");
	                    }else{
	                        System.out.print(seats[row][col].getCust().getId() + "  ");

	                    }
	                }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    //    0      1      2      3      4      5      6      7
	// ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐
	// │      │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │      │0
	// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
	// │      │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │      │1
	// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
	// │      │      │      │      │      │      │      │      │2
	// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
	// │      │      │      │      │      │      │      │      │3
	// └──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┘
//	                           AISLE

	    public Reservation[][] getSeats() {
	        return seats;
	    }

	    public void setSeats(Reservation[][] seats) {
	        this.seats = seats;
	    }
	}