public class Main
{

  public static void main(String [] args)
  {
	  int n = Integer.parseInt(args[0]);
	  while(n > 0) {
		  Game.play();
		  n--;
	  }
	  StatTracker.report();
	  WarLogger.getInstance().release();
  }

}
