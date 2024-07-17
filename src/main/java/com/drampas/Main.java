package com.drampas;

import com.drampas.discordBot.DiscordBot;
import com.drampas.discordBot.DiscordBotConfiguration;
import com.drampas.twitchBot.BotConfiguration;
import com.drampas.twitchBot.TwitchBot;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File twitchFile=new File("src/main/resources/botConfiguration.yaml");
        File discordFile=new File("src/main/resources/discordBotConfiguration.yaml");
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        try {
            BotConfiguration botConfiguration=mapper.readValue(twitchFile, BotConfiguration.class);
            DiscordBotConfiguration discordBotConfiguration=mapper.readValue(discordFile, DiscordBotConfiguration.class);
            TwitchBot twitchBot=new TwitchBot(botConfiguration);
            DiscordBot discordBot=new DiscordBot(discordBotConfiguration);
            twitchBot.registerFeatures(discordBot);
            twitchBot.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}