package mod8CirrusAirlines;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NewMenuInfo {

    public void loadPresetData(ArrayList<Customer> custList, ArrayList<NewPlane> planesList) {

        // Plane 0 = Dec 1, Plane 1 = Dec 2, Plane 2 = Dec 3

        //Plane 0 LocalDate.of(2022, 12, 1)
        Customer cust1 = new Customer("Christina", "Hart");
        Customer cust2 = new Customer("Rosario", "Barrett");

        //Plane 1 LocalDate.of(2022, 12, 2)
        Customer cust3 = new Customer("Christine", "Mckinney");

        //Plane 2 LocalDate.of(2022, 12, 3)
        Customer cust4 = new Customer("Gus", "Carter");
        Customer cust5 = new Customer("Ward", "Cook");

        // Plane 0
        NewReservation resv1 = new NewReservation(cust1, "C3");
        NewReservation resv2 = new NewReservation(cust2, "D3");

        //Plane 1
        NewReservation resv3 = new NewReservation(cust3, "B1");

        //Plane 2
        NewReservation resv4 = new NewReservation(cust4, "A1");
        NewReservation resv5 = new NewReservation(cust5, "D4");

        planesList.add(new NewPlane(LocalDate.of(2022, 12, 1)));
        planesList.add(new NewPlane(LocalDate.of(2022, 12, 2)));
        planesList.add(new NewPlane(LocalDate.of(2022, 12, 3)));

        int num1Col = columnNum(resv1.getSeat());
        int num1Row = rowNum(resv1.getSeat());

        int num2Col = columnNum(resv2.getSeat());
        int num2Row = rowNum(resv2.getSeat());

        int num3Col = columnNum(resv3.getSeat());
        int num3Row = rowNum(resv3.getSeat());

        int num4Col = columnNum(resv4.getSeat());
        int num4Row = rowNum(resv4.getSeat());

        int num5Col = columnNum(resv5.getSeat());
        int num5Row = rowNum(resv5.getSeat());

        // We need to find a way to get the second num in the seat code Ex) B1 ---> 1 -
        // Eduardo 12/6
        custList.add(cust1);
        custList.add(cust2);
        custList.add(cust3);
        custList.add(cust4);
        custList.add(cust5);

        planesList.get(0).getSeats()[num1Row - 1][num1Col - 1] = resv1;
        planesList.get(0).getSeats()[num2Row - 1][num2Col - 1] = resv2;
        planesList.get(1).getSeats()[num3Row - 1][num3Col - 1] = resv3;
        planesList.get(2).getSeats()[num4Row - 1][num4Col - 1] = resv4;
        planesList.get(2).getSeats()[num5Row - 1][num5Col - 1] = resv5;
    }
    

    // Creates a customer object and is added to an arraylist in main driver -
    // Eduardo 12/5
    public Customer createCustomer() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Customer's first name?");
        String first = scan.nextLine();
        System.out.println("Customer's last name?");
        String last = scan.nextLine();

        Customer custFav = new Customer(first, last);

        System.out.println("Congrats, you have successfully added a customer into our database!");
        // Changed cust.get(cust.size() - 1).getId() to custFav.getID() as a new ID is
        // created for that customer when it is initialized - BW
        System.out.println("Your id number is " + custFav.getId() + ".");
        return custFav;
    }

    public void createReservation(ArrayList<Customer> c, ArrayList<NewPlane> planes) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Current or new customer? (c/n/current/new)");
        String status = scan.nextLine();

        if (status.equals("c") || status.equals("n") || status.equals("current") || status.equals("new")) {

            if (status.equals("c") || status.equals("current")) { // Current customer
                System.out.println("Do you know your ID#? (yes/no)");
                String idKnown = scan.nextLine();

                if (idKnown.equals("yes")) { // ID is known

                    System.out.println("What is your ID?");
                    int userID = scan.nextInt();

                    boolean found = false;
                    Customer currentCustomer = null;
                    int i = 0;
                    while (!found && i < c.size()) {
                        if (userID == c.get(i).getId()) {
                            System.out.println("ID valid");
                            currentCustomer = c.get(i);
                            found = true;
                        } else {
                            i++;
                        }
                    }

                    if (found) { // ID is found and valid
                    	//seatSelection(currentCustomer, c, planes);

                        System.out.println("Which date are you inquiring about?  " + "Type 1 for 12/1/2022, 2 for 12/2/2022, or 3 for 12/3/2022.");
                        int resDate = scan.nextInt();

                        if (resDate >= 1 && resDate <= 3) { // Date is valid
                            NewPlane currentPlane = planes.get(resDate - 1);

                            if(!currentPlane.alreadyHasReservation(currentCustomer)){

                                System.out.println("You are creating a reservation for Plane #" + resDate + " scheduled to leave on " + currentPlane.getFlightDate());

                                //currentPlane.printAllPlaneSeating();

                                System.out.println("Would you like first class or economy seating? (eco/fir/first class/economy)");
                                System.out.println("Please note, there are only window seats available for first class.");
                                scan.nextLine();
                                String seatingType = scan.nextLine();

                                if (seatingType.equals("first class") || seatingType.equals("fir")) { // If they want first class

                                    createFirstClassRes(currentCustomer, currentPlane);

                                } else if (seatingType.equals("eco") || seatingType.equals("economy")) { // If they want economy

                                    System.out.println("Would you like a window, aisle, or normal seat? (window/aisle/normal/w/a/n)");
                                    String ecoSeatType = scan.nextLine();

                                    if (ecoSeatType.equals("window") || ecoSeatType.equals("w")) {
                                        createEcoRes(currentCustomer, currentPlane, 1);
                                    } else if (ecoSeatType.equals("aisle") || ecoSeatType.equals("a")) {
                                        createEcoRes(currentCustomer, currentPlane, 2);
                                    } else if (ecoSeatType.equals("normal") || ecoSeatType.equals("n")) {
                                        createEcoRes(currentCustomer, currentPlane, 3);
                                    } else {
                                        System.out.println("Invalid seat type. You must choose window/aisle/normal/w/a/n");
                                    }

                                } else { // If the seat type is not valid
                                    System.out.println("Invalid reservation type. You must choose eco/fir/first class/economy");
                                }
                            }else{ // Already has a reservation
                                System.out.println("You already have a reservation on this plane. You must cancel it before making another.");
                            }

                        } else {// Date is not valid
                            System.out.println("Invalid date.");
                        }

                    } else { // ID is not valid
                        System.out.println("ID not valid");
                    }

                } else { // ID not known
                    System.out.println("Let's find your ID:");
                    System.out.println("Customer's first name?");
                    String first = scan.nextLine();
                    System.out.println("Customer's last name?");
                    String last = scan.nextLine();

                    boolean found = false;
                    int i = 0;
                    while (!found && i < c.size()) {
                        String foundFirst = c.get(i).getFirst();
                        String foundLast = c.get(i).getLast();
                        int userID = c.get(i).getId();
                        if (foundFirst.equals(first) && foundLast.equals(last)) {
                            System.out.println("We found your ID based on your name: " + userID);
                            found = true;
                        }
                        i++;
                    }
                }

            } else { // Not a current customer
                c.add(createCustomer());
            }
        } else { // Invalid
            System.out.println("Invalid answer: Current or new customer? (c/n/current/new)");
        }
    }
    
    

    public void createFirstClassRes(Customer currentCustomer, NewPlane currentPlane) {
        Scanner scan = new Scanner(System.in);

        currentPlane.printFirstClassSeating();

        System.out.println("Which seat would you like? Type column letter and row number. Ex) A1");
        String seatChoice = scan.nextLine();

        if (seatChoice.toLowerCase().charAt(0) == 'h') {
            char temp = seatChoice.charAt(1);
            seatChoice = "B" + temp;
        }

        int num1Col = columnNum(seatChoice) - 1;
        int num1Row = rowNum(seatChoice) - 1;

        if (num1Row >= 0 && num1Row <= 1 && num1Col >= 0 && num1Col <= 1) { // Is a valid first class seat
            if (currentPlane.getSeats()[num1Row][num1Col] == null) { // Is seat taken

                NewReservation res = new NewReservation(currentCustomer, seatChoice);
                currentPlane.getSeats()[num1Row][num1Col] = res;
                System.out.println("Seat booked");

            } else { // Seat taken
                System.out.println("Seat taken");
            }
        } else { // Not a valid first class seat
            System.out.println("Not a valid first class seat");
        }
    }

    public void createEcoRes(Customer currentCustomer, NewPlane currentPlane, int ecoSeatType) {
        Scanner scan = new Scanner(System.in);

        switch (ecoSeatType) {
            case 1: // Window seat
                currentPlane.printEcoWindowSeats();
                break;
            case 2: // Aisle seat
                currentPlane.printEcoAisleSeats();
                break;
            case 3: // Normal seat
                currentPlane.printEcoNormalSeats();
                break;
        }

        System.out.println("Which seat would you like? Type column letter and row number. Ex) A1");
        String seatChoice = scan.nextLine();

        int num1Col = columnNum(seatChoice) - 1;
        int num1Row = rowNum(seatChoice) - 1;
        boolean validSeat = false;
        if (ecoSeatType == 1 && (num1Col == 0 || num1Col == 7) && (num1Row == 2 || num1Row == 3)) { // Window seats
            validSeat = true;
        } else if (ecoSeatType == 2 && (num1Col == 3 || num1Col == 4) && (num1Row == 2 || num1Row == 3)) { // Aisle seats
            validSeat = true;
        } else if (ecoSeatType == 3 && (num1Row == 2 || num1Row == 3)) { // Normal seat
            validSeat = true;
        }

        if (validSeat) {
            if (currentPlane.getSeats()[num1Row][num1Col] == null) { // Is seat taken

                NewReservation res = new NewReservation(currentCustomer, seatChoice);
                currentPlane.getSeats()[num1Row][num1Col] = res;
                System.out.println("Seat booked");

            } else { // Seat taken
                System.out.println("Seat taken");
            }
        } else {
            System.out.println("Invalid seat for your selected seat type.");
        }
    }
    
    public void openSeats(ArrayList<NewPlane> planes) {
    	  Scanner scan = new Scanner(System.in);
    
    	 System.out.println("Which date are you inquiring about?  " + "Type 1 for 12/1/2022, 2 for 12/2/2022, or 3 for 12/3/2022.");
         int resDate = scan.nextInt();

         if (resDate >= 1 && resDate <= 3) {
        	 NewPlane currentPlane = planes.get(resDate - 1);
        	 currentPlane.printSomeSeating();
         
         }
    }

    public void cancelReservation(ArrayList<Customer> c, ArrayList<NewPlane> planes) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you know your ID#? (yes/no)");
        String idKnown = scan.nextLine();

        if (idKnown.equals("yes")) { // ID is known

            System.out.println("What is your ID?");
            int userID = scan.nextInt();

            boolean found = false;
            Customer currentCustomer = null;
            int i = 0;
            while (!found && i < planes.size()) {
                if (userID == c.get(i).getId()) {
                    System.out.println("ID valid");
                    currentCustomer = c.get(i);
                    found = true;
                }
                i++;
            }

            if (found) { // ID is found and valid

                System.out.println("Which date are you inquiring about?  " + "Type 1 for 12/1/2022, 2 for 12/2/2022, or 3 for 12/3/2022.");
                int resDate = scan.nextInt();

                if (resDate >= 1 && resDate <= 3) { // Date is valid
                    NewPlane currentPlane = planes.get(resDate - 1);
                    System.out.println("You are cancelling a reservation for Plane #" + (resDate + 1) + " scheduled to leave on " + currentPlane.getFlightDate());

                    currentPlane.printAllPlaneSeating();

                    System.out.println("Which reservation would you like to cancel? Type column letter and row number. Ex) A1");
                    scan.nextLine();
                    String seatChoice = scan.nextLine();

                    int num1Col = columnNum(seatChoice);
                    int num1Row = rowNum(seatChoice);

                    if (currentPlane.getSeats()[num1Row - 1][num1Col - 1] != null) { // Is seat valid

                        if (currentPlane.getSeats()[num1Row - 1][num1Col - 1].getCust().getId() == currentCustomer.getId()) { // If Customer owns the seat
                            currentPlane.getSeats()[num1Row - 1][num1Col - 1] = null;
                            System.out.println("Reservation cancelled");

                        } else { // If they do not own the seat
                            System.out.println("You do not own this reservation");
                        }
                    } else { // Invalid seat
                        System.out.println("Invalid seat");
                    }

                } else {// Date is not valid
                    System.out.println("Invalid date.");
                }

            } else { // ID is not valid
                System.out.println("ID not valid");
            }

        } else { // ID not known
            System.out.println("Let's find your ID:");
            System.out.println("Customer's first name?");
            String first = scan.nextLine();
            System.out.println("Customer's last name?");
            String last = scan.nextLine();

            boolean found = false;
            int i = 0;
            while (!found && i < planes.size()) {
                String foundFirst = c.get(i).getFirst();
                String foundLast = c.get(i).getLast();
                if (foundFirst.equals(first) && foundLast.equals(last)) {
                    System.out.println("We found your ID based on your name: " + c.get(i).getId());
                    found = true;
                }
                i++;
            }
        }
    }

    // This method will turn the first letters into number. Ex) A=1, B=2, C=3... -
    // Eduardo 12/6
    public int columnNum(String input) {
        String temp = input.toLowerCase();
        char ch = temp.charAt(0);
        int position = ch - 'a' + 1;
        return position;
    }

    public int rowNum(String in) {
        String rowString = "" + in.charAt(1);
        int row = (int) Integer.parseInt(rowString);
        return row;
    }



    // Saves data to a file. - Eduardo 12/9
    public void saveFile(ArrayList<NewPlane> planes) {
        String filename = FileLoc.pickLocOut();

        PrintWriter outputFile = null;
        try {
            outputFile = new PrintWriter(filename);
            // Creates header for the file - Eduardo 12/9
            outputFile.println("first_name|last_name|cust_id|seat_id|seat|date");
            for (int i = 0; i < planes.size(); i++) {
                NewPlane p = planes.get(i);
                ArrayList<String> seatInfo = p.toStringF();
                for (int j = 0; j < seatInfo.size(); j++) {
                    outputFile.println(seatInfo.get(j));
                }
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception.  Need to exit");
            System.exit(0);

        } finally {
            // Close the file.
            outputFile.close();
        }

    }

    // Reads data from a text file for use in the program. - Eduardo 12/9
    public ArrayList<Customer> readText(ArrayList<NewPlane> np) {
        ArrayList<Customer> cust = new ArrayList<Customer>();
        // Creates different "Planes" for each date - Eduardo 12/9
        // Plane 0 LocalDate.of(2022, 12, 1)
        np.add(new NewPlane(LocalDate.of(2022, 12, 1)));
        // Plane 1 LocalDate.of(2022, 12, 2)
        np.add(new NewPlane(LocalDate.of(2022, 12, 2)));
        // Plane 0 LocalDate.of(2022, 12, 3)
        np.add(new NewPlane(LocalDate.of(2022, 12, 3)));
        String filename = FileLoc.pickLocRead();
        File file = new File(filename);

        Scanner inputFile = null;
        try {
            inputFile = new Scanner(file);

            int counter = 0;
            while (inputFile.hasNext()) {
                String line = inputFile.nextLine();
                counter++;
                if (counter != 1) { // Used to skip header of the file - Eduardo 12/9
                    StringTokenizer t = new StringTokenizer(line, "|/-");
                    String first = t.nextToken().trim();
                    String last = t.nextToken().trim();
                    int id = Integer.parseInt(t.nextToken().trim());
                    // Creates an instance of Customer and adds it to the Customer arrayList -
                    // Eduardo 12/9
                    Customer c = new Customer(first, last, id);
                    cust.add(c);
                    int seatId = Integer.parseInt(t.nextToken().trim());
                    String seat = t.nextToken().trim();
                    int numCol = columnNum(seat);
                    int numRow = rowNum(seat);
                    // Creates an instance of Reservation
                    NewReservation n = new NewReservation(c, seat, seatId);
                    int mon = Integer.parseInt(t.nextToken().trim());
                    int day = Integer.parseInt(t.nextToken().trim());
                    int year = Integer.parseInt(t.nextToken().trim());
                    LocalDate d = LocalDate.of(year, mon, day);
                    // Plane 0
                    if (d.isEqual(LocalDate.of(2022, 12, 1))) {
                        np.get(0).getSeats()[numRow - 1][numCol - 1] = n;
                    }
                    // Plane 1
                    if (d.isEqual(LocalDate.of(2022, 12, 2))) {
                        np.get(1).getSeats()[numRow - 1][numCol - 1] = n;
                    }
                    // Plane 2
                    if (d.isEqual(LocalDate.of(2022, 12, 3))) {
                        np.get(2).getSeats()[numRow - 1][numCol - 1] = n;
                    }
                }

            }
        } catch (IOException ioe) {
            System.out.println("IO Exception.  Need to exit");
            System.exit(0);

        } finally {
            // Close the file.
            inputFile.close();
        }
        return cust;
    }
}