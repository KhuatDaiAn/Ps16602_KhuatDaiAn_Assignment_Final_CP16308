package com.example.ps16602_khuatdaian_assignment;

public class item2 {
    private String title;
    private String description;
    private String link;
    private String pubdate;

    public item2() {
    }

    public item2(String title, String description, String link, String pubdate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubdate = pubdate;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }
}
