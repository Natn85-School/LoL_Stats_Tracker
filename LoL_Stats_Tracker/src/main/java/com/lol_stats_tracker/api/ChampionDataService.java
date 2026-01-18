package com.lol_stats_tracker.api;

import com.lol_stats_tracker.model.Champion;

import java.util.ArrayList;
import java.util.List;

public class ChampionDataService
{
    private static final Champion[] championsData = {
            new Champion("1", "Annie", "Mid"),
            new Champion("2", "Olaf", "Jungle"),
            new Champion("3", "Galio", "Mid"),
            new Champion("4", "Twisted Fate", "Mid"),
            new Champion("5", "Xin Zhao", "Jungle"),
            new Champion("6", "Urgot", "Top"),
            new Champion("7", "LeBlanc", "Mid"),
            new Champion("8", "Vladimir", "Top"),
            new Champion("9", "Fiddlesticks", "Jungle"),
            new Champion("10", "Kayle", "Top"),
            new Champion("11", "Master Yi", "Jungle"),
            new Champion("12", "Alistar", "Support"),
            new Champion("13", "Ryze", "Top"),
            new Champion("14", "Sion", "Top"),
            new Champion("15", "Sivir", "ADC"),
            new Champion("16", "Soraka", "Support"),
            new Champion("17", "Teemo", "Top"),
            new Champion("18", "Tristana", "ADC"),
            new Champion("19", "Warwick", "Jungle"),
            new Champion("20", "Nunu", "Jungle"),
            new Champion("21", "Miss Fortune", "ADC"),
            new Champion("22", "Ashe", "ADC"),
            new Champion("23", "Tryndamere", "Top"),
            new Champion("24", "Jax", "Top"),
            new Champion("25", "Morgana", "Support"),
            new Champion("26", "Zilean", "Support"),
            new Champion("28", "Evelynn", "Jungle"),
            new Champion("29", "Twitch", "ADC"),
            new Champion("30", "Karthus", "Jungle"),
            new Champion("31", "Cho'Gath", "Top"),
            new Champion("32", "Amumu", "Jungle"),
            new Champion("33", "Rammus", "Jungle"),
            new Champion("34", "Anivia", "Mid"),
            new Champion("35", "Shaco", "Jungle"),
            new Champion("36", "Dr. Mundo", "Top"),
            new Champion("37", "Sona", "Support"),
            new Champion("38", "Kassadin", "Mid"),
            new Champion("39", "Irelia", "Top"),
            new Champion("40", "Janna", "Support"),
            new Champion("41", "Gangplank", "Top"),
            new Champion("42", "Corki", "ADC"),
            new Champion("43", "Karma", "Support"),
            new Champion("44", "Taric", "Support"),
            new Champion("45", "Veigar", "Mid"),
            new Champion("48", "Trundle", "Jungle"),
            new Champion("50", "Swain", "Support"),
            new Champion("51", "Caitlyn", "ADC"),
            new Champion("53", "Blitzcrank", "Support"),
            new Champion("54", "Malphite", "Top"),
            new Champion("55", "Katarina", "Mid"),
            new Champion("56", "Nocturne", "Jungle"),
            new Champion("57", "Maokai", "Top"),
            new Champion("58", "Renekton", "Top"),
            new Champion("59", "Jarvan IV", "Jungle"),
            new Champion("60", "Elise", "Jungle"),
            new Champion("61", "Orianna", "Mid"),
            new Champion("62", "Wukong", "Top"),
            new Champion("63", "Brand", "Support"),
            new Champion("64", "Lee Sin", "Jungle"),
            new Champion("67", "Vayne", "ADC"),
            new Champion("68", "Rumble", "Top"),
            new Champion("69", "Cassiopeia", "Mid"),
            new Champion("72", "Skarner", "Jungle"),
            new Champion("74", "Heimerdinger", "Mid"),
            new Champion("75", "Nasus", "Top"),
            new Champion("76", "Nidalee", "Jungle"),
            new Champion("77", "Udyr", "Jungle"),
            new Champion("78", "Poppy", "Top"),
            new Champion("79", "Gragas", "Jungle"),
            new Champion("80", "Pantheon", "Support"),
            new Champion("81", "Ezreal", "ADC"),
            new Champion("82", "Mordekaiser", "Top"),
            new Champion("83", "Yorick", "Top"),
            new Champion("84", "Akali", "Mid"),
            new Champion("85", "Kennen", "Top"),
            new Champion("86", "Garen", "Top"),
            new Champion("89", "Leona", "Support"),
            new Champion("90", "Malzahar", "Mid"),
            new Champion("91", "Talon", "Mid"),
            new Champion("92", "Riven", "Top"),
            new Champion("96", "Kog'Maw", "ADC"),
            new Champion("98", "Shen", "Top"),
            new Champion("99", "Lux", "Support"),
            new Champion("101", "Xerath", "Mid"),
            new Champion("102", "Shyvana", "Jungle"),
            new Champion("103", "Ahri", "Mid"),
            new Champion("104", "Graves", "Jungle"),
            new Champion("105", "Fizz", "Mid"),
            new Champion("106", "Volibear", "Jungle"),
            new Champion("107", "Rengar", "Jungle"),
            new Champion("110", "Varus", "ADC"),
            new Champion("111", "Nautilus", "Support"),
            new Champion("112", "Viktor", "Mid"),
            new Champion("113", "Sejuani", "Jungle"),
            new Champion("114", "Fiora", "Top"),
            new Champion("115", "Ziggs", "Mid"),
            new Champion("117", "Lulu", "Support"),
            new Champion("119", "Draven", "ADC"),
            new Champion("120", "Hecarim", "Jungle"),
            new Champion("121", "Kha'Zix", "Jungle"),
            new Champion("122", "Darius", "Top"),
            new Champion("126", "Jayce", "Top"),
            new Champion("127", "Lissandra", "Mid"),
            new Champion("131", "Diana", "Jungle"),
            new Champion("133", "Quinn", "Top"),
            new Champion("134", "Syndra", "Mid"),
            new Champion("136", "Aurelion Sol", "Mid"),
            new Champion("141", "Kayn", "Jungle"),
            new Champion("142", "Zoe", "Mid"),
            new Champion("143", "Zyra", "Support"),
            new Champion("145", "Kai'Sa", "ADC"),
            new Champion("147", "Seraphine", "Support"),
            new Champion("150", "Gnar", "Top"),
            new Champion("154", "Zac", "Jungle"),
            new Champion("157", "Yasuo", "Mid"),
            new Champion("161", "Vel'Koz", "Support"),
            new Champion("163", "Taliyah", "Jungle"),
            new Champion("164", "Camille", "Top"),
            new Champion("166", "Akshan", "Mid"),
            new Champion("200", "Bel'Veth", "Jungle"),
            new Champion("201", "Braum", "Support"),
            new Champion("202", "Jhin", "ADC"),
            new Champion("203", "Kindred", "Jungle"),
            new Champion("221", "Zeri", "ADC"),
            new Champion("222", "Jinx", "ADC"),
            new Champion("223", "Tahm Kench", "Top"),
            new Champion("233", "Briar", "Jungle"),
            new Champion("234", "Viego", "Jungle"),
            new Champion("235", "Senna", "ADC"),
            new Champion("236", "Lucian", "ADC"),
            new Champion("238", "Zed", "Mid"),
            new Champion("240", "Kled", "Top"),
            new Champion("245", "Ekko", "Jungle"),
            new Champion("246", "Qiyana", "Mid"),
            new Champion("254", "Vi", "Jungle"),
            new Champion("266", "Aatrox", "Top"),
            new Champion("267", "Nami", "Support"),
            new Champion("268", "Azir", "Mid"),
            new Champion("350", "Yuumi", "Support"),
            new Champion("360", "Samira", "ADC"),
            new Champion("412", "Thresh", "Support"),
            new Champion("420", "Illaoi", "Top"),
            new Champion("421", "Rek'Sai", "Jungle"),
            new Champion("427", "Ivern", "Jungle"),
            new Champion("429", "Kalista", "ADC"),
            new Champion("432", "Bard", "Support"),
            new Champion("497", "Rakan", "Support"),
            new Champion("498", "Xayah", "ADC"),
            new Champion("516", "Ornn", "Top"),
            new Champion("517", "Sylas", "Mid"),
            new Champion("518", "Neeko", "Mid"),
            new Champion("523", "Aphelios", "ADC"),
            new Champion("526", "Rell", "Support"),
            new Champion("555", "Pyke", "Support"),
            new Champion("711", "Vex", "Mid"),
            new Champion("777", "Yone", "Mid"),
            new Champion("875", "Sett", "Top"),
            new Champion("876", "Lillia", "Jungle"),
            new Champion("887", "Gwen", "Top"),
            new Champion("888", "Renata Glasc", "Support"),
            new Champion("893", "Aurora", "Mid"),
            new Champion("895", "Nilah", "ADC"),
            new Champion("897", "K'Sante", "Top"),
            new Champion("901", "Smolder", "ADC"),
            new Champion("902", "Milio", "Support"),
            new Champion("910", "Hwei", "Mid"),
            new Champion("950", "Naafiri", "Mid")
    };

    public List<Champion> getAllChampions()
    {
        List<Champion> champions = new ArrayList<>();
        for (Champion champion : championsData)
        {
            champions.add(champion);
        }
        return champions;
    }

    public int  getChampionCount()
    {
        return championsData.length;
    }

    public static  String getChampionNameByID(int championID)
    {
        for(Champion champion : championsData)
        {
            if(Integer.parseInt(champion.getId()) == championID)
            {
                return champion.getName();
            }

        }
        return "Unknown Champ";
    }

}