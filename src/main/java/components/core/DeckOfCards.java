package components.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  private final ArrayList<PlayingCard> cards;
  Random random = new Random();

  public DeckOfCards() {
    cards = new ArrayList<>();
    char[] suit = {'S', 'H', 'D', 'C'};
    for (char s : suit) {
      for (int i = 0; i < 13; i++) {
        cards.add(new PlayingCard(s, i + 1));
      }
    }
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public void removeCard(PlayingCard card) {
    cards.remove(card);
  }

  public PlayingCard getCardFromIndex(int index) {
    return cards.get(index);
  }

  public List<PlayingCard> dealHand(int n) {
    ArrayList<PlayingCard> hand = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int cardIndex = random.nextInt(cards.size());
      hand.add(cards.get(cardIndex));
      cards.remove(cardIndex);
    }
    return hand;
  }

  public String getCardsAsString(PlayingCard card) {
    return card.getAsString();
  }
}
