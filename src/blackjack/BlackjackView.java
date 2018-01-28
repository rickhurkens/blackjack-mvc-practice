package blackjack;

/**
 * The interface to be implemented for creating a
 * view for the {@link Blackjack} game.
 * @author Rick
 */
public interface BlackjackView {
	
	/**
	 * Displays the welcome message and shows the
	 * initial hands (by calling {@link #showHand(Player)}) 
	 * of all the players.
	 */
	public void welcome();
	
	/**
	 * Displays the initial {@link Card} instances in a {@link Player}
	 * 's {@link Hand} as it is viewable for the {@link HumanPlayer}.
	 * @param player The {@link Player} to show the {@link Hand}
	 * 's contents of.
	 */
	public void showInitialHand(Player player);
	
	/**
	 * Displays the {@link Card} instances in one {@link Player}
	 * 's {@link Hand} and displays the total value of that
	 * {@code Hand}.
	 * @param player The {@link Player} to show the {@link Hand}
	 * 's contents of.
	 */
	public void showHand(Player player);
	
	public void askForTurn(Player player);
	
	/**
	 * Displays the total value of a {@link Player}'s {@link Hand}
	 * @param player the {@Person} whose total will be displayed
	 */
	public void displayTotal(Player player);
	
	/** 
	 * Shows who the winner is
	 * @param player the winning {@link Player}
	 */
	public void showWinner(Player player);
	
	/**
	 * Displays a message thanking the user for playing after
	 * he says he doesn't want to play again.
	 */
	public void thanksForPlaying();
	
	public void wantToPlayAgain();
	
	public void playerHit(Player player);
	
	public void playerStay(Player player);
}