package model;

import javafx.beans.property.SimpleStringProperty;

public class Note {
    SimpleStringProperty uuid;
    SimpleStringProperty username;
    SimpleStringProperty password;
    SimpleStringProperty siteURL;
    SimpleStringProperty siteName;
    SimpleStringProperty comment;
    SimpleStringProperty category;
    SimpleStringProperty date;

    public Note(String username, String password, String siteURL, String siteName, String comment, String category, String date){
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.siteURL = new SimpleStringProperty(siteURL);
        this.siteName = new SimpleStringProperty(siteName);
        this.comment = new SimpleStringProperty(comment);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleStringProperty(date);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getSiteURL() {
        return siteURL.get();
    }

    public void setSiteURL(String siteURL){
        this.siteURL.set(siteURL);
    }

    public String getUuid() {
        return uuid.get();
    }

    public void setUuid(String uuid) {
        this.uuid.set(uuid);
    }

    public String getSiteName() {
        return siteName.get();
    }

    public String getCategory() {
        return category.get();
    }

    public String getComment() {
        return comment.get();
    }

    public String getDate() {
        return date.get();
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setSiteName(String siteName) {
        this.siteName.set(siteName);
    }

    public String record() {
        return uuid.get() + username.get() + password.get() + siteURL.get() + siteName.get() + comment.get() + category.get() + date.get();
    }
}
