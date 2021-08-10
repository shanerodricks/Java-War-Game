import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Cards {

	protected ArrayList<Card> cards = new ArrayList<Card>();
	private Random random;

	public Cards() {
		random = new Random();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Card get(int index) {
		return cards.get(index);
	}

	public int size() {
		return cards.size();
	}

	public int getValue(int index) {
		return this.get(index).getValue();
	}


	public Cards removeTopCards(int num) {
		if (num > cards.size()) {
			num = cards.size();
		}
		Cards cs = new Cards();
		for(int i = 0; i < num; i++) {
			cs.add(cards.remove(0));
		}
		return cs;
	}

	public void sort() {
		Collections.sort(cards, new Comparator<Card>() {
			@Override
			public int compare(Card c1, Card c2) {
				return c1.getValue() - c2.getValue();
			}
		});
	}

	public Card drawRandomCard() {
		int index = random.nextInt(cards.size());
		Card c = cards.get(index);
		cards.remove(c);
		return c;
	}

	public Card[] toArray() {
		Card[] cArray = new Card[cards.size()];
		for (int i = 0; i < cards.size(); i++) {
			cArray[i] = cards.get(i);
		}
		return cArray;
	}

	public void randomize() {
		ArrayList<Card> randomOrdered = new ArrayList<Card>();
		while(!cards.isEmpty()) {
			int randomIndex = random.nextInt(cards.size());
			Card randomCard = cards.remove(randomIndex);
			randomOrdered.add(randomCard);
		}
		cards = randomOrdered;
	}

	public String toString() {
		return cards.toString();
	}

	public void add(Card c) {
		cards.add(c);
	}

	public void add(Cards cs) {
		cards.addAll(cs.getCards());
	}

}
