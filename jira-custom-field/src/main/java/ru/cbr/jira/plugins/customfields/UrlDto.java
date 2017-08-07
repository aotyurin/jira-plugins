package ru.cbr.jira.plugins.customfields;


import java.net.URL;

public class UrlDto {
    private String url;
    private String title;

    public UrlDto(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
