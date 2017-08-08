package ru.cbr.jira.plugins.customfields;

import com.atlassian.jira.issue.customfields.impl.FieldValidationException;

import java.net.MalformedURLException;
import java.net.URL;


public class UrlDtoUtils {
    private static final String SEPARATOR = "%%";

    public UrlDto parse(String s) {
        if (s == null) {
            return new UrlDto("", "");
        }
        String[] strings = s.split(SEPARATOR);
        if (strings.length != 2) {
            throw new FieldValidationException("exception parsing string to url - " + s);
        }

        String urlString = strings[0];

        try {
            new URL(urlString);
        } catch (MalformedURLException e) {
            throw new FieldValidationException("not valid url");
        }

        return new UrlDto(urlString, strings[1]);
    }

    public String toString(UrlDto urlDto) {
        if (urlDto == null) {
            return "";
        } else {
            return urlDto.getUrl() + SEPARATOR + urlDto.getTitle();
        }
    }
}
