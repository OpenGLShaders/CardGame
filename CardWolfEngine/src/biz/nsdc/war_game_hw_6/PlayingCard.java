package biz.nsdc.war_game_hw_6;

import edu.frontrange.csc233.cardwolf.StandardPlayingCard;

public class PlayingCard extends StandardPlayingCard {

	public PlayingCard(int value, Suit suit) {
		super(value, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StandardPlayingCard)) {
			return false;
		}
		StandardPlayingCard card = (StandardPlayingCard) obj;
		
		return (getValue() == card.getValue()) && (getSuit() == card.getSuit());
	}
}