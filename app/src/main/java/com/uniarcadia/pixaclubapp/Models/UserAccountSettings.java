package com.uniarcadia.pixaclubapp.Models;

public class UserAccountSettings {

    private String description;
    private String displayName;
    private long followers;
    private long following;
    private long posts;
    private String profilePhoto;
    private String username;
    private String website;

    public UserAccountSettings(String description, String displayName, long followers, long following,
                               long posts, String profilePhoto, String username, String website) {
        this.description = description;
        this.displayName = displayName;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.profilePhoto = profilePhoto;
        this.username = username;
        this.website = website;
    }

    public UserAccountSettings() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }

    public long getPosts() {
        return posts;
    }

    public void setPosts(long posts) {
        this.posts = posts;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
