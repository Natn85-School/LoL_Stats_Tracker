package com.lol_stats_tracker.api;

import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.lol_stats_tracker.api.ApiConfig;
import java.net.HttpURLConnection;
import com.lol_stats_tracker.model.Player;
import java.net.ResponseCache;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.out;


public class TestApi
{

    public static void main ( String[] args)
    {
        String gameName = "unlmtd";
        String tagline = "IIIII";



        try
        {
          String urlString = "https://" + ApiConfig.REGION + ".api.riotgames.com" + "/riot/account/v1/accounts/by-riot-id/" +
                  gameName + "/" + tagline;

          URL url  = new URL(urlString);
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
          conn.setRequestMethod("GET");
          conn.setRequestProperty("X-Riot-Token",ApiConfig.API_KEY);


          int responseCode = conn.getResponseCode();
          System.out.println("ResponseCode:" + responseCode);

            if (responseCode == 200)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = in.readLine()) != null)
                {
                    response.append(line);
                }
                in.close();

                    Gson gson = new Gson();
                    Player player = gson.fromJson(response.toString(),Player.class);
                System.out.println("Info ");
                System.out.println("Имя: " + player.getGameName());
                System.out.println("Тег: " + player.getTagLine());
                System.out.println("PUUID: " + player.getPuuid());


                String summonerUrl = "https://" + ApiConfig.PLATFORM + ".api.riotgames.com" + "/lol/summoner/v4/summoners/by-puuid/" + player.getPuuid();

                URL url2 = new URL(summonerUrl);
                HttpURLConnection conn2 = (HttpURLConnection)  url2.openConnection();
                conn2.setRequestMethod("GET");
                conn2.setRequestProperty("X-Riot-Token",ApiConfig.API_KEY);

                int responseCode2 = conn2.getResponseCode();
                System.out.println("ResponseCode:" + responseCode2);
                if(responseCode2 == 200) {
                    BufferedReader in2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                    StringBuilder response2 = new StringBuilder();
                    String line2;

                    while ((line2 = in2.readLine()) != null) {
                        response2.append(line2);
                    }
                    in2.close();
                    System.out.println(response2.toString());
                    System.out.println();


                    JsonObject summonerData = gson.fromJson(response2.toString(), JsonObject.class);

                    player.setSummonerId(player.getPuuid());
                    player.setSummonerLevel(Integer.parseInt(summonerData.get("summonerLevel").getAsString()));

                    System.out.println("Info summ");
                    System.out.println("Summoner ID: " + player.getSummonerId());
                    System.out.println("Level: " + player.getSummonerLevel());
                }
                String masteryUrl = "https://" + ApiConfig.PLATFORM + ".api.riotgames.com" + "/lol/champion-mastery/v4/champion-masteries/by-puuid/" + player.getPuuid() + "/top?count=10";

                URL url3 = new URL(masteryUrl);
                HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
                conn3.setRequestMethod("GET");
                conn3.setRequestProperty("X-Riot-Token", ApiConfig.API_KEY);


                int responseCode3 = conn3.getResponseCode();
                System.out.println("ResponseCode:" + responseCode3);

                if(responseCode3 == 200)
                {
                    BufferedReader in3 = new BufferedReader(new InputStreamReader(conn3.getInputStream()));
                    StringBuilder response3 = new StringBuilder();
                    String line3;

                    while ((line3 = in3.readLine()) != null)
                    {
                        response3.append(line3);
                    }
                    in3.close();

                    System.out.println("Jsooon");
                    System.out.println(response3.toString());
                    System.out.println();


                    com.google.gson.JsonArray masteryArray = gson.fromJson(response3.toString(),com.google.gson.JsonArray.class);
                    System.out.printf("\n TOP 10 Champions");
                    for(int i = 0 ; i < masteryArray.size();i++)
                    {
                        JsonObject masteryObj =  masteryArray.get(i).getAsJsonObject();

                        int  champId = masteryObj.get("championId").getAsInt();
                        int champLevel = masteryObj.get("championLevel").getAsInt();
                        long champPoints = masteryObj.get("championPoints").getAsInt();

                        System.out.printf("%2d. Champion ID: %d | Level: %d | Points: %,d%n", i + 1 , champId, champLevel , champPoints);
                    }
                }
            }

            else
            {
                System.out.println("Eror");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
