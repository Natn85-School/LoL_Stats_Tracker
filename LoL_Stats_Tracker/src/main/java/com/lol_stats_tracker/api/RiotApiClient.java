package com.lol_stats_tracker.api;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lol_stats_tracker.model.Champion;
import com.lol_stats_tracker.model.Player;
import com.lol_stats_tracker.model.ChampionMastery;
import com.lol_stats_tracker.api.ChampionDataService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



//client  durch id und #
public class RiotApiClient {

    public static final Gson gson = new Gson();

    public static Player getPlayer(String gameName, String tagline) {
        try {
            String urlString = "https://" + ApiConfig.REGION + ".api.riotgames.com" + "/riot/account/v1/accounts/by-riot-id/" +
                    gameName + "/" + tagline;


            String json = makeRequest(urlString);
            if (json == null) {
                return null;

            }

            return gson.fromJson(json, Player.class);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //summ inffo
    public static void getSumonnerInfo(Player player) {
        try {

            String urlString = "https://" + ApiConfig.PLATFORM + ".api.riotgames.com" + "/lol/summoner/v4/summoners/by-puuid/" + player.getPuuid();

            String json = makeRequest(urlString);
            if (json == null) {
                return;

            }

            JsonObject summonerData = gson.fromJson(json, JsonObject.class);

            player.setSummonerId(player.getPuuid());
            player.setSummonerLevel(Integer.parseInt(summonerData.get("summonerLevel").getAsString()));


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    // top champ
    public static List<ChampionMastery> getTopChampions(String puuid, int count)
    {
        List<ChampionMastery> champlist = new ArrayList<>();

        try {
            String urlString = "https://" + ApiConfig.PLATFORM + ".api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-puuid/" + puuid + "/top?count=" + count;

            String json = makeRequest(urlString);
            if (json == null) {
                return champlist;

            }
            JsonArray array = gson.fromJson(json, JsonArray.class);

            for (int i = 0; i < array.size(); i++)
            {


                JsonObject object = array.get(i).getAsJsonObject();
                ChampionMastery mastery = new ChampionMastery();


                int championId = object.get("championId").getAsInt();

                mastery.setChampionId(championId);
                String name = ChampionDataService.getChampionNameByID(championId);
                mastery.setChampionName(name);

                mastery.setChampionLevel(object.get("championLevel").getAsInt());
                mastery.setChampionPoints(object.get("championPoints").getAsLong());

                champlist.add(mastery);
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return champlist;
    }



// http requests funk
private static String makeRequest(String urlString)
{
    try
    {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Riot-Token", ApiConfig.API_KEY);


        int code = conn.getResponseCode();
        if (code != 200) {
            System.out.println("fehler");
            return null;
        }


        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;


        while ((line = in.readLine()) != null)
        {
            response.append(line);
        }
        in.close();
        return response.toString();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    return null;
    }

 }

}