package components.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void creatingCardWithValidSuitAndFace() {
    PlayingCard card = new PlayingCard('H', 5);
    assertEquals('H', card.getSuit());
    assertEquals(5, card.getFace());
  }

  @Test
  void creatingCardWithInvalidSuitThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 5));
  }

  @Test
  void creatingCardWithInvalidFaceThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 0));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 14));
  }

  @Test
  void getAsStringReturnsCorrectFormat() {
    PlayingCard card = new PlayingCard('D', 10);
    assertEquals("D10", card.getAsString());
  }

  @Test
  void equalsReturnsTrueForSameSuitAndFace() {
    PlayingCard card1 = new PlayingCard('C', 7);
    PlayingCard card2 = new PlayingCard('C', 7);
    assertEquals(card1, card2);
  }

  @Test
  void equalsReturnsFalseForDifferentSuitOrFace() {
    PlayingCard card1 = new PlayingCard('S', 9);
    PlayingCard card2 = new PlayingCard('H', 9);
    PlayingCard card3 = new PlayingCard('S', 10);
    assertNotEquals(card1, card2);
    assertNotEquals(card1, card3);
  }

  @Test
  void hashCodeIsConsistentWithEquals() {
    PlayingCard card1 = new PlayingCard('D', 3);
    PlayingCard card2 = new PlayingCard('D', 3);
    assertEquals(card1.hashCode(), card2.hashCode());
  }
}