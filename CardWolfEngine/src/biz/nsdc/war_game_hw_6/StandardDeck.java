package biz.nsdc.war_game_hw_6;

import biz.nsdc.util.Deck;
import edu.frontrange.csc233.cardwolf.StandardPlayingCard.Suit;

/**
 * This holds a deck of standard playing cards. It does NOT necessarily have to have 
 * all 52 cards, or any cards at all.
 * CSC 233
 * @author Sam Kaessner
 */
public class StandardDeck extends Deck<PlayingCard> {
	public StandardDeck() {}
	
	
	/**
	 * Returns an unshuffled standard deck of 52 playing cards.
	 * @return
	 */
	public static StandardDeck getDefaultDeck() {
		StandardDeck deck = new StandardDeck();
		
		for (int i = 1; i < 14; i++) { //There are 13 cards in each suits, plus one for offsets
			for (int j = 0; j < Suit.values().length; j++) { 
				deck.putCardOnTop(new PlayingCard(i, Suit.values()[j]));
			}
		}
		
		return deck;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < cards.size(); i++) {
			builder.append(cards.get(i).getName());
			builder.append('\n');
		}
		
		return builder.toString();
	}
}