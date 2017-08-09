package ru.cbr.jira.plugins.customfields.config;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkCustomFieldConfig extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(LinkCustomFieldConfig.class);

    public LinkCustomFieldConfig() {
    }

    @Override
    public String execute() throws Exception {
        return super.execute(); //returns SUCCESS
    }

}
