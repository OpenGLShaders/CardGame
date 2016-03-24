package biz.nsdc.uno;

import biz.nsdc.uno.UnoCard.Color;
import biz.nsdc.util.Deck;

/**
 * This implements an uno deck. At the moment, it only stores numerical cards, and doesn't have
 * any special cards yet. 
 * CSC 233
 * @author Sam Kaessner
 */
public class UnoDeck extends Deck<UnoCard> {
	
	/**
	 * Creates an empty deck that holds UnoCards.
	 */
	public UnoDeck() {
		
	}
	
	/**
	 * Returns a deck of unshuffled uno cards.
	 * 
	 * @return
	 */
	public static UnoDeck getDefaultDeck() {
		UnoDeck deck = new UnoDeck();
		for (int i = 0; i < 10; i++) {
			for (Color c : Color.values()) {
				for (int j = 0; j < (i == 0 ? 1 : 2); j++) {
					NumericalUnoCard card = new NumericalUnoCard(i, c);
					deck.putCardOnTop(card);
				} 
			}
		}
		return deck;
	}
}