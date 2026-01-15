package com.lol_stats_tracker.gui;

import com.lol_stats_tracker.controller.HomepageController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomepageGui {

    private final Stage stage;
    private final HomepageController controller;

    public HomepageGui(Stage stage) {
        this.stage = stage;
        this.controller = new HomepageController();
        show();
    }

    private void show() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #0a1428;");

        root.setTop(createTopBanner());

        VBox content = new VBox(50);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(80));

        Label title = new Label(controller.getWelcomeTitle());
        title.setStyle("-fx-font-size: 64px; -fx-font-weight: bold; -fx-text-fill: #c89b3c;");

        Label subtitle = new Label(controller.getWelcomeSubtitle());
        subtitle.setStyle("-fx-font-size: 32px; -fx-text-fill: #a09b8c;");

        VBox buttons = new VBox(30);
        buttons.setAlignment(Pos.CENTER);

        for (String item : controller.getMenuItems()) {
            Button btn = createButton(item, "#c89b3c");
            btn.setOnAction(e -> controller.handleMenuAction(item, stage));
            buttons.getChildren().add(btn);
        }

        content.getChildren().addAll(title, subtitle, buttons);

        ScrollPane scroll = new ScrollPane(content);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: #0a1428;");

        root.setCenter(scroll);

        stage.setScene(new Scene(root));
        stage.setTitle("LoL Stats Tracker");
        stage.show();
    }

    private HBox createTopBanner() {
        HBox banner = new HBox();
        banner.setPadding(new Insets(30, 40, 30, 40));
        banner.setAlignment(Pos.CENTER);
        banner.setStyle("-fx-background-color: #010a13; -fx-border-color: #c89b3c; -fx-border-width: 0 0 2 0;");

        try {
            ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/logo.png")));
            logo.setFitHeight(80);
            logo.setPreserveRatio(true);
            banner.getChildren().add(logo);
        } catch (Exception e) {
            Label fallback = new Label("LoL Stats Tracker");
            fallback.setStyle("-fx-font-size: 36px; -fx-text-fill: #c89b3c;");
            banner.getChildren().add(fallback);
        }

        return banner;
    }

    private Button createButton(String text, String color) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: #0a1428;" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 20 80;" +
                        "-fx-cursor: hand;"
        );
        return button;
    }
}