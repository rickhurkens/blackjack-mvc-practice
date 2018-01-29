package blackjack;

import java.util.LinkedList;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.Collections;

/**
 * A deck that contains a list of {@link Card} instances.
 * Can contain four references to each {@code Card} rank.
 * @author Rick
 */
public class Deck {
	private Stack<Card> cards = new Stack<>();

	/**
	 * Creates a new {@code Deck} with all 52 cards.
	 */
	public Deck() {
		fillDeckWithAllCards();
	}
	
	/**
	 * Takes the next {@link Card} reference off the deck. 
	 * If the deck is empty, fills it up with all 52 cards 
	 * again.
	 * @return the first {@link Card} reference on the deck.
	 */
	public Card draw() {
		if (cards.isEmpty()) {
			fillDeckWithAllCards();
		}
		return cards.pop();
	}
	
	/**
	 * Fills up the {@link LinkedList} with 4 references to
	 * each {@link Card} rank and shuffles the deck.
	 */
	private void fillDeckWithAllCards() {
		cards.clear();
		for(int i = 0; i < 4; i++) {
			for(Card card : Card.values()) {
				cards.add(card);
			}
		}
		shuffle();
	}
	
	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
}
