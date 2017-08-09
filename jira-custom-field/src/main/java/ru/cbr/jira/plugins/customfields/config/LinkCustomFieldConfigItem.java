package ru.cbr.jira.plugins.customfields.config;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.config.FieldConfigItemType;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;

import java.util.HashMap;
import java.util.Map;

public class LinkCustomFieldConfigItem implements FieldConfigItemType {
    public String getDisplayName() {
        return "Open URL";
    }

    public String getDisplayNameKey() {
        return "Open URL";
    }

    public String getViewHtml(FieldConfig fieldConfig,
                              FieldLayoutItem fieldLayoutItem) {

        return "for link";
    }
    public String getObjectKey() {
        return "lcfconfig";
    }

    public Object getConfigurationObject(Issue issue, FieldConfig config) {
        Map result = new HashMap();
        result.put("newWindow", true);
        return result;
    }

    public String getBaseEditUrl() {
        return "LinkCustomFieldConfig!default.jspa";
    }
}
