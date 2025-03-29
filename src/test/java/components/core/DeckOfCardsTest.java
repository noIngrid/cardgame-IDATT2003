package components.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DeckOfCardsTest {

  @Test
  void deckInitializationCreates52Cards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getCards().size());
  }

  @Test
  void initializeDeckResetsTo52Cards() {
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand(5);
    deck.initializeDeck();
    assertEquals(52, deck.getCards().size());
  }

  @Test
  void removeCardReducesDeckSize() {
    DeckOfCards deck = new DeckOfCards();
    PlayingCard card = deck.getCardFromIndex(0);
    deck.removeCard(card);
    assertEquals(51, deck.getCards().size());
  }

  @Test
  void getCardFromIndexReturnsCorrectCard() {
    DeckOfCards deck = new DeckOfCards();
    PlayingCard card = deck.getCardFromIndex(0);
    assertEquals('S', card.getSuit());
    assertEquals(1, card.getFace());
  }

  @Test
  void dealHandReducesDeckSize() {
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand(5);
    assertEquals(47, deck.getCards().size());
  }

  @Test
  void dealHandReturnsCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(5);
    assertEquals(5, hand.size());
  }

  @Test
  void getCardsAsStringReturnsCorrectFormat() {
    DeckOfCards deck = new DeckOfCards();
    PlayingCard card = deck.getCardFromIndex(0);
    assertEquals("S1", deck.getCardsAsString(card));
  }
}