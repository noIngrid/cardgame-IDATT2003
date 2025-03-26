package components.core;

import java.util.ArrayList;

public class Hand {

  private final ArrayList<PlayingCard> dealtHand = new ArrayList<>();

  public Hand(ArrayList<PlayingCard> hand) {
    this.dealtHand.addAll(hand);
  }

  public ArrayList<PlayingCard> getDealtHand() {
    return dealtHand;
  }

  public int getHandSum() {
    int sum = 0;
    for (PlayingCard card : dealtHand) {
      sum += card.getFace();
    }
    return sum;
  }

  public String getHeartsAsString() {
    StringBuilder builder = new StringBuilder();
    for (PlayingCard card : dealtHand) {
      if (card.getSuit() == 'H') {
        builder.append(card.getAsString()).append(" ");
      }
    }
    return builder.toString().trim();
  }

  public boolean checkQueenOfSpades() {
    for (PlayingCard card : dealtHand) {
      if (card.getAsString().equals("SQ")) {
        return true;
      }
    }
    return false;
  }

  public boolean checkFlush() {
    char suit = dealtHand.getFirst().getSuit();
    for (PlayingCard card : dealtHand) {
      if (card.getSuit() != suit) {
        return false;
      }
    }
    return true;
  }

}
