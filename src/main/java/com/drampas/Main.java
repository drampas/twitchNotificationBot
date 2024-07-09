package com.drampas;

import com.drampas.twitchBot.BotConfiguration;
import com.drampas.twitchBot.TwitchBot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Adding channels to the bot list
        //the channel list will be moved to the configuration.yml file
        //along with the bots id and secret
        ArrayList<String> channels=new ArrayList<>();
        channels.add("Scrapie");
        channels.add("AdmiralBahroo");
        channels.add("SovietWomble");
        channels.add("LongLiveQuebec");
        channels.add("n_sacco98");
        channels.add("Disnof");
        channels.add("Apoooche");
        channels.add("Distortion2");
        channels.add("DolphinChemist");

        TwitchBot bot=new TwitchBot(new BotConfiguration(channels));
        bot.registerFeatures();
        bot.start();
    }
}