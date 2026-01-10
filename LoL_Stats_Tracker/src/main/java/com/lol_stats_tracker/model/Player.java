package com.lol_stats_tracker.model;

public class Player {
    private String gameName;
    private String tagLine;
    private String puuid;
    private String summonerId;
    private int summonerLevel;


    public Player() {}

        public String getGameName ()
        {
            return gameName;
        }

        public void setGameName (String gameName)
        {
            this.gameName = gameName;
        }

        public String getTagLine ()
        {
            return tagLine;
        }

        public void setTagLine (String tagLine)
        {
            this.tagLine = tagLine;
        }

        public String getPuuid ()
        {
            return puuid;
        }

        public void setPuuid (String puuid)
        {
            this.puuid = puuid;
        }

        public String getSummonerId ()
        {
            return summonerId;
        }

        public void setSummonerId (String summonerId)
        {
            this.summonerId = summonerId;
        }

        public int getSummonerLevel ()
        {
            return summonerLevel;
        }

        public void setSummonerLevel ( int summonerLevel)
        {
            this.summonerLevel = summonerLevel;
        }

        @Override
        public String toString ()
        {
            return gameName + "#" + tagLine + " (Level " + summonerLevel + ")";

        }
    }

