package com.chain.volleyapp;

public class Suggestion {
    public String title;
    public String description;
    public String image;
    public String userid;
    public String timestamp;

    public Suggestion() {

    }

    public Suggestion(String title, String description, String image, String userid, String timestamp) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.userid = userid;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
