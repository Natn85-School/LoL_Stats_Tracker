package com.lol_stats_tracker.model;

public class SearchHistory
{
    private String summonerName;
    private String tag;
    private long timestamp;

    public SearchHistory(String summonerName, String tag)
    {
        this.summonerName = summonerName;
        this.tag = tag;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSummonerName()
    {
        return summonerName;
    }

    public String getTag()
    {
        return tag;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    @Override
    public String toString()
    {
        return summonerName + "#" + tag;
    }
}