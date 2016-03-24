package biz.nsdc.util;

import edu.frontrange.csc233.cardwolf.Card;

/**
 * CSC 233
 * @author Sam Kaessner, Chris, Noah
 */
public class Player {
	protected Deck<? extends Card> hand;
	protected String name;
	
	public Player(String name) {
		this(name, null);
	}
	
	/**
	 * Holds a player. Takes the name of the player and his hand of cards. 
	 * @param name
	 * @param hand
	 */
	public  Player(String name, Deck<? extends Card> hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Deck<? extends Card> getHand(){
            return hand;
        }
	/**
	 * Returns the name of the player.
	 * @return
	 */
	public String getName() {
		return name;
	}
}