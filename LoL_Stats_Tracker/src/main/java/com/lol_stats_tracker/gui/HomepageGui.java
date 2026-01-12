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
import javafx.scene.control.ScrollPane;

public class HomepageGui
{

    private Stage primaryStage;

    public HomepageGui(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(true);
        showHomepage();
    }

    private HBox createTopBanner(boolean showBackButton)
    {
        HBox banner = new HBox();
        banner.setAlignment(Pos.CENTER_LEFT);
        banner.setPadding(new Insets(30, 40, 30, 40));
        banner.setStyle("-fx-background-color: #010a13; -fx-border-color: #c89b3c; -fx-border-width: 0 0 2 0;");
        banner.setMinHeight(140);

        if (showBackButton)
        {
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

            backButton.setOnAction(e -> showHomepage());
            banner.getChildren().add(backButton);
        }

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer);

        HBox logoBox = new HBox(10);
        logoBox.setAlignment(Pos.CENTER);

        try
        {
            Image logo = new Image(getClass().getResourceAsStream("/League_of_Legends_logo.png"));
            ImageView logoView = new ImageView(logo);
            logoView.setFitHeight(80);
            logoView.setPreserveRatio(true);
            logoBox.getChildren().add(logoView);
        } catch (Exception e)
        {
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

    private void showHomepage()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner(false));

        VBox layout = new VBox(50);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        VBox welcomeSection = new VBox(20);
        welcomeSection.setAlignment(Pos.CENTER);

        Label welcome = new Label("Welcome to LoL Stats Tracker");
        welcome.setStyle("-fx-font-size: 64px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label subtitle = new Label("Your Ultimate League of Legends Companion");
        subtitle.setStyle("-fx-font-size: 32px; -fx-text-fill: #a09b8c;");

        welcomeSection.getChildren().addAll(welcome, subtitle);

        VBox buttonBox = new VBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(60, 0, 0, 0));

        Button championListButton = createStyledButton("Champion List", "#c89b3c");
        Button teamGenButton = createStyledButton("Team Generator", "#c89b3c");
        Button playerStatsButton = createStyledButton("Player Stats", "#c89b3c");
        Button creditsButton = createStyledButton("Credits", "#785a28");

        championListButton.setOnAction(e -> showChampionListScreen());
        teamGenButton.setOnAction(e -> showTeamGeneratorScreen());
        playerStatsButton.setOnAction(e -> showPlayerStatsScreen());
        creditsButton.setOnAction(e -> showCreditsScreen());

        buttonBox.getChildren().addAll(championListButton, teamGenButton, playerStatsButton, creditsButton);

        layout.getChildren().addAll(welcomeSection, buttonBox);


        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #0a1428; -fx-background-color: #0a1428;");

        root.setCenter(scrollPane);

        // Scene scene = new Scene(root, 1600, 1200);
        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setTitle("LoL Stats Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text, String color)
    {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 500px;" +
                        "-fx-min-height: 100px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #f0e6d2;" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 500px;" +
                        "-fx-min-height: 100px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-min-width: 500px;" +
                        "-fx-min-height: 100px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand;"
        ));

        return button;
    }

    private void showChampionListScreen()
    {
        new ChampionListGui(primaryStage);
    }

    private void showTeamGeneratorScreen()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner(true));

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        Label title = new Label("Team Generator");
        title.setStyle("-fx-font-size: 56px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label placeholder = new Label("Team composition generator coming soon...");
        placeholder.setStyle("-fx-font-size: 32px; -fx-text-fill: #a09b8c;");

        layout.getChildren().addAll(title, placeholder);
        root.setCenter(layout);

        //Scene scene = new Scene(root, 1600, 1200);
        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
    }

    private void showPlayerStatsScreen()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner(true));

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        Label title = new Label("Player Stats Viewer");
        title.setStyle("-fx-font-size: 56px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label placeholder = new Label("Player statistics coming soon...");
        placeholder.setStyle("-fx-font-size: 32px; -fx-text-fill: #a09b8c;");

        layout.getChildren().addAll(title, placeholder);
        root.setCenter(layout);

        // Scene scene = new Scene(root, 1600, 1200);
        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
    }

    private void showCreditsScreen()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner(true));

        VBox layout = new VBox(40);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(80));

        Label title = new Label("Credits");
        title.setStyle("-fx-font-size: 56px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        VBox creditsContent = new VBox(30);
        creditsContent.setAlignment(Pos.CENTER);

        Label developed = new Label("Developed by: [Your Name]");
        developed.setStyle("-fx-font-size: 32px; -fx-text-fill: #a09b8c;");

        Label dataSource = new Label("Champion Images: Community Dragon");
        dataSource.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        Label apiSource = new Label("Player Data: Riot Games API");
        apiSource.setStyle("-fx-font-size: 28px; -fx-text-fill: #a09b8c;");

        Label disclaimer = new Label("LoL Stats Tracker isn't endorsed by Riot Games\nand doesn't reflect the views or opinions of Riot Games\nor anyone officially involved in producing or managing League of Legends.");
        disclaimer.setStyle("-fx-font-size: 24px; -fx-text-fill: #5b5a56; -fx-text-alignment: center;");
        disclaimer.setWrapText(true);
        disclaimer.setMaxWidth(800);

        creditsContent.getChildren().addAll(developed, dataSource, apiSource, disclaimer);

        layout.getChildren().addAll(title, creditsContent);
        root.setCenter(layout);

        // Scene scene = new Scene(root, 1600, 1200);
        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
    }
}