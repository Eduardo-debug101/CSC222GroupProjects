Group members: Eduardo Argueta-Pineda, Cara Eskew, Benjamin Wheatley

Eduardo J. Argueta-Pineda:
Comments: 
10/27/22 - I have done some work on PlayCards and PlayerNotDone. Currently, there is a problem with how the hand is being printed out.
Please change my code if needed. 
10/31/22 - Created UML diagram. Started working on driver output. 
11/1/22:
 Renamed PlayerNotDone to Player. 
 Removed commented code in PlayCards. 
 Fixed formatting of code in PlayCards and Player.
 Added overallWinner method in PlayCards which determines overall winner
 Added getNextCard method in Player which gets a card with a specific index
 Note - I'm thinking about adding an extra round for a tiebreaker. 
 Also, I'm thinking about transferring some methods from PlayCards to a new blueprint class named Game to clean up the main driver.

Cara Eskew:
Comments:
10/31/22 - Created getPoints for Card class, which then returns to the toString.
11/01/22 - created determineGameWinner, which assesses the balances of all players and determines the game
winner.  Needs additional work for ties.  Added a tie component to the determineWinnerOfRound method which,
per Discord conversation, adds 50% of the bet value to each of tied player's balances.  I have not yet come across a three-way
tie, but just in case I added a condition where no one adds money to their balances.

Benjamin Wheatley:
Comments:
11/1/22:
Added logic in driver for multiple games and slowly started thinking about unlimited amounts of players
Added a total balance for each player in player class
Added method in driver to determine winner and update each balance, will need logic for ties
Added new method in player class that simulates a play of card in the current index of the hand

One thing about the way I've handled cards is that they're never removed from the hand of the player, though I don't know if that really matters or not
