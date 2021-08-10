public class StatTracker {
	private static int maxBattles;
	private static int minBattles = Integer.MAX_VALUE;
	private static int maxWars;
	private static int minWars = Integer.MAX_VALUE;
	private static int totalGames;
	private static int totalBattles;
	private static int totalWars;
	private static int totalDoubleWars;
	private static int battlesInCurrentGame;
	private static int warsInCurrentGame;
	private static int doubleWarsInCurrentGame;

	public static void endGame() {
		totalBattles += battlesInCurrentGame;
		totalWars += warsInCurrentGame;
		totalDoubleWars += doubleWarsInCurrentGame;
		totalGames++;
		maxBattles = updateMax(battlesInCurrentGame, maxBattles);
		minBattles = updateMin(battlesInCurrentGame, minBattles);
		maxWars = updateMax(warsInCurrentGame, maxWars);
		minWars = updateMin(warsInCurrentGame, minWars);
		battlesInCurrentGame = 0;
		warsInCurrentGame = 0;
		doubleWarsInCurrentGame = 0;
	}

	private static int updateMax(int a, int b) {
		if(a > b) {
			return a;
		}
		return b;
	}

	private static int updateMin(int a, int b) {
		if(a < b) {
			return a;
		}
		return b;
	}

	public static void addBattles() {
		battlesInCurrentGame++;
	}

	public static void addWar() {
		warsInCurrentGame++;
	}

	public static void addDoubleWar() {
		doubleWarsInCurrentGame++;
	}

	public static int getBattleNumber() {
		return battlesInCurrentGame;
	}

	public static int getWarNumber() {
		return warsInCurrentGame;
	}

	public static int getGameNumber() {
		return totalGames;
	}

	public static double getAvgBattlesPerGame() {
		double avg = (double) totalBattles / totalGames;
		return avg;
	}

	public static double getAvgWarsPerGame() {
		double avg = (double) totalWars / totalGames;
		return avg;
	}

	public static double getAvgDoubleWarsPerGame() {
		double avg = (double) totalDoubleWars / totalGames;
		return avg;
	}

	public static void report() {
		System.out.println("Average battles per game: " + getAvgBattlesPerGame());
		System.out.println("Average wars per game: " + getAvgWarsPerGame());
		System.out.println("Average double wars per game: " + getAvgDoubleWarsPerGame());
		System.out.println("Max battles: " + maxBattles);
		System.out.println("Min battles: " + minBattles);
		System.out.println("Max wars: " + maxWars);
		System.out.println("Min wars: " + minWars);
	}
}
