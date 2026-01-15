package com.lol_stats_tracker.gui;

import com.lol_stats_tracker.controller.StatsController;
import com.lol_stats_tracker.model.ChampionMastery;
import com.lol_stats_tracker.model.Player;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class PlayerStatsGui
{

    private Stage stage;
    private StatsController controller;

    public PlayerStatsGui(Stage stage)
    {
        this.stage = stage;
        this.controller = new StatsController();
        showPlayerStatsScreen();
    }

    private HBox createTopBanner() {
        HBox banner = new HBox();
        banner.setAlignment(Pos.CENTER_LEFT);
        banner.setPadding(new Insets(30, 40, 30, 40));
        banner.setStyle("-fx-background-color: #010a13; -fx-border-color: #c89b3c; -fx-border-width: 0 0 2 0;");
        banner.setMinHeight(140);

        Button backButton = new Button("← Back");
        backButton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #c89b3c;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 10 30 10 30;"
        );

        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 10 30 10 30;" +
                        "-fx-background-radius: 3;"
        ));

        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #c89b3c;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 10 30 10 30;"
        ));

        backButton.setOnAction(e -> new HomepageGui(stage));
        banner.getChildren().add(backButton);

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer);

        Label title = new Label("Player Stats Viewer");
        title.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");
        banner.getChildren().add(title);

        HBox spacer2 = new HBox();
        HBox.setHgrow(spacer2, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer2);

        return banner;
    }

    private void showPlayerStatsScreen() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner());

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        // Поля ввода
        VBox inputBox = new VBox(20);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(600);

        Label nameLabel = new Label("Summoner Name:");
        nameLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #c89b3c;");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter name (e.g., Faker)");
        nameField.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 20px;" +
                        "-fx-padding: 15;" +
                        "-fx-background-radius: 5;"
        );

        Label tagLabel = new Label("Tag:");
        tagLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #c89b3c;");

        TextField tagField = new TextField();
        tagField.setPromptText("Enter tag (e.g., EUW)");
        tagField.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 20px;" +
                        "-fx-padding: 15;" +
                        "-fx-background-radius: 5;"
        );

        Button searchButton = createSearchButton();

        // Область для результатов
        VBox resultsBox = new VBox(20);
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-padding: 30;" +
                        "-fx-background-radius: 10;"
        );
        resultsBox.setMaxWidth(800);
        resultsBox.setVisible(false);

        Label resultsLabel = new Label();
        resultsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #f0e6d2;");
        resultsLabel.setWrapText(true);

        resultsBox.getChildren().add(resultsLabel);

        // Обработчик кнопки
        searchButton.setOnAction(e -> handleSearch(nameField, tagField, resultsBox, resultsLabel));

        inputBox.getChildren().addAll(nameLabel, nameField, tagLabel, tagField, searchButton);

        layout.getChildren().addAll(inputBox, resultsBox);

        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #0a1428; -fx-background-color: #0a1428;");

        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 1200, 900);
        stage.setScene(scene);
        stage.show();
    }

    private Button createSearchButton() {
        Button button = new Button("Search Player");
        button.setStyle(
                "-fx-background-color: #c89b3c;" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 300px;" +
                        "-fx-min-height: 70px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #f0e6d2;" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 300px;" +
                        "-fx-min-height: 70px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: #c89b3c;" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 300px;" +
                        "-fx-min-height: 70px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        ));

        return button;
    }

    private void handleSearch(TextField nameField, TextField tagField, VBox resultsBox, Label resultsLabel) {
        String name = nameField.getText().trim();
        String tag = tagField.getText().trim();

        if (name.isEmpty() || tag.isEmpty()) {
            resultsLabel.setText("Please enter both name and tag!");
            resultsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff4444;");
            resultsBox.setVisible(true);
            return;
        }

        resultsLabel.setText("Searching...");
        resultsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #c89b3c;");
        resultsBox.setVisible(true);

        // Поиск в отдельном потоке
        new Thread(() ->
        {
            Player player = controller.searchPlayer(name, tag);

            Platform.runLater(() -> {
                if (player == null) {
                    resultsLabel.setText("Player not found! Check the name and tag.");
                    resultsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff4444;");
                } else {
                    List<ChampionMastery> champions = controller.getTopChampions(player.getPuuid(), 10);

                    StringBuilder result = new StringBuilder();
                    result.append("═══════════════════════════\n");
                    result.append("Player: ").append(player.getGameName())
                            .append("#").append(player.getTagLine()).append("\n");
                    result.append("Level: ").append(player.getSummonerLevel()).append("\n");
                    result.append("═══════════════════════════\n\n");
                    result.append("Top 10 Champions:\n\n");

                    for (int i = 0; i < champions.size(); i++) {
                        ChampionMastery m = champions.get(i);
                        result.append(String.format("%2d. Champion Name: %s | Level: %d | Points: %,d\n",
                                i + 1, m.getChampionName(), m.getChampionLevel(), m.getChampionPoints()));
                    }

                    resultsLabel.setText(result.toString());
                    resultsLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #f0e6d2;");
                }
            });
        }).start();
    }
}