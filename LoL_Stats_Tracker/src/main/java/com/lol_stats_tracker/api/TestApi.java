package com.lol_stats_tracker.api;


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
        String gameName = "Rekkles";
        String tagline = "EUW";



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
                System.out.println("=== Информация об игроке ===");
                System.out.println("Имя: " + player.getGameName());
                System.out.println("Тег: " + player.getTagLine());
                System.out.println("PUUID: " + player.getPuuid());

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
