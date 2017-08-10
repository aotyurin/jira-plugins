package ru.cbr.jira.plugins.dto;

import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UrlDtoUtilsTest {
    private UrlDtoUtils urlDtoUtils = new UrlDtoUtils();

    @Test
    public void parseGoodValueTest() {
        UrlDto urlDto = urlDtoUtils.parse("http://foo.bar%%FOO BAR");
        assertEquals("http://foo.bar", urlDto.getUrl());
        assertEquals("FOO BAR", urlDto.getTitle());
    }

    @Test
    public void parseDefaultValueTest() {
        UrlDto urlDto = urlDtoUtils.parse(null);
        assertEquals("", urlDto.getUrl());
        assertEquals("", urlDto.getTitle());
    }

    @Test
    public void parseBadTest() {
        try {
            urlDtoUtils.parse("bad");
            fail();
        } catch (FieldValidationException ignore) {
        }
    }

    @Test
    public void parseGoodDtoTest() {
        String urlString = urlDtoUtils.toString(new UrlDto("http://foo.bar", "FOO BAR"));
        assertEquals("http://foo.bar%%FOO BAR", urlString);
    }

}