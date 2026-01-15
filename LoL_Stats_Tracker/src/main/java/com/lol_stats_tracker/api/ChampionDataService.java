package com.lol_stats_tracker.api;

import com.lol_stats_tracker.model.Champion;

import java.util.ArrayList;
import java.util.List;

public class ChampionDataService
{

    private static final Champion[] championsData = {
            new Champion("1", "Annie"), new Champion("2", "Olaf"), new Champion("3", "Galio"), new Champion("4", "Twisted Fate"),
            new Champion("5", "Xin Zhao"), new Champion("6", "Urgot"), new Champion("7", "LeBlanc"), new Champion("8", "Vladimir"),
            new Champion("9", "Fiddlesticks"), new Champion("10", "Kayle"), new Champion("11", "Master Yi"), new Champion("12", "Alistar"),
            new Champion("13", "Ryze"), new Champion("14", "Sion"), new Champion("15", "Sivir"), new Champion("16", "Soraka"),
            new Champion("17", "Teemo"), new Champion("18", "Tristana"), new Champion("19", "Warwick"), new Champion("20", "Nunu"),
            new Champion("21", "Miss Fortune"), new Champion("22", "Ashe"), new Champion("23", "Tryndamere"), new Champion("24", "Jax"),
            new Champion("25", "Morgana"), new Champion("26", "Zilean"), new Champion("28", "Evelynn"), new Champion("29", "Twitch"),
            new Champion("30", "Karthus"), new Champion("31", "Cho'Gath"), new Champion("32", "Amumu"), new Champion("33", "Rammus"),
            new Champion("34", "Anivia"), new Champion("35", "Shaco"), new Champion("36", "Dr. Mundo"), new Champion("37", "Sona"),
            new Champion("38", "Kassadin"), new Champion("39", "Irelia"), new Champion("40", "Janna"), new Champion("41", "Gangplank"),
            new Champion("42", "Corki"), new Champion("43", "Karma"), new Champion("44", "Taric"), new Champion("45", "Veigar"),
            new Champion("48", "Trundle"), new Champion("50", "Swain"), new Champion("51", "Caitlyn"), new Champion("53", "Blitzcrank"),
            new Champion("54", "Malphite"), new Champion("55", "Katarina"), new Champion("56", "Nocturne"), new Champion("57", "Maokai"),
            new Champion("58", "Renekton"), new Champion("59", "Jarvan IV"), new Champion("60", "Elise"), new Champion("61", "Orianna"),
            new Champion("62", "Wukong"), new Champion("63", "Brand"), new Champion("64", "Lee Sin"), new Champion("67", "Vayne"),
            new Champion("68", "Rumble"), new Champion("69", "Cassiopeia"), new Champion("72", "Skarner"), new Champion("74", "Heimerdinger"),
            new Champion("75", "Nasus"), new Champion("76", "Nidalee"), new Champion("77", "Udyr"), new Champion("78", "Poppy"),
            new Champion("79", "Gragas"), new Champion("80", "Pantheon"), new Champion("81", "Ezreal"), new Champion("82", "Mordekaiser"),
            new Champion("83", "Yorick"), new Champion("84", "Akali"), new Champion("85", "Kennen"), new Champion("86", "Garen"),
            new Champion("89", "Leona"), new Champion("90", "Malzahar"), new Champion("91", "Talon"), new Champion("92", "Riven"),
            new Champion("96", "Kog'Maw"), new Champion("98", "Shen"), new Champion("99", "Lux"), new Champion("101", "Xerath"),
            new Champion("102", "Shyvana"), new Champion("103", "Ahri"), new Champion("104", "Graves"), new Champion("105", "Fizz"),
            new Champion("106", "Volibear"), new Champion("107", "Rengar"), new Champion("110", "Varus"), new Champion("111", "Nautilus"),
            new Champion("112", "Viktor"), new Champion("113", "Sejuani"), new Champion("114", "Fiora"), new Champion("115", "Ziggs"),
            new Champion("117", "Lulu"), new Champion("119", "Draven"), new Champion("120", "Hecarim"), new Champion("121", "Kha'Zix"),
            new Champion("122", "Darius"), new Champion("126", "Jayce"), new Champion("127", "Lissandra"), new Champion("131", "Diana"),
            new Champion("133", "Quinn"), new Champion("134", "Syndra"), new Champion("136", "Aurelion Sol"), new Champion("141", "Kayn"),
            new Champion("142", "Zoe"), new Champion("143", "Zyra"), new Champion("145", "Kai'Sa"), new Champion("147", "Seraphine"),
            new Champion("150", "Gnar"), new Champion("154", "Zac"), new Champion("157", "Yasuo"), new Champion("161", "Vel'Koz"),
            new Champion("163", "Taliyah"), new Champion("164", "Camille"), new Champion("166", "Akshan"), new Champion("200", "Bel'Veth"),
            new Champion("201", "Braum"), new Champion("202", "Jhin"), new Champion("203", "Kindred"), new Champion("221", "Zeri"),
            new Champion("222", "Jinx"), new Champion("223", "Tahm Kench"), new Champion("234", "Viego"), new Champion("235", "Senna"),
            new Champion("236", "Lucian"), new Champion("238", "Zed"), new Champion("240", "Kled"), new Champion("245", "Ekko"),
            new Champion("246", "Qiyana"), new Champion("254", "Vi"), new Champion("266", "Aatrox"), new Champion("267", "Nami"),
            new Champion("268", "Azir"), new Champion("350", "Yuumi"), new Champion("360", "Samira"), new Champion("412", "Thresh"),
            new Champion("420", "Illaoi"), new Champion("421", "Rek'Sai"), new Champion("427", "Ivern"), new Champion("429", "Kalista"),
            new Champion("432", "Bard"), new Champion("497", "Rakan"), new Champion("498", "Xayah"), new Champion("516", "Ornn"),
            new Champion("517", "Sylas"), new Champion("518", "Neeko"), new Champion("523", "Aphelios"), new Champion("526", "Rell"),
            new Champion("555", "Pyke"), new Champion("711", "Vex"), new Champion("777", "Yone"), new Champion("875", "Sett"),
            new Champion("876", "Lillia"), new Champion("887", "Gwen"), new Champion("888", "Renata Glasc"), new Champion("893", "Aurora"),
            new Champion("895", "Nilah"), new Champion("897", "K'Sante"), new Champion("901", "Smolder"), new Champion("902", "Milio"),
            new Champion("910", "Hwei"), new Champion("950", "Naafiri"), new Champion("233", "Briar")
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