package components.core;

import java.util.ArrayList;

public class DeckOfCards {
  private final char[] suit = {'S', 'H', 'D', 'C'};
  private ArrayList<PlayingCard> cards;

  public DeckOfCards() {
    cards = new ArrayList<>();
    for (char s : suit) {
      for (int i = 0; i < 13; i++) {
        cards.add(new PlayingCard(s, i + 1));
      }
    }
  }

  public ArrayList<PlayingCard> getCards() {
    return cards;
  }

  public void removeCard(PlayingCard card) {
    cards.remove(card);
  }

  public PlayingCard getCardFromIndex(int index) {
    return cards.get(index);
  }
}
