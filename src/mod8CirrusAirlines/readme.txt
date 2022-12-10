# Cirrus Airlines Reservations System 
A simple Java program made to simulate an airline's reservation system. 

# Features
- Creates an account for each customer that is registered. Each customer gets a unique id number.
- Creates reservations for current or new customers. 
- Loads and saves data about reservations and customers. 
- Can cancel reservations for current customers with either their name or unique id number. 

# Installation (Eclipse only)
1. Open Eclipse.
2. Choose installation location 
3. Go to "File" and then "Import".
4. Click "Archive File" and "Next".
5. Click "Browse" and look for "mod8CirrusAirlines.jar". 
6. Click "Finish".
7. Done!

# Usage
Once the program is launched, it will ask the user to choice from 9 different menu options. The following explains how this menu works:

0.  Load preset data. - Loads data for testing purposes.
1.  Add new customer. - Creates an account for a customer. Asks for first name and last name. 
2.  Create a reservation. - Creates a reservation for new or current customers. Asks whether the customer prefers a window seat, an aisle seat, or neither.
3.  Print seats available. - Prints out a list of available seats for a specific date.
4.  Show plane loading. - Shows a diagram of the plane which shows avaliable and occupied seats for a specific date.
5.  Extra: Cancel a reservation. - Cancels a reservation using a customer's full name or id number.
6.  Save plane data. - Saves data from the program to a file.
7.  Load plane data. - Loads data from a file into the program.
8.  Exit. - Terminates the program.

The user is then instructed to type a number from 0-8.

NOTE: To load plane data into the program, the file needs to be a .txt file and formatted as so:

first_name|last_name|cust_id|seat_id|seat|date
Christina|Hart|100|100|C3|12/1/2022
Rosario|Barrett|101|101|D3|12/1/2022
Christine|Mckinney|102|102|B1|12/2/2022
Gus|Carter|103|103|A1|12/3/2022
Ward|Cook|104|104|D4|12/3/2022

# Contributions
Eduardo J. Argueta-Pineda, Benjamin Wheatly, Cara Eskew





