package com.lol_stats_tracker.model;

public class ChampionMastery
{
    private int championId ;
    private int championLevel ;
    private long championPoints ;
    private String championName;


    public ChampionMastery() {}

    public int getChampionId()
    {
        return championId;
    }

    public void setChampionId(int championId)
    {
        this.championId = championId;
    }

    public int getChampionLevel()
    {
        return championLevel;
    }

    public void setChampionLevel(int championLevel)
    {
        this.championLevel = championLevel;
    }

    public long getChampionPoints()
    {
        return championPoints;
    }

    public void setChampionPoints(long championPoints)
    {
        this.championPoints = championPoints;
    }

    public String getChampionName()
    {
        return championName;
    }

    public void setChampionName(String championName)
    {
        this.championName = championName;
    }

}
