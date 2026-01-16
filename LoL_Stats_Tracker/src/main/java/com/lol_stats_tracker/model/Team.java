package com.lol_stats_tracker.model;

public class Team
{
    private Champion topChampion;
    private Champion jungleChampion ;
    private Champion midChampion ;
    private Champion adcChampion ;
    private Champion supportChampion;

    public Team ()
    {

    }

    public Champion getTopChampion()
    {
        return topChampion;
    }

    public Champion getJungleChampion()
    {
        return jungleChampion;
    }

    public Champion getMidChampion()
    {
        return midChampion;
    }

    public Champion getAdcChampion()
    {
        return adcChampion;
    }

    public Champion getSupportChampion()
    {
        return supportChampion;
    }


}
