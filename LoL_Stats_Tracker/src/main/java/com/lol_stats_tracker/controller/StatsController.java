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

            RiotApiClient.getSumonnerInfo(player);
            return player;
        }

        public List<ChampionMastery> getTopChampions(String puuid,int count)
        {
            return RiotApiClient.getTopChampions(puuid, count);
        }
}
