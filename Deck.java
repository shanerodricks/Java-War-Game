public class Deck extends Cards{

	public void createNew() {
		String[] suits = new String[] {"Heart", "Spade", "Club", "Diamonds"};
		for(String suit : suits) {
			for (int value = 2; value <= 14; value++) {
				add(new Card(value, suit));
			}
		}
	}

	public void dealCards(Player p1, Player p2) {
		while(cards.size() > 0) {
			p1.receiveCard(drawRandomCard());
			p2.receiveCard(drawRandomCard());
		}
	}

}
