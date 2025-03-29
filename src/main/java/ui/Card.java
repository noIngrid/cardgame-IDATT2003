package ui;

import components.core.PlayingCard;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card {

  public static StackPane createCard(PlayingCard card) {
    StackPane cardPane = new StackPane();
    cardPane.setPrefSize(100, 140);

    Rectangle cardBackground = new Rectangle(100, 140);
    cardBackground.setArcWidth(20);
    cardBackground.setArcHeight(20);
    cardBackground.setFill(Color.WHITE);
    cardBackground.setStroke(Color.LIGHTGRAY);

    String faceString = switch (card.getFace()) {
      case 1 -> "A";
      case 11 -> "J";
      case 12 -> "Q";
      case 13 -> "K";
      default -> String.valueOf(card.getFace());
    };

    char cardSuit = card.getSuit();
    String suitImagePath = "/icons/" + cardSuit + ".png";
    Image suitImage = new Image(Card.class.getResourceAsStream(suitImagePath));
    ImageView suitImageView = new ImageView(suitImage);
    suitImageView.setFitHeight(30);
    suitImageView.setPreserveRatio(true);

    Text label = new Text(faceString);
    label.setFont(Font.font("Arial", 24));
    label.setFill((card.getSuit() == 'H' || card.getSuit() == 'D')
        ? Color.RED : Color.BLACK);

    VBox cardContent = new VBox(5, label, suitImageView);
    cardContent.setAlignment(Pos.CENTER);

    cardPane.getChildren().addAll(cardBackground, cardContent);
    return cardPane;
  }
}
