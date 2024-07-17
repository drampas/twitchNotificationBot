package com.drampas.twitchBot;


import java.util.ArrayList;

public class BotConfiguration {
    private String clientId;
    private String clientSecret;
    private ArrayList<String> channels=new ArrayList<>();

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public ArrayList<String> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }
}