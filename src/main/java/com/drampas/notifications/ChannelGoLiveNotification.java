package com.drampas.notifications;

import com.drampas.twitchBot.BotConfiguration;
import com.drampas.twitchBot.TwitchBot;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChannelGoLiveNotification {
    private final Logger logger = LoggerFactory.getLogger(ChannelGoLiveNotification.class);
    private final TwitchBot twitchBot;
    public ChannelGoLiveNotification(TwitchBot twitchBot, SimpleEventHandler eventHandler) {
        this.twitchBot = twitchBot;
        eventHandler.onEvent(ChannelGoLiveEvent.class, this::onGoLive);
    }

    public void onGoLive(ChannelGoLiveEvent event) {
        String channelName=event.getChannel().getName();
        String game=event.getStream().getGameName();
        logger.info(channelName+" is live,game: "+game);
        // TODO: 7/8/2024 add the discord bot messaging method
    }
}
