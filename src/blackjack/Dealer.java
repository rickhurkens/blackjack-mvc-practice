package blackjack;

import java.util.Random;

/**
 * The Dealer in a Blackjack game.
 * @author Rick
 */
public class Dealer extends Player {
	private static final int CUSP = 16;

	/**
	 * Creates a new {@code Dealer} with name "The Dealer".
	 * @param blackjack the {@link Blackjack} instance that called
	 * this constructor
	 */
	public Dealer() {
		super("The Dealer");
	}
	
	/**
	 * Only returns a {@link Hand} with the open {@link Card} 
	 * that all {@link HumanPlayer} instances can see.
	 * @return a {@link Hand} with the {@link Dealer}'s first
	 * {@link Card} in it
	 */
	@Override
	public Hand getOpenHand() {
		Hand hand = new Hand();
		hand.addCard(this.hand.getCards().get(0));
		return hand;
	}
	
	@Override
	public boolean wantsToHit() {
		boolean couldGoEitherWay = hand.getTotal() == CUSP;
		if (couldGoEitherWay) {
			return new Random().nextBoolean();
		}
		return hand.getTotal() < CUSP;
	}
	
	@Override
	public boolean wantsToPlayAgain() {
		System.out.println("dealer says: 'y'");
		return true;
	}
}
