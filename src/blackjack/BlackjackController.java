package blackjack;

import java.util.List;

/**
 * The controller of the Blackjack game.
 * For each new game it creates an instance of {@link Blackjack}
 * and one instance of a {@link ConsoleView}.
 * @author Rick
 */
public class BlackjackController {
	private Blackjack blackjack;
	private BlackjackView view;
	
	/**
	 * @param blackjack The instance of the game model this controller is
	 * going to control
	 * @param view the view this controller is going to handle
	 */
	public BlackjackController(Blackjack blackjack, BlackjackView view) {
		this.blackjack = blackjack;
		this.view = view;
	}
	
	/**
	 * Runs the game in chronological order.
	 */
	public void run() {
		playOneGame();
		view.thanksForPlaying();
	}
	
	private void playOneGame() {
		view.welcome();
		for (Player player : blackjack.getPlayers()) {
			view.showInitialHand(player);
		}
		for (Player player : blackjack.getPlayers()) {
			letPersonPlayItsTurns(player);
		}
		for (Player player : blackjack.getPlayers()) {
			view.displayTotal(player);
		}
		Player winner = blackjack.getWinner();
		view.showWinner(winner);
		
		if(winner.wantsToPlayAgain()) {
			List<Player> allPlayers = blackjack.getPlayers();
			Dealer dealer = (Dealer) allPlayers.get(allPlayers.size() - 1);
			List<Player> players = allPlayers.subList(0, allPlayers.size() - 1);
			this.blackjack = new Blackjack(dealer, players);
			playOneGame();
		}
	}
	
	private void letPersonPlayItsTurns(Player player) {
		view.showHand(player);
		while(true) {
			view.askForTurn(player);
			if (player.wantsToHit()) {
				blackjack.dealCard(player);
				view.playerHit(player);
				view.showHand(player);;
			} else {
				view.playerStay(player);
				break;
			}
		}
	}

}