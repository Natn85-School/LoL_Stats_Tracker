package com.lol_stats_tracker.api;



import com.lol_stats_tracker.model.ChampionMastery;
import com.lol_stats_tracker.model.Player;

import java.util.List;

import static java.lang.System.out;


public class TestApi
{

    public static void main ( String[] args)
    {
        String gameName = "unlmtd";
        String tagline = "IIIII";

        Player player = RiotApiClient.getPlayer(gameName,tagline);

        if(player == null)
        {
            System.out.println(" null ");
            return ;
        }

                System.out.println("Info ");
                System.out.println("Name " + player.getGameName());
                System.out.println("tag " + player.getTagLine());
                System.out.println("PUUID: " + player.getPuuid());

                    RiotApiClient.getSumonnerInfo(player);

                    System.out.println("level" +  player.getSummonerLevel());

                    List<ChampionMastery> champions = RiotApiClient.getTopChampions(player.getPuuid(),10);

                System.out.println("Top 10 champ ");

                        for(int i = 0 ; i < champions.size();i++)
                        {
                                ChampionMastery m = champions.get(i);


                            System.out.printf("%2d. Champion ID: %d | Level: %d | Points: %,d%n", i + 1,m.getChampionId() , m.getChampionLevel(),m.getChampionPoints());
                        }




    }
}
