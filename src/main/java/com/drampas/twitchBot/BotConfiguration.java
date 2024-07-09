package com.drampas.twitchBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class BotConfiguration {
    private final Logger logger = LoggerFactory.getLogger(BotConfiguration.class);
    private ArrayList<String> channels=new ArrayList<>();

    public BotConfiguration(ArrayList<String> channels) {
        this.channels = channels;
        logger.info("list of channels:"+channels);
    }

    public ArrayList<String> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }

}