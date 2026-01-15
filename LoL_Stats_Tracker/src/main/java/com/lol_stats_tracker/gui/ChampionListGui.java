package com.lol_stats_tracker.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.lol_stats_tracker.controller.ChampionController;
import com.lol_stats_tracker.model.Champion;
import java.util.List;

public class ChampionListGui {

    private Stage primaryStage;
    private FlowPane championGrid;
    private TextField searchField;
    private Label countLabel;
    private ChampionController championController;
    private static Image loadingGif;

    public ChampionListGui(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.championController = new ChampionController(this::handleChampionClick);
        loadLoadingGif();
        show();
    }

    private static void loadLoadingGif() {
        if (loadingGif == null) {
            try {
                loadingGif = new Image("/loading.gif");
            } catch (Exception e) {
                System.out.println("Loading GIF not found, using placeholder");
            }
        }
    }

    private HBox createTopBanner() {
        HBox banner = new HBox();
        banner.setAlignment(Pos.CENTER_LEFT);
        banner.setPadding(new Insets(15, 20, 15, 20));
        banner.setStyle("-fx-background-color: #010a13; -fx-border-color: #c89b3c; -fx-border-width: 0 0 2 0;");
        banner.setMinHeight(70);

        Button backButton = new Button("← Back");
        backButton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #c89b3c;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5 15 5 15;"
        );

        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5 15 5 15;" +
                        "-fx-background-radius: 3;"
        ));

        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #c89b3c;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5 15 5 15;"
        ));

        backButton.setOnAction(e -> new HomepageGui(primaryStage));
        banner.getChildren().add(backButton);

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer);

        HBox logoBox = new HBox(10);
        logoBox.setAlignment(Pos.CENTER);

        try {
            Image logo = new Image(getClass().getResourceAsStream("/logo.png"));
            ImageView logoView = new ImageView(logo);
            logoView.setFitHeight(40);
            logoView.setPreserveRatio(true);
            logoBox.getChildren().add(logoView);
        } catch (Exception e) {
            Label appName = new Label("LoL Stats Tracker");
            appName.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");
            logoBox.getChildren().add(appName);
        }

        banner.getChildren().add(logoBox);

        HBox spacer2 = new HBox();
        HBox.setHgrow(spacer2, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer2);

        return banner;
    }

    public void show() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner());

        VBox contentArea = new VBox(15);
        contentArea.setPadding(new Insets(20));
        contentArea.setStyle("-fx-background-color: #0a1428;");

        Label title = new Label("Champion List");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        countLabel = new Label(championController.getTotalChampionCount() + " Champions");
        countLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #a09b8c;");

        searchField = new TextField();
        searchField.setPromptText("Search champions...");
        searchField.setMaxWidth(400);
        searchField.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-prompt-text-fill: #5b5a56;" +
                        "-fx-font-size: 14px;" +
                        "-fx-padding: 10;" +
                        "-fx-background-radius: 5;"
        );
        searchField.textProperty().addListener((obs, oldVal, newVal) -> filterChampions(newVal));

        VBox headerBox = new VBox(10);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.getChildren().addAll(title, countLabel, searchField);

        contentArea.getChildren().add(headerBox);

        championGrid = new FlowPane();
        championGrid.setHgap(15);
        championGrid.setVgap(15);
        championGrid.setPadding(new Insets(20));
        championGrid.setAlignment(Pos.CENTER);
        championGrid.setStyle("-fx-background-color: #0a1428;");

        populateChampions(championController.getAllChampions());

        ScrollPane scrollPane = new ScrollPane(championGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #0a1428; -fx-background-color: #0a1428;");
        VBox.setVgrow(scrollPane, javafx.scene.layout.Priority.ALWAYS);

        contentArea.getChildren().add(scrollPane);
        root.setCenter(contentArea);

        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Champion List - LoL Stats Tracker");
    }

    private void populateChampions(List<Champion> champions) {
        championGrid.getChildren().clear();

        for (Champion champion : champions) {
            VBox championCard = createChampionCard(champion);
            championGrid.getChildren().add(championCard);
        }
    }

    private VBox createChampionCard(Champion champion) {
        VBox card = new VBox(8);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: #785a28;" +
                        "-fx-border-radius: 8;" +
                        "-fx-border-width: 2;" +
                        "-fx-cursor: hand;"
        );
        card.setMaxWidth(120);
        card.setMaxHeight(150);

        ImageView championImage = new ImageView();
        championImage.setFitWidth(80);
        championImage.setFitHeight(80);
        championImage.setPreserveRatio(true);

        if (loadingGif != null) {
            championImage.setImage(loadingGif);
        }

        Image image = new Image(champion.getImageUrl(), true);
        image.progressProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() >= 1.0) {
                championImage.setImage(image);
            }
        });

        Label nameLabel = new Label(champion.getName());
        nameLabel.setStyle(
                "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;"
        );
        nameLabel.setWrapText(true);
        nameLabel.setMaxWidth(100);
        nameLabel.setAlignment(Pos.CENTER);

        card.getChildren().addAll(championImage, nameLabel);

        card.setOnMouseEntered(e -> card.setStyle(
                "-fx-background-color: #2a2f35;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: #c89b3c;" +
                        "-fx-border-radius: 8;" +
                        "-fx-border-width: 2;" +
                        "-fx-cursor: hand;"
        ));

        card.setOnMouseExited(e -> card.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: #785a28;" +
                        "-fx-border-radius: 8;" +
                        "-fx-border-width: 2;" +
                        "-fx-cursor: hand;"
        ));

        card.setOnMouseClicked(e -> championController.handleChampionClick(champion));

        return card;
    }

    private void filterChampions(String searchText) {
        List<Champion> filtered = championController.filterChampions(searchText);
        countLabel.setText(filtered.size() + " Champions");
        populateChampions(filtered);
    }

    private void handleChampionClick(Champion champion) {
    }
}