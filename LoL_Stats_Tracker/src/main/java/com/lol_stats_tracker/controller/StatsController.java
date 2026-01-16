package com.lol_stats_tracker.controller;

import com.lol_stats_tracker.api.RiotApiClient;
import com.lol_stats_tracker.model.ChampionMastery;
import com.lol_stats_tracker.model.Player;
import java.util.List;


public class StatsController
{



        public Player searchPlayer (String gameName,String tagLine)
        {
            Player player = RiotApiClient.getPlayer(gameName,tagLine);

            if(player == null)
            {
                return  null;
            }

            RiotApiClient.getSummonnerInfo(player);
            return player;
        }

        public List<ChampionMastery> getTopChampions(String puuid,int count)
        {
            return RiotApiClient.getTopChampions(puuid, count);
        }

    public String formatPlayerStats(Player player, List<ChampionMastery> champions)
    {
        StringBuilder result = new StringBuilder();
        result.append("═══════════════════════════\n");
        result.append("Player: ").append(player.getGameName())
                .append("#").append(player.getTagLine()).append("\n");
        result.append("Level: ").append(player.getSummonerLevel()).append("\n");
        result.append("═══════════════════════════\n\n");
        result.append("Top 10 Champions:\n\n");

        for (int i = 0; i < champions.size(); i++)
        {
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
