package com.lol_stats_tracker.controller;

import com.lol_stats_tracker.api.ChampionDataService;
import com.lol_stats_tracker.model.Champion;
import com.lol_stats_tracker.model.Team;

import java.util.List;
import java.util.Random;

public class TeamGeneratorController {

    private ChampionDataService service = new ChampionDataService();
    private Random random = new Random();

    public Team generateTeam(String championName, String role) {

        Team team = new Team();
        List<Champion> champions = service.getAllChampions();

        Champion selectedChampion = null;

        for (Champion c : champions) {
            if (c.getName().equalsIgnoreCase(championName)
                    && c.getRolle().equalsIgnoreCase(role)) {
                selectedChampion = c;
                break;
            }
        }

        if (selectedChampion == null) {
            return null;
        }

        team.setTopChampion(getRandomChampion(champions, "Top"));
        team.setJungleChampion(getRandomChampion(champions, "Jungle"));
        team.setMidChampion(getRandomChampion(champions, "Mid"));
        team.setAdcChampion(getRandomChampion(champions, "ADC"));
        team.setSupportChampion(getRandomChampion(champions, "Support"));

        if (role.equals("Top")) {
            team.setTopChampion(selectedChampion);
        } else if (role.equals("Jungle")) {
            team.setJungleChampion(selectedChampion);
        } else if (role.equals("Mid")) {
            team.setMidChampion(selectedChampion);
        } else if (role.equals("ADC")) {
            team.setAdcChampion(selectedChampion);
        } else if (role.equals("Support")) {
            team.setSupportChampion(selectedChampion);
        }

        return team;
    }

    private Champion getRandomChampion(List<Champion> champions, String role)
    {
        Champion result = null;

        while (result == null) {
            Champion c = champions.get(random.nextInt(champions.size()));
            if (c.getRolle().equalsIgnoreCase(role))
            {
                result = c;
            }
        }

        return result;
    }

    public String teamToString(Team team)
    {
        if (team == null) {
            return "Champion not found for selected role";
        }

        return
                "Top: " + team.getTopChampion().getName() + "\n" +
                        "Jungle: " + team.getJungleChampion().getName() + "\n" +
                        "Mid: " + team.getMidChampion().getName() + "\n" +
                        "ADC: " + team.getAdcChampion().getName() + "\n" +
                        "Support: " + team.getSupportChampion().getName();
    }
}
