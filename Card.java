public class Card{

  public int value;
  public String suit;

  public Card(int value, String suit)
  {
    this.value = value;
    this.suit = suit;
  }

//^^overloaded constructor

  public String toString(){
    String result = "";
    result = result + value + suit;
    return result;
  }


  public String getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }
}
