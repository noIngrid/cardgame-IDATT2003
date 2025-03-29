package ui;

import components.core.Hand;
import components.core.PlayingCard;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HandView {

  public static Pane createHandView(Hand hand) {
    HBox handContainer = new HBox(10);
    for (PlayingCard card : hand.getDealtHand()) {
      handContainer.getChildren().add(Card.createCard(card));
    }
    return handContainer;
  }
}
