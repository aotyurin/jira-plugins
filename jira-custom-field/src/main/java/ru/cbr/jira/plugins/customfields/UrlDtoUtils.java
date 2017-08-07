package ru.cbr.jira.plugins.customfields;

import com.atlassian.jira.issue.customfields.impl.FieldValidationException;


public class UrlDtoUtils {
    private static final String SEPARATOR = "%%";

    public UrlDto parse(String s) {
        if (s== null) {
            throw new FieldValidationException("null point");
        }
        String[] strings = s.split(SEPARATOR);
        if (strings.length != 2) {
            throw new FieldValidationException("not valid url - " + s);
        }

        return new UrlDto(strings[0], strings[1]);
    }

    public String toString(UrlDto urlDto) {
        if (urlDto == null) {
            return "";
        } else {
            return urlDto.getUrl() + SEPARATOR + urlDto.getTitle();
        }
    }
}
