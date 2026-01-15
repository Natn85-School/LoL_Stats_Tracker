package com.lol_stats_tracker.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreditsGui {

    private Stage primaryStage;

    public CreditsGui(Stage primaryStage) {
        this.primaryStage = primaryStage;
        show();
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
            logoView.setFitHeight(80);
            logoView.setPreserveRatio(true);
            logoBox.getChildren().add(logoView);
        } catch (Exception e) {
            e.printStackTrace();
            Label appName = new Label("LoL Stats Tracker");
            appName.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");
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

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        Label title = new Label("Credits");
        title.setStyle("-fx-font-size: 56px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        VBox creditsContent = new VBox(30);
        creditsContent.setAlignment(Pos.CENTER);

        Label developersTitle = new Label("Developed by:");
        developersTitle.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label developerN = new Label("Natnael Feleke");
        developerN.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        Label developerA = new Label("Artur Labinstev");
        developerA.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        HBox developersRow = new HBox(40);
        developersRow.setAlignment(Pos.CENTER);
        developersRow.getChildren().addAll(developerN, developerA);

        Label dataSourceTitle = new Label("Data Sources:");
        dataSourceTitle.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label dataSource = new Label("Champion Images: Community Dragon");
        dataSource.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        Label apiSource = new Label("Player Data: Riot Games API");
        apiSource.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        //wir müssen ein disclaimer wegen den Regeln von Riot nutzen
        Label disclaimer = new Label("LoL Stats Tracker isn't endorsed by Riot Games\nand doesn't reflect the views or opinions of Riot Games\nor anyone officially involved in producing or managing League of Legends.");
        disclaimer.setStyle("-fx-font-size: 24px; -fx-text-fill: #5b5a56; -fx-text-alignment: center;");
        disclaimer.setWrapText(true);
        disclaimer.setMaxWidth(800);

        creditsContent.getChildren().addAll(
                developersTitle,
                developersRow,
                dataSourceTitle,
                dataSource,
                apiSource,
                disclaimer
        );


        layout.getChildren().addAll(title, creditsContent);
        root.setCenter(layout);

        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Credits - LoL Stats Tracker");
    }
}