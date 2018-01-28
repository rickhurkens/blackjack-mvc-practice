package blackjack;

import java.util.Scanner;

/**
 * A player in a Blackjack game.
 * @author Rick
 */
public class HumanPlayer extends Player {
	Scanner userInput = new Scanner(System.in);
	
	/**
	 * Constructs a Player with the name "Unnamed Player".
	 * @param blackjack the {@link Blackjack} instance that called
	 * this constructor
	 */
	public HumanPlayer() {
		this("Unnamed Player");
	}
	
	/**
	 * Constructs a Player with the given name.
	 * @param name the name this Player is going to get as a 
	 * {@link String}, preferably in Title case.
	 * @param blackjack the {@link Blackjack} instance that called
	 * this constructor
	 */
	public HumanPlayer(final String name) {
		super(name);
	}

	@Override
	public boolean wantsToHit() {
		return chooseBetweenOptions("hit","stay");
	}
	
	@Override
	public boolean wantsToPlayAgain() {
		return chooseBetweenOptions("y","n");
	}
	
	private boolean chooseBetweenOptions(String option1, String option2) {
		String input = userInput.nextLine();
		while (!(input.equals(option1) || input.equals(option2))) {
			input = userInput.nextLine();
		}
		return input.equals(option1);
	}
}
