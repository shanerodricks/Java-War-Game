import java.util.ArrayList;
import java.util.Collections;

public class CardsInPlay {

	private static Cards player1Cards;
	private static Cards player2Cards;

	public static void reset() {
		player1Cards = new Cards(); //constructor
		player2Cards = new Cards();

	}

	public static void add(Cards cards, Player p) {
		switch(p.getNumber()) {
		case 1:
			player1Cards.add(cards);
			break;
		case 2:
			player2Cards.add(cards);
			break;
		}
	}

	public static void add(Card c, Player p) {
		Cards cs = new Cards();
		cs.add(c);
		add(cs, p);
	}

	public static void giveToPlayer(Player p) {
		ArrayList<Card> cards = player1Cards.getCards();
		Collections.shuffle(cards);
		for(Card c : cards) {
			p.receiveCard(c);
		}
		cards = player2Cards.getCards();
		Collections.shuffle(cards);
		for(Card c : cards) {
			p.receiveCard(c);
		}
		reset();
	}

	public static int computeValueOfCards(Cards cards) {
		int value = 0;
		for(Card c : cards.getCards()) {
			value += c.getValue();
		}
		return value;
	}

	public static int computeValueOfAPlayersCards(Player p) {
		int value = 0;
		switch(p.getNumber()) {
		case 1:
			value = computeValueOfCards(player1Cards);
			break;
		case 2:
			value = computeValueOfCards(player2Cards);
			break;
		}
		return value;
	}

	public static int computeMedianOfAPlayersCards(Player p) {
		switch(p.getNumber()) {
		case 1:
			if(player1Cards.size() == 3) {
				return getMedian(player1Cards);
			}
			else {
				return getMax(player1Cards);
			}
		case 2:
			if(player2Cards.size() == 3) {
				return getMedian(player2Cards);
			}
			else {
				return getMax(player2Cards);
			}
		}
		return -1;
	}

	private static int getMax(Cards cards) {
		if(cards.size() == 1) {
			return cards.getValue(0);
		}
		else {
			return Math.max(cards.getValue(0), cards.getValue(1));
		}
	}

	private static int getMedian(Cards cards) {
		Card a = cards.get(0);
		Card b = cards.get(1);
		Card c = cards.get(2);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(a.getValue());
		values.add(b.getValue());
		values.add(c.getValue());
		Collections.sort(values);
		return values.get(1);
	}

	public static String makeString() {
		return "Player1 CardsInPlay: " + player1Cards.toString() + "\nPlayer2 CardsInPlay: " + player2Cards.toString();
	}

	public static Cards getP1Cards() {
		return player1Cards;
	}

	public static Cards getP2Cards() {
		return player2Cards;
	}
}
