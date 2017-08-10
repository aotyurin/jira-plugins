package ut.ru.cbr.jira.plugins.customfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.cbr.jira.plugins.customfields.LinkCustomField;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @since 3.5
 */
public class LinkCustomFieldTest {
    @Mock
    private CustomFieldValuePersister customFieldValuePersister;

    @Mock
    private GenericConfigManager genericConfigManager;


    @InjectMocks
    private LinkCustomField linkCustomField;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetVelocityParameters() throws Exception {
        Issue issue = Mockito.mock(Issue.class);
        CustomField field = Mockito.mock(CustomField.class);
        FieldLayoutItem fieldLayoutItem = Mockito.mock(FieldLayoutItem.class);

        assertNotNull(linkCustomField);

        Map<String, Object> velocityParameters = linkCustomField.getVelocityParameters(issue, field, fieldLayoutItem);

        assertNotNull(velocityParameters.get("urlDtoUtils"));
        assertNotNull(velocityParameters.get("newWindow"));
    }

}
