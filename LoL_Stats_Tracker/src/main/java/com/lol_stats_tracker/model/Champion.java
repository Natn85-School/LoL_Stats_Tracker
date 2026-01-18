package com.lol_stats_tracker.model;

public class Champion
{
    private String id;
    private String name;
    private String rolle;


    public Champion(String id, String name, String rolle)
    {
        this.id = id;
        this.name = name;
        this.rolle = rolle;

    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {

        return name;
    }

    public String getRolle()
    {
        return rolle;
    }

    public String getImageUrl()
    {
        return "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/" + id + ".png";
    }
}