package com.drampas.discordBot;

public class DiscordBotConfiguration {

    private String token;
    private String channelId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
