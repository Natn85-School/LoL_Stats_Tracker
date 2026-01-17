package com.lol_stats_tracker.controller;

import com.lol_stats_tracker.api.ChampionDataService;
import com.lol_stats_tracker.model.Champion;
import java.util.ArrayList;
import java.util.List;

public class ChampionController {
    private ChampionDataService dataService;

    public ChampionController() {
        this.dataService = new ChampionDataService();
    }

    public List<Champion> getAllChampions() {
        return dataService.getAllChampions();
    }

    public List<Champion> filterChampions(String searchText) {
        List<Champion> allChampions = dataService.getAllChampions();
        List<Champion> filtered = new ArrayList<>();

        if (searchText == null || searchText.isEmpty()) {
            return allChampions;
        }

        String lowerSearch = searchText.toLowerCase();
        for (Champion champion : allChampions) {
            if (champion.getName().toLowerCase().contains(lowerSearch)) {
                filtered.add(champion);
            }
        }

        return filtered;
    }

    public int getTotalChampionCount() {
        return dataService.getChampionCount();
    }
}