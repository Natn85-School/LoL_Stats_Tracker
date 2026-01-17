package com.lol_stats_tracker.gui;

import com.lol_stats_tracker.controller.TeamGeneratorController;
import com.lol_stats_tracker.model.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeamGeneratorGui {

    private Stage stage;
    private VBox resultsBox;
    private Label resultsLabel;
    private TeamGeneratorController controller = new TeamGeneratorController();

    public TeamGeneratorGui(Stage stage)
    {
        this.stage = stage;
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

        backButton.setOnAction(e -> new HomepageGui(stage));
        banner.getChildren().add(backButton);

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        banner.getChildren().add(spacer);

        Label title = new Label("Team Generator");
        title.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");
        banner.getChildren().add(title);

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

        VBox inputBox = createInputBox();

        resultsBox = new VBox(20);
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-padding: 30;" +
                        "-fx-background-radius: 10;"
        );
        resultsBox.setMaxWidth(800);
        resultsBox.setVisible(false);

        resultsLabel = new Label();
        resultsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #f0e6d2;");
        resultsLabel.setWrapText(true);

        resultsBox.getChildren().add(resultsLabel);

        layout.getChildren().addAll(inputBox, resultsBox);

        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #0a1428; -fx-background-color: #0a1428;");

        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 1200, 900);
        stage.setScene(scene);
        stage.show();
    }

    private VBox createInputBox() {
        VBox inputBox = new VBox(20);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(600);

        Label champLabel = new Label("Champion Name:");
        champLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #c89b3c;");

        TextField champField = new TextField();
        champField.setPromptText("Enter champion name (e.g., Pyke)");
        champField.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 20px;" +
                        "-fx-padding: 15;" +
                        "-fx-background-radius: 5;"
        );

        Label roleLabel = new Label("Role:");
        roleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #c89b3c;");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Top", "Jungle", "Mid", "ADC", "Support");
        roleBox.setPromptText("Select role");
        roleBox.setStyle(
                "-fx-background-color: #1e2328;" +
                        "-fx-font-size: 20px;"
        );
        roleBox.setMaxWidth(Double.MAX_VALUE);

        Button generateButton = createGenerateButton();
        generateButton.setOnAction(e -> handleGenerate(champField.getText(), roleBox.getValue()));

        inputBox.getChildren().addAll(champLabel, champField, roleLabel, roleBox, generateButton);
        return inputBox;
    }

    private Button createGenerateButton() {
        Button button = new Button("Generate Team");
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

    private void handleGenerate(String championName, String role)
    {
        Team team = controller.generateTeam(championName, role);
        resultsLabel.setText(controller.teamToString(team));
        resultsBox.setVisible(true);


    }
}