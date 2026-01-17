package com.lol_stats_tracker.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lol_stats_tracker.model.SearchHistory;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchHistoryHandler
{
    private static final String APP_DIR = System.getProperty("user.home") + File.separator + ".lol_stats_tracker";
    private static final String FILE_PATH = APP_DIR + File.separator + "search_history.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static
    {
        try
        {
            Files.createDirectories(Paths.get(APP_DIR));
        } catch (IOException e)
        {
            System.err.println("Could not create app directory: " + e.getMessage());
        }
    }

    public static void saveSearchHistory(SearchHistory history)
    {
        List<SearchHistory> histories = loadSearchHistory();

        histories.removeIf(h -> h.getSummonerName().equalsIgnoreCase(history.getSummonerName())
                && h.getTag().equalsIgnoreCase(history.getTag()));

        histories.add(0, history);

        if (histories.size() > 5)
        {
            histories = histories.subList(0, 5);
        }

        try
        {
            String json = gson.toJson(histories);
            Files.write(Paths.get(FILE_PATH), json.getBytes());
            System.out.println("Saved to: " + FILE_PATH);
        }
        catch (IOException e)
        {
            System.err.println("Error saving search history: " + e.getMessage());
        }
    }

    public static List<SearchHistory> loadSearchHistory()
    {
        try
        {
            Path path = Paths.get(FILE_PATH);

            if (!Files.exists(path))
            {
                return new ArrayList<>();
            }

            String json = new String(Files.readAllBytes(path));

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
}