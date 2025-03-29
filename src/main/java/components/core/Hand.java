package components.core;

import java.util.List;

public class Hand {

  private final List<PlayingCard> dealtHand;

  public Hand(List<PlayingCard> dealtHand) {
    this.dealtHand = dealtHand;
  }

  public List<PlayingCard> getDealtHand() {
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
      if (card.getAsString().equals("S12")) {
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
