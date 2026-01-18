package com.lol_stats_tracker.controller;

import java.util.List;

public class HomepageController
{

    public List<String> getMenuItems()
    {
        return List.of(
                "Champion List",
                "Team Generator",
                "Player Stats",
                "Credits"
        );
    }

    public String getWelcomeTitle()
    {
        return "Welcome to LoL Stats Tracker";
    }

    public String getWelcomeSubtitle()
    {
        return "Your Ultimate League of Legends Companion";
    }

    public void handleMenuAction(String menuTitle, javafx.stage.Stage stage)
    {
        switch (menuTitle)
        {
            case "Champion List" -> new com.lol_stats_tracker.gui.ChampionListGui(stage);
            case "Player Stats" -> new com.lol_stats_tracker.gui.PlayerStatsGui(stage);
            case "Credits" -> new com.lol_stats_tracker.gui.CreditsGui(stage);
            case "Team Generator" -> new com.lol_stats_tracker.gui.TeamGeneratorGui(stage);
        }
    }
}
