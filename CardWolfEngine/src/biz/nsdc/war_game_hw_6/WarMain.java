package biz.nsdc.war_game_hw_6;

import biz.nsdc.util.Player;

/**
 * Runs a game of war. 
 * CSC 233
 * @author Sam Kaessner
 */
public class WarMain {
	/**
	 */
	public static void main(String args[]) {
		//Create deck
		StandardDeck deck = StandardDeck.getDefaultDeck();
		deck.shuffle();
		System.out.println("Shuffling Deck...");
		
		//The two hands for each player and a discard pile
		StandardDeck hand1 = new StandardDeck();
		StandardDeck hand2 = new StandardDeck();
		StandardDeck discard = new StandardDeck();
		
		
		//Deal hands
		while (deck.hasCardsLeft()) {
			hand1.putCardOnTop(deck.getTopCard());
			
			//Check if we can put a card on the second pile
			if (deck.hasCardsLeft()) {
				hand2.putCardOnTop(deck.getTopCard());
			}
		}
		
		//Debug
		System.out.println(hand1);
		System.out.println(hand2);
		
		//Create 2 players
		Player player1 = new Player("Sam", hand1);
		Player player2 = new Player("Mr. French", hand2);
		
		/*
		//Play the game
		player1.flip(discard, player2);
	
		//Print winner
		if (player1.getPoints() > player2.getPoints()) {
			System.out.println(player1.getName() + " won the game!");
		} else if (player2.getPoints() > player1.getPoints()) {
			System.out.println(player2.getName() + " won the game!");
		} else {
			System.out.println("The game was a draw :(");
		}*/
	}
}