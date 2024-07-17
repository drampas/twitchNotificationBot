package com.drampas.discordBot;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;

public class DiscordBot {

    private DiscordBotConfiguration botConfiguration;
    private final GatewayDiscordClient client;


    public DiscordBot(DiscordBotConfiguration botConfiguration) {
        this.botConfiguration=botConfiguration;
        client= DiscordClientBuilder.create(botConfiguration.getToken()).build().login().block();
        onLogin();
    }

    public void message(String message){
        client.rest().getChannelById(Snowflake.of(botConfiguration.getChannelId()))
                .createMessage(message)
                .subscribe();
    }

    public void onLogin(){
        client.rest().getChannelById(Snowflake.of(botConfiguration.getChannelId()))
                .createMessage("I am alive")
                .subscribe();
    }
}