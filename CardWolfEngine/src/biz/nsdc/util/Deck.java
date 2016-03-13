package biz.nsdc.util;

import java.util.ArrayList;

import edu.frontrange.csc233.cardwolf.Card;

/** 
 * Not yet finished.
 * CSC 233
 * @author Sam Kaessner
 *
 */
public class Deck<T extends Card> {
	//Holds the cards. 
	protected ArrayList<T> cards = new ArrayList<>();
	
	
	/**
	 * Holds a deck of cards.
	 */
	public Deck() {}
	
	/**
	 * Shuffles the cards. Uses the Fisher-Yates modern algorithm. 
	 */
	public void shuffle() {
		Util.shuffle(cards);
	}
	
	/**
	 * If the given card is in the deck, this method removes the card, and then returns the 
	 * deck. If the card is not found, then the original deck is returned unchanged.
	 */
	public Deck<T> removeCard(T t) {
		int index = search(t);
		if (index != -1) {
			cards.remove(index);
		}
		return this;
	}
	
	/**
	 * Currently uses a linear search. Uses .equals for the equality test. Returns the index of
	 * the card in the ArrayList.
	 */
	public int search(T t) {
		T card;
		int i = 0; 
		while (i < cards.size()) {
			card = cards.get(i);
			if (t.equals(card)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * Removes the top card from the stack and returns it. If there are no cards left in 
	 * the deck, this returns null.
	 * 
	 * @return The top card
	 */
	public T getTopCard() {
		int index = cards.size() - 1;
		if (hasCardsLeft()) {
			T card = cards.get(index);
			cards.remove(index);
			return card;
		}
		return null;
	}
	
	/**
	 * Puts a card on top of the pile.
	 * @param t
	 */
	public void putCardOnTop(T t) {
		cards.add(t);
	}

	/**
	 * Puts the contents of the given deck on the top of this deck, and clears the given deck.
	 * @param deck
	 */
	public void putDeckOnTop(Deck<T> deck) {
		cards.addAll(deck.cards);
		deck.cards.clear();
	}
	
	/**
	 * Returns whether or not this deck has any cards left in it. 
	 * @return
	 */
	public boolean hasCardsLeft() {
		return (cards.size() > 0);
	}
	
	/**
	 * Returns the amount of cards in this deck.
	 * @return
	 */
	public int count() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < cards.size(); i++) {
			builder.append(cards.get(i).toString());
			builder.append('\n');
		}
		
		return builder.toString();
	}
}