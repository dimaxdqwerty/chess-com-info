package com.chess.info.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class User {

    private Country country;
    private Long player_id;
    private int followers;
    private Date joined;
    private Date last_online;
    private boolean is_streamer;
    private String url;
    private String username;
    private String status;

    //optional
    private String name;
    //optional
    private String avatar;
    //optional
    private String title;
    //optional
    private String twitch_url;
    //optional
    private int fide;

    public User(Country country, Long player_id, int followers, long joined, long last_online,
                boolean is_streamer, String url, String username, String status) {
        this.country = country;
        this.player_id = player_id;
        this.followers = followers;
        this.joined = new Date(new Timestamp(joined*1000).getTime());
        this.last_online = new Date(new Timestamp(last_online*1000).getTime());
        this.is_streamer = is_streamer;
        this.url = url;
        this.username = username;
        this.status = status;
    }

    public Country getCountry() {
        return country;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public int getFollowers() {
        return followers;
    }

    public Date getJoined() {
        return joined;
    }

    public Date getLast_online() {
        return last_online;
    }

    public boolean isIs_streamer() {
        return is_streamer;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTitle() {
        return title;
    }

    public String getTwitch_url() {
        return twitch_url;
    }

    public int getFide() {
        return fide;
    }

    public String getName() {
        return name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTwitch_url(String twitch_url) {
        this.twitch_url = twitch_url;
    }

    public void setFide(int fide) {
        this.fide = fide;
    }

    public void setName(String name) {
        this.name = name;
    }
}
