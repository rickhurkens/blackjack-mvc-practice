package blackjack;

import java.util.Queue;

/**
 * The view of this game in a console window.
 * @author Rick
 * @since 1.5
 */
public class ConsoleView implements BlackjackView{

	@Override
	public void welcome() {
		System.out.println("\n\n\nWelcome to a new Blackjack game!\n\n");
	}
	
	@Override
	public void showInitialHand(Player player) {
		Hand hand = player.getOpenHand();
		System.out.println(player + " has " + hand + ".\n");
		return;
	}
	
	@Override
	public void showHand(Player player) {
		Hand hand = player.getHand();
		System.out.println(player + " has " + hand + ".");
		System.out.println("That makes a total of " + hand.getTotal() + ".\n");
	}
	
	@Override
	public void askForTurn(Player player) {
		System.out.print("Do you want to 'hit' or 'stay'? ");
	}
	
	@Override
	public void displayTotal(Player player) {
		System.out.println(player + "'s total is " + player.getHand().getTotal() + ".");
	}
	
	@Override
	public void showWinner(Player player) {
		System.out.println(player + " is the winner!\n");
		this.wantToPlayAgain();
	}
	
	@Override
	public void wantToPlayAgain() {
		System.out.print("\nDo you want to play again? 'y'/'n': ");
	}
	
	@Override
	public void thanksForPlaying() {
		System.out.println("\nThanks for playing!");
	}
	
	@Override
	public void playerHit(Player player) {
		System.out.println(player + " chose to hit.");
	}
	
	@Override
	public void playerStay(Player player) {
		System.out.println(player + " chose to stay.");
	}
}