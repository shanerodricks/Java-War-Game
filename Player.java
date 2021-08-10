public class Player {

	private int number;
	private Cards cards;

	public Player(int n, Cards cs) {
		number = n;
		cards = cs;
	}

	public int getNumber() {
		return number;
	}

	public void receiveCard(Card c) {
		cards.add(c);
	}

	public Cards flip3() {
		return cards.removeTopCards(3);
	}

	public Card flip1() {
		Cards cs = cards.removeTopCards(1);
		return cs.get(0);
	}

	public boolean hasNoMoreCards() {
		return cards.size() == 0;
	}

	public boolean hasWon() {
		return cards.size() == 52;
	}

	public String toString() {
		return "Player " + number + ": " + cards;
	}
}
