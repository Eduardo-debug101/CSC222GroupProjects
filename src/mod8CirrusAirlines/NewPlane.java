package mod8CirrusAirlines;

import java.time.LocalDate;
import java.util.ArrayList;

public class NewPlane {
    private NewReservation[][] seats = new NewReservation[4][];
    private LocalDate flightDate;

    public NewPlane() {
    }

    public NewPlane(NewReservation[][] seating, LocalDate flightDate) {
        this.flightDate = flightDate;
        seats = seating;
    }

    public NewPlane(LocalDate flightDate) {
        seats[0] = new NewReservation[2];
        seats[1] = new NewReservation[2];
        seats[2] = new NewReservation[8];
        seats[3] = new NewReservation[8];
        this.flightDate = flightDate;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    // remember to change this in the future - Eduardo 12/5
    public String toString() {
        return "";
    }

    public ArrayList<String> toStringF() {
        ArrayList<String> seatInfo = new ArrayList<>();
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col] != null)
                    seatInfo.add(seats[row][col].toStringF() + "|" + flightDate.getMonthValue() + "/"
                            + flightDate.getDayOfMonth() + "/" + flightDate.getYear());
            }
        }
        return seatInfo;
    }

    public void printAllPlaneSeating() {
        System.out.println("Here are the seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
        System.out.println();
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {

                char colLetter = (char) (col + 65);
                String prefix = colLetter + "" + (row + 1) + "-";

                if (row == 0 || row == 1) {
                    if (col == 0) {
                        if (seats[row][col] == null) {
                            System.out.print(prefix + "000" + "                                                  ");
                        } else {
                            System.out.print(prefix + seats[row][col].getCust().getId() + "                                                  ");
                        }
                    } else {
                        prefix = "H" + "" + (row + 1) + "-";
                        if (seats[row][col] == null) {
                            System.out.print(prefix + "000" + "  ");
                        } else {
                            System.out.print(prefix + seats[row][col].getCust().getId() + "  ");
                        }
                    }

                } else {

                    if (seats[row][col] == null) {
                        System.out.print(prefix + "000" + "  ");
                    } else {
                        System.out.print(prefix + seats[row][col].getCust().getId() + "  ");

                    }

                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printFirstClassSeating() {
        System.out.println("Here are the first class seats in this plane. First 2 letters are the seating ID, and the next 3 are the customer ID. 000 ID seats are open seats:");
        System.out.println();
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {

                if (row == 0 || row == 1) {
                    if (col == 0 || col == 1) {
                        char colLetter = (char) (col + 65);
                        String prefix = colLetter + "" + (row + 1) + "-";

                        if (seats[row][col] == null) {
                            System.out.print(prefix + "000" + "  ");
                            if (col == 0) {
                                System.out.print("AISLE  ");
                            }

                        } else {
                            System.out.print(prefix + seats[row][col].getCust().getId() + "  ");
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

    public boolean isWindowSeat(int row, int col) {

        if (row == 0 || row == 1) {
            if (col == 0 || col == 1) {
                return true;
            }
        } else {
            if (col == 7) {
                return true;
            }
        }

        return false;
    }

    public boolean isAisleSeat(int row, int col) {
        if (row == 2 || row == 3) {
            if (col == 3 || col == 4) {
                return true;
            }
        }
        return false;
    }

//    0      1      2      3      4      5      6      7
//    A      B      C      D      E      F      G      H
// ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐
// │      │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │      │0
// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
// │      │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │ XXX  │      │1
// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
// │      │      │      │      │      │      │      │      │2
// ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
// │      │      │      │      │      │      │      │      │3
// └──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┘
//                           AISLE

    public NewReservation[][] getSeats() {
        return seats;
    }

    public void setSeats(NewReservation[][] seats) {
        this.seats = seats;
    }
}
