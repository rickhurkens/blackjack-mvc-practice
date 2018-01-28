package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Business class of the Blackjack game.
 * @author Rick
 * @since 1.5
 */
public class Blackjack {
	private List<Player> players;
	private Deck deck = new Deck();
	
	/**
	 * @return a {@link List} of every {@link Player} currently in the game, including the {@link Dealer}.
	 */
	public List<Player> getPlayers() {
		return new ArrayList<>(players);
	}
	
	/**
	 * @return the {@link Deck} of cards that is currently in use.
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param dealer the {@link Dealer} player
	 * @param players a {@link List} containing {@link Player} instances
	 */
	public Blackjack(Dealer dealer, List<Player> players) {
		this.players = new ArrayList<>();
		this.players.add(dealer);
		this.players.addAll(players);
		dealInitialCards();
	}
	
	/**
	 * Adds {@link HumanPlayer} instances to the {@link List} of players currently in the game.
	 * @param playerNames a {@link String} array of the names of the players to be added
	 */
	public void addPlayers(final String... playerNames) {
		players.add(new Dealer());
		for (String playerName : playerNames) {
			players.add(0, new HumanPlayer(playerName));
		}
	}
	
	/**
	 * Takes the a {@link Card} from the {@link Deck} and gives it to a {@link Player}.
	 * @param person The {@link Player} to receive the {@link Card}.
	 */
	public void dealCard(Player person) {
		Card card = deck.draw();
		person.receiveCard(card);
	}
	
	/**
	 * Gives two {@link Card} instances to each {@link Player} in the game.
	 */
	private void dealInitialCards() {
		for(Player person : players) {
			dealCard(person);
			dealCard(person);
		}
	}
	
	/**
	 * Calculates which player is the winner according to the following rules:
	 * If the dealer busts, the player wins.
	 * If the dealer and player tie but don't bust, the dealer wins.
	 * @return the {@link Player} who won the game
	 */
	public Player getWinner() {
		int highest = 0;
		Player topPlayer = players.get(0);
		for (Player player : players) {
			int total = player.getHand().getTotal();
			if (total >= highest && total <= 21) {
				highest = total;
				topPlayer = player;
			}
		}
		return topPlayer;
	}
}
