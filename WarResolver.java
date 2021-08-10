public class WarResolver {

	public static void resolve(Player p1, Player p2) {
		boolean playerWonWar = false;
		boolean countedDoubleWar = false;
		while(!(p1.hasNoMoreCards() || p2.hasNoMoreCards() || playerWonWar)) {
			Card p1Card = p1.flip1();
			Card p2Card = p2.flip1();
			CardsInPlay.add(p1Card, p1);
			CardsInPlay.add(p2Card, p2);
			if(p1Card.getValue() > p2Card.getValue()) {
				WarLogger.getInstance().logWarOutcome(StatTracker.getWarNumber(), WarLogger.P1);
				CardsInPlay.giveToPlayer(p1);
				playerWonWar = true;
			}
			else if(p1Card.getValue() < p2Card.getValue()) {
				WarLogger.getInstance().logWarOutcome(StatTracker.getWarNumber(), WarLogger.P2);
				CardsInPlay.giveToPlayer(p2);
				playerWonWar = true;
			}
			else {
				if(countedDoubleWar == false) {
					countedDoubleWar = true;
					StatTracker.addDoubleWar();
				}
			}
		}
		if(p1.hasNoMoreCards() && p2.hasNoMoreCards()) {
			return;
		}
		else if(p2.hasNoMoreCards()) {
			CardsInPlay.giveToPlayer(p1);
		}
		else {
			CardsInPlay.giveToPlayer(p2);
		}
	}

}
