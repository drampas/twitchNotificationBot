package com.drampas.twitchBot;

import com.drampas.discordBot.DiscordBot;
import com.drampas.notifications.ChannelGoLiveNotification;
import com.drampas.notifications.ChannelGoOfflineNotification;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.ITwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TwitchBot {

    private static final Logger logger= LoggerFactory.getLogger(TwitchBot.class);
    private ITwitchClient twitchClient;

    private BotConfiguration botConfig;


    public TwitchBot(BotConfiguration botConfig) {
        this.botConfig=botConfig;
        TwitchClientBuilder clientBuilder = TwitchClientBuilder.builder();

        twitchClient = clientBuilder
                .withClientId(botConfig.getClientId())
                .withClientSecret(botConfig.getClientSecret())
                .withEnableHelix(true)
                .build();
    }

    public void registerFeatures(DiscordBot discordBot) {
        SimpleEventHandler eventHandler = twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);

        // Register Event-based features
        ChannelGoLiveNotification channelGoLiveNotification = new ChannelGoLiveNotification(this,discordBot,eventHandler);
        ChannelGoOfflineNotification channelGoOfflineNotification=new ChannelGoOfflineNotification(this,discordBot,eventHandler);

    }
    public void start() {
        // Enable client helper for Stream GoLive / GoOffline / GameChange / TitleChange Events
        twitchClient.getClientHelper().enableStreamEventListener(botConfig.getChannels());
        logger.info(botConfig.getChannels().toString());
    }
}