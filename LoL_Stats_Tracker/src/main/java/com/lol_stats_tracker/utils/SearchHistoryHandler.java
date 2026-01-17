package com.lol_stats_tracker.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lol_stats_tracker.model.SearchHistory;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchHistoryHandler
{
    private static final String FILE_PATH = "search_history.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveSearchHistory(SearchHistory history)
    {
        List<SearchHistory> histories = loadSearchHistory();

        histories.removeIf(h -> h.getSummonerName().equalsIgnoreCase(history.getSummonerName()) && h.getTag().equalsIgnoreCase(history.getTag()));

        histories.add(0, history);

        if (histories.size() > 5)
        {
            histories = histories.subList(0, 5);
        }

        try
        {
            String json = gson.toJson(histories);
            Files.write(Paths.get(FILE_PATH), json.getBytes());
        }
        catch (IOException e)
        {
            System.out.println("Error saving search history: " + e.getMessage());
        }
    }

    public static List<SearchHistory> loadSearchHistory()
    {
        try
        {
            if (!Files.exists(Paths.get(FILE_PATH)))
            {
                return new ArrayList<>();
            }

            String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

            if (json.isEmpty())
            {
                return new ArrayList<>();
            }

            Type type = new TypeToken<List<SearchHistory>>(){}.getType();
            return gson.fromJson(json, type);
        }
        catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public static void clearHistory()
    {
        try
        {
            Files.delete(Paths.get(FILE_PATH));
        }
        catch (IOException e)
        {
            System.out.println("Error clearing history: " + e.getMessage());
        }
    }
}