package project.iterators;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import project.comparators.ComparatorBy;
import project.exceptions.IncorrectInputParametersException;
import project.model.OutputObject;
import project.model.OutputParameters;
import project.model.json.Document;
import project.model.json.InputData;
import project.model.json.Response;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IterateByDocsByOrderTest {
    private IterateByDocsByOrder iterator;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        iterator = new IterateByDocsByOrder();
    }

    @Test
    public void runWithEmptyData() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("One of the input files doesn't contain search results");
        iterator.iterateAndCompare(null, null, null);
    }

    @Test
    public void runWithEmptyResponse() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("One of the input files doesn't contain search results");
        InputData inputData = new InputData();
        inputData.setResponse(null);
        iterator.iterateAndCompare(null, inputData, inputData);
    }

    @Test
    public void runWithEmptyDocList() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("One of the input files doesn't contain search results");
        InputData inputData = new InputData();
        Response response = new Response();
        response.setDocs(null);
        inputData.setResponse(response);
        iterator.iterateAndCompare(null, inputData, inputData);
    }

    @Test
    public void runWithEmptyDoc() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("One of the input files doesn't contain search results");
        InputData inputData = new InputData();
        Response response = new Response();
        response.setDocs(Collections.emptyList());
        inputData.setResponse(response);
        iterator.iterateAndCompare(null, inputData, inputData);
    }

    @Test
    public void runForDifferentLengthSearchResults() {
        List<Document> inputDocsFf = Collections.emptyList();
        List<Document> inputDocsSf = Collections.singletonList(new Document());
        ComparatorBy comparator = mock(ComparatorBy.class);
        when(comparator.getDiff(anyObject(), anyObject())).thenReturn(Collections.emptyList());
        OutputParameters outputParameters = iterator.runIteration(comparator, inputDocsFf, inputDocsSf);
        assertNotNull(outputParameters.getMsg());
        assertTrue(outputParameters.getMsg().contains("1"));
    }

    @Test
    public void checkOutputFull() {
        ComparatorBy comparator = mock(ComparatorBy.class);
        Document doc = mock(Document.class);
        List<Document> inputDocsFf = Collections.singletonList(doc);
        List<String> someField = Collections.singletonList("someField");
        String someId = "someId";
        when(comparator.getDiff(doc, doc)).thenReturn(someField);
        when(doc.getId()).thenReturn(someId);
        OutputParameters outputParameters = iterator.runIteration(comparator, inputDocsFf, inputDocsFf);
        OutputObject outputObject = outputParameters.getOutput().get(0);
        assertEquals(someField, outputObject.getDiffList());
        assertEquals(someId, outputObject.getValueIdFirstObj());
        assertEquals(someId, outputObject.getValueIdSecondObj());
        assertEquals("id", outputParameters.getNameIdField());

    }

}