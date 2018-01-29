package blackjack;

/**
 * A {@code Person} is someone who sits at the table to play
 * Blackjack.
 * @author Rick
 */
public abstract class Player {
	private final String name;
	protected Hand hand = new Hand();

	/**
	 * Constructs a Person with the name "Unnamed Person".
	 * @param blackjack the instance of the game this {@code 
	 * Player} is playing
	 */
	public Player() {
		this("Unnamed Player");
	}
	
	/**
	 * Constructs a Person with the given name.
	 * @param name the name this Person is going to get as a 
	 * {@link String}, preferably in Title case.
	 * @param blackjack the {@link Blackjack} instance that called
	 * this constructor
	 */
	public Player(final String name) {
		this.name = name;
	}

	/**
	 * @return the name as a {@link String} exactly as is
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the {@link Hand} this player currently has
	 */
	public Hand getHand() {
		return hand;
	}
	
	/**
	 * @return the part of the {@link Hand} that is currently 
	 * viewable to the player
	 */
	public Hand getOpenHand() {
		return hand;
	}
	
	/**
	 * Puts the {@link Card} in this Player's {@link Hand}.
	 * @param card the {@link Card} this {@code Player} is receiving.
	 */
	public void receiveCard(final Card card) {
		hand.addCard(card);
	}
	
	public void emptyHand() {
		hand.empty();
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * @return {@code true} if player want to receive another {@link Card},
	 * {@code false} if he wants to end his turn.
	 */
	public abstract boolean wantsToHit();
	
	/**
	 * @return {@code true} if player want to play another game, {@code false}
	 * if player wants to stop playing.
	 */
	public abstract boolean wantsToPlayAgain();
}