package com.drampas.twitchBot;

import com.drampas.notifications.ChannelGoLiveNotification;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.ITwitchClient;
import com.github.twitch4j.TwitchClientBuilder;


public class TwitchBot {

    private ITwitchClient twitchClient;

    private BotConfiguration botConfig;


    public TwitchBot(BotConfiguration botConfig) {
        this.botConfig=botConfig;
        TwitchClientBuilder clientBuilder = TwitchClientBuilder.builder();

        twitchClient = clientBuilder
                .withClientId("your-client-id")
                .withClientSecret("your-client-secret")
                .withEnableHelix(true)
                .build();
    }

    public void registerFeatures() {
        SimpleEventHandler eventHandler = twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);

        // Register Event-based features
        ChannelGoLiveNotification channelGoLiveNotification = new ChannelGoLiveNotification(this,eventHandler);

    }
    public void start() {
        // Enable client helper for Stream GoLive / GoOffline / GameChange / TitleChange Events
        twitchClient.getClientHelper().enableStreamEventListener(botConfig.getChannels());
    }
}