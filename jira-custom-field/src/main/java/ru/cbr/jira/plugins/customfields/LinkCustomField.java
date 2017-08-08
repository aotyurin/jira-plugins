package ru.cbr.jira.plugins.customfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.customfields.persistence.PersistenceFieldType;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Scanned
public class LinkCustomField extends AbstractSingleFieldType<UrlDto> {
    @ComponentImport
    private CustomFieldValuePersister customFieldValuePersister;
    @ComponentImport
    private GenericConfigManager genericConfigManager;

    UrlDtoUtils dtoUtils = new UrlDtoUtils();

    private Logger logger = Logger.getLogger(LinkCustomField.class.getName());


    protected LinkCustomField(CustomFieldValuePersister customFieldValuePersister, GenericConfigManager genericConfigManager) {
        super(customFieldValuePersister, genericConfigManager);

        this.customFieldValuePersister = customFieldValuePersister;
        this.genericConfigManager = genericConfigManager;
    }

    protected PersistenceFieldType getDatabaseType() {
        return PersistenceFieldType.TYPE_LIMITED_TEXT;
    }

    protected Object getDbValueFromObject(UrlDto urlDto) {
        return getStringFromSingularObject(urlDto);
    }

    protected UrlDto getObjectFromDbValue(Object o) throws FieldValidationException {
        return getSingularObjectFromString(((String) o));
    }

    public String getStringFromSingularObject(UrlDto urlDto) {
        return dtoUtils.toString(urlDto);
    }

    public UrlDto getSingularObjectFromString(String s) throws FieldValidationException {
        logger.info("!!!! getSingularObjectFromString - " + s);

        return dtoUtils.parse(s);
    }

    @Override
    public Map<String, Object> getVelocityParameters(Issue issue, CustomField field, FieldLayoutItem fieldLayoutItem) {
        Map<String, Object> velocityParameters = super.getVelocityParameters(issue, field, fieldLayoutItem);
        velocityParameters.put("urlDtoUtils", dtoUtils);
        return velocityParameters;
    }
}