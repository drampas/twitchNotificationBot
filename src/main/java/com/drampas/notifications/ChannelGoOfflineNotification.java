package com.drampas.notifications;

import com.drampas.discordBot.DiscordBot;
import com.drampas.twitchBot.TwitchBot;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.events.ChannelGoOfflineEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChannelGoOfflineNotification {
    private static final Logger logger = LoggerFactory.getLogger(ChannelGoOfflineNotification.class);
    private final TwitchBot twitchBot;
    private final DiscordBot discordBot;
    private final static String LINK="https://www.twitch.tv/";
    public ChannelGoOfflineNotification(TwitchBot twitchBot,DiscordBot discordBot, SimpleEventHandler eventHandler) {
        this.twitchBot = twitchBot;
        this.discordBot = discordBot;
        eventHandler.onEvent(ChannelGoOfflineEvent.class, this::onGoOffline);
    }

    public void onGoOffline(ChannelGoOfflineEvent event) {
        String channelName=event.getChannel().getName();
        logger.info(channelName+" is now offline,check out the VOD.");
        discordBot.message(channelName+" is now offline,check out the VOD.\n"+LINK+channelName+"/videos");

    }
}
