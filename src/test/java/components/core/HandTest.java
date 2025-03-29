package components.core;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

  @Test
  void getDealtHandReturnsCorrectHand() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 3));
    Hand hand = new Hand(cards);
    assertEquals(cards, hand.getDealtHand());
  }

  @Test
  void getHandSumCalculatesCorrectSum() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 3));
    Hand hand = new Hand(cards);
    assertEquals(5, hand.getHandSum());
  }

  @Test
  void getHeartsAsStringReturnsCorrectString() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 3), new PlayingCard('H', 4));
    Hand hand = new Hand(cards);
    assertEquals("H2 H4", hand.getHeartsAsString());
  }

  @Test
  void checkQueenOfSpadesReturnsTrueWhenPresent() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 12));
    Hand hand = new Hand(cards);
    assertTrue(hand.checkQueenOfSpades());
  }

  @Test
  void checkQueenOfSpadesReturnsFalseWhenAbsent() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 3));
    Hand hand = new Hand(cards);
    assertFalse(hand.checkQueenOfSpades());
  }

  @Test
  void checkFlushReturnsTrueForSameSuit() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('H', 3), new PlayingCard('H', 4));
    Hand hand = new Hand(cards);
    assertTrue(hand.checkFlush());
  }

  @Test
  void checkFlushReturnsFalseForDifferentSuits() {
    List<PlayingCard> cards = List.of(new PlayingCard('H', 2), new PlayingCard('S', 3), new PlayingCard('H', 4));
    Hand hand = new Hand(cards);
    assertFalse(hand.checkFlush());
  }
}