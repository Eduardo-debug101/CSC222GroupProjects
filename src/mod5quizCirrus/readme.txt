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
 11/2/22:
 Fixed an issue where all players tied despite having different points in determineWinnerOfRound2 method
 Changed text in printStart to fit in with new changes
 

Cara Eskew:
Comments:
10/31/22 - Created getPoints for Card class, which then returns to the toString.
11/01/22 - created determineGameWinner, which assesses the balances of all players and determines the game
winner.  Needs additional work for ties.  Added a tie component to the determineWinnerOfRound method which,
per Discord conversation, adds 50% of the bet value to each of tied player's balances.  I have not yet come across a three-way
tie, but just in case I added a condition where no one adds money to their balances.
11/02/11 - determineGameWinner can now report tied games.  Migrated Enter prompt from determineWinnerOfRound2
to main so that the user is not prompted to press enter on the final round.  Minor grammatical output
alterations conducted.

Benjamin Wheatley:
Comments:

11/1/22:
Added logic in driver for multiple games and slowly started thinking about unlimited amounts of players
Added a total balance for each player in player class
Added method in driver to determine winner and update each balance, will need logic for ties
Added new method in player class that simulates a play of card in the current index of the hand
One thing about the way I've handled cards is that they're never removed from the hand of the player, though I don't know if that really matters or not

11/2/22:
I've added in a lot of the logic needed for unlimited players
Added populatePlayerList in driver to get all of the players for the game
This moves a lot of the driver code into its own method
Updated getHand() so that it will take into account the proper hand size for multiple players
Changed NUM_GAMES in driver now to the amount of games applicable to the player amount
Added another determineWinnerOfRound2 method that will be able to handle unlimited players and ties
I think per the sample output Dr. Wolff wants no winner for the round if they tied so no one wins anything that round
Still needs a finished final winner method as well as some error logic for user inputs in populatePlayerList, like entering $0.00 bet amount etc.

11/2/22 Continued:
Fixed bug with winners of the round where their balance was being overwritten and not added to (+=)
Started documenting code
Updated printStart() to reflect tied player rewards