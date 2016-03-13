package biz.nsdc.util;

import java.util.ArrayList;
import java.util.Random;

import edu.frontrange.csc233.cardwolf.Card;

public class Util {
	public static <T extends Card> ArrayList<T> shuffle(ArrayList<T> cards) {
		Random random = new Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int rand = random.nextInt(i + 1);
			
			//Get the two card's positions
			T card1 = cards.get(i);
			T card2 = cards.get(rand);
			
			//Swap the positions of the card.
			cards.set(i, card2);
			cards.set(rand, card1);
		}
		
		return cards;
	}
}