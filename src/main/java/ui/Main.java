package ui;

import components.core.DeckOfCards;
import components.core.Hand;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  private final DeckOfCards deck = new DeckOfCards();
  private VBox root = new VBox();
  private Pane cardView;
  private Label sumLabel;
  private Label flushLabel;
  private Label queenOfSpadesLabel;
  private Label heartsLabel;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    root = new VBox(15);
    root.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0;");

    Button dealButton = new Button("Deal cards");
    dealButton.setOnAction(e -> {
      try {
        dealHand();
      } catch (Exception ex) {
        sumLabel.setText("Error dealing cards, reset deck and try again.");
      }
    });

    Button resetDeckButton = new Button("Reset Deck");
    resetDeckButton.setOnAction(e -> {
      deck.initializeDeck();
      sumLabel.setText("Deck reset. Click 'Deal cards' to deal a new hand.");
    });

    sumLabel = new Label();
    flushLabel = new Label();
    queenOfSpadesLabel = new Label();
    heartsLabel = new Label();

    root.getChildren().addAll(dealButton, resetDeckButton);
    root.getChildren().addAll(sumLabel, flushLabel, queenOfSpadesLabel, heartsLabel);

    dealHand();

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void dealHand() {
    Hand hand = new Hand(deck.dealHand(5));

    if (cardView != null) {
      root.getChildren().remove(cardView);
    }

    cardView = HandView.createHandView(hand);
    root.getChildren().add(cardView);

    sumLabel.setText("Sum of hand: " + hand.getHandSum());
    flushLabel.setText("Flush: " + (hand.checkFlush() ? "Yes" : "No"));
    queenOfSpadesLabel.setText("Queen of Spades: " + (hand.checkQueenOfSpades() ? "Yes" : "No"));
    heartsLabel.setText("Hearts in hand: " + hand.getHeartsAsString());
  }


  @Override
  public void init() throws Exception {
    super.init();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
  }
}