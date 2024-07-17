package com.drampas.notifications;

import com.drampas.discordBot.DiscordBot;
import com.drampas.twitchBot.TwitchBot;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChannelGoLiveNotification {
    private static final Logger logger = LoggerFactory.getLogger(ChannelGoLiveNotification.class);
    private final TwitchBot twitchBot;
    private final DiscordBot discordBot;
    private final static String LINK="https://www.twitch.tv/";
    public ChannelGoLiveNotification(TwitchBot twitchBot,DiscordBot discordBot, SimpleEventHandler eventHandler) {
        this.twitchBot = twitchBot;
        this.discordBot = discordBot;
        eventHandler.onEvent(ChannelGoLiveEvent.class, this::onGoLive);
    }

    public void onGoLive(ChannelGoLiveEvent event) {
        String channelName=event.getChannel().getName();
        String game=event.getStream().getGameName();
        logger.info(channelName+" is live,game: "+game);
        discordBot.message(channelName+" is live playing "+game+"\n"+LINK+channelName);

    }
}
