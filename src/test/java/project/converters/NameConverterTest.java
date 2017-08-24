package project.converters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import project.exceptions.IncorrectInputParametersException;
import project.model.json.Document;

import static org.junit.Assert.assertEquals;

public class NameConverterTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void convertParameter2FieldObjByAnnotation() throws Exception {
        assertEquals(Document.class.getDeclaredField("id"), NameConverter.convertParameter2FieldObj("_id"));
        assertEquals(Document.class.getDeclaredField("abstr"), NameConverter.convertParameter2FieldObj("abstract"));
    }

    @Test
    public void convertParameter2FieldObjByName() throws Exception {
        assertEquals(Document.class.getDeclaredField("typeOfMaterial"), NameConverter.convertParameter2FieldObj("type_of_material"));
        assertEquals(Document.class.getDeclaredField("snippet"), NameConverter.convertParameter2FieldObj("snippet"));
    }

    @Test
    public void convertParameter2FieldObjNotExist() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("Parameter with name like some_strange_value doesn't exist in the Document class");
        NameConverter.convertParameter2FieldObj("some_strange_value");
    }

    @Test
    public void convertFieldObj2ParameterByAnnotation() throws Exception {
        assertEquals("_id", NameConverter.convertFieldObj2Parameter(Document.class.getDeclaredField("id")));
    }

    @Test
    public void convertFieldObj2ParameterByName() throws Exception {
        assertEquals("snippet", NameConverter.convertFieldObj2Parameter(Document.class.getDeclaredField("snippet")));

    }

    @Test
    public void convertParameter2FieldName() throws Exception {
        assertEquals("testName", NameConverter.convertParameter2FieldName("_test_name"));

    }

}