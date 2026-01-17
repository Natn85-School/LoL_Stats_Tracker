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
    public void setTopChampion(Champion topChampion)
    {
        this.topChampion = topChampion;
    }



    public Champion getJungleChampion()
    {
        return jungleChampion;
    }
    public void setJungleChampion(Champion jungleChampion)
    {
        this.jungleChampion = jungleChampion;
    }



    public Champion getMidChampion()
    {
        return midChampion;
    }
    public void setMidChampion(Champion midChampion)
    {
        this.midChampion = midChampion;
    }


    public Champion getAdcChampion()
    {
        return adcChampion;
    }
    public void setAdcChampion(Champion adcChampion)
    {
        this.adcChampion = adcChampion;
    }



    public Champion getSupportChampion()
    {
        return supportChampion;
    }
    public void setSupportChampion(Champion supportChampion)
    {
        this.supportChampion = supportChampion;
    }
    
}
