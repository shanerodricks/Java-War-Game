public class Game {

	private static Player player1;
	private static Player player2;
	private static Deck deck;


	public static void play() {
		Cards p1Hand = new Cards();
	    Cards p2Hand= new Cards();

	    player1 = new Player(1,p1Hand);
	    player2 = new Player(2,p2Hand);

	    deck = new Deck();
	    deck.createNew();
	    deck.dealCards(player1, player2);

	    CardsInPlay.reset();

	    while(!(player1.hasNoMoreCards() || player2.hasNoMoreCards())) {
	    	StatTracker.addBattles();
	    	if(StatTracker.getBattleNumber() > 1000) {
	    		return;
	    	}
	    	CardsInPlay.add(player1.flip3(), player1);
	    	CardsInPlay.add(player2.flip3(), player2);
	    	WarLogger.getInstance().logBattle(StatTracker.getBattleNumber(), WarLogger.P1, CardsInPlay.getP1Cards().toArray());
	    	WarLogger.getInstance().logBattle(StatTracker.getBattleNumber(), WarLogger.P2, CardsInPlay.getP2Cards().toArray());

	        if(CardsInPlay.computeMedianOfAPlayersCards(player1) > CardsInPlay.computeMedianOfAPlayersCards(player2)) {
	        	CardsInPlay.giveToPlayer(player1); // give to player1
	        	WarLogger.getInstance().logBattleOutcome(StatTracker.getBattleNumber(), WarLogger.P1);
	        }
	        else if (CardsInPlay.computeMedianOfAPlayersCards(player1) < CardsInPlay.computeMedianOfAPlayersCards(player2)){
	        	CardsInPlay.giveToPlayer(player2); // give to player2
	        	WarLogger.getInstance().logBattleOutcome(StatTracker.getBattleNumber(), WarLogger.P2);
	        }
	        else {
	    		StatTracker.addWar();
	        	WarLogger.getInstance().logBattleOutcome(StatTracker.getBattleNumber(), WarLogger.WAR);
	        	WarResolver.resolve(player1, player2);
	        }

	    }
	    StatTracker.endGame();
	    if(player1.hasNoMoreCards() && player2.hasNoMoreCards()) {
	    	WarLogger.getInstance().logGameOutcome(StatTracker.getGameNumber(), WarLogger.P1);
	    	WarLogger.getInstance().logGameOutcome(StatTracker.getGameNumber(), WarLogger.P2);
	    }
	    else if(player1.hasNoMoreCards()) {
	    	WarLogger.getInstance().logGameOutcome(StatTracker.getGameNumber(), WarLogger.P2);
	    }
	    else if(player2.hasNoMoreCards()) {
	    	WarLogger.getInstance().logGameOutcome(StatTracker.getGameNumber(), WarLogger.P1);
	    }
	}
}
