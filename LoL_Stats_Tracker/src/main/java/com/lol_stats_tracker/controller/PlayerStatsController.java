package com.lol_stats_tracker.controller;

import com.lol_stats_tracker.model.ChampionMastery;
import com.lol_stats_tracker.model.Player;
import java.util.List;
import java.util.function.Consumer;

public class PlayerStatsController {
    private StatsController statsController;
    private Consumer<Player> playerFoundCallback;

    public PlayerStatsController(Consumer<Player> playerFoundCallback) {
        this.statsController = new StatsController();
        this.playerFoundCallback = playerFoundCallback;
    }

    public void searchPlayer(String name, String tag) {
        new Thread(() -> {
            Player player = statsController.searchPlayer(name, tag);
            playerFoundCallback.accept(player);
        }).start();
    }

    public List<ChampionMastery> getTopChampions(String puuid, int count) {
        return statsController.getTopChampions(puuid, count);
    }

    public String formatPlayerStats(Player player, List<ChampionMastery> champions) {
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

        return result.toString();
    }

    public boolean validateInput(String name, String tag) {
        return !name.isEmpty() && !tag.isEmpty();
    }
}