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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IterateByDocsByKeyTest {
    private IterateByDocsByKey iterator;
    private InputData input;
    private Document docWithTypeParameter;
    private List<Document> docs;
    private ComparatorBy comparator = mock(ComparatorBy.class);

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        comparator = mock(ComparatorBy.class);
        when(comparator.getDiff(anyObject(), anyObject())).thenReturn(Collections.singletonList("score"));
        iterator = new IterateByDocsByKey("document_type");
        docWithTypeParameter = new Document();
        docWithTypeParameter.setDocumentType("keyType");
        docs = new ArrayList<>();
        input = new InputData();
        Response resp = new Response();
        input.setResponse(resp);
    }

    @Test
    public void runNotUniqueData() throws Exception {
        expectedEx.expect(IncorrectInputParametersException.class);
        expectedEx.expectMessage("Objects from search result contains duplicates by input key");
        docs.add(docWithTypeParameter);
        docs.add(docWithTypeParameter);
        input.getResponse().setDocs(docs);
        iterator.iterateAndCompare(null, input, input);
    }

    @Test
    public void runNullKeyFieldValue() throws Exception {
        docs.add(docWithTypeParameter);
        docs.add(new Document());
        input.getResponse().setDocs(docs);
        assertTrue(iterator.iterateAndCompare(comparator, input, input).getMsg().contains("1"));
    }

    @Test
    public void runNotPairedData() throws Exception {
        docs.add(docWithTypeParameter);
        input.getResponse().setDocs(docs);
        Document docWithNotEqKey = new Document();
        docWithNotEqKey.setDocumentType("key");
        List<Document> docsdocWithNotEqKey = new ArrayList<>();
        docsdocWithNotEqKey.add(docWithNotEqKey);
        InputData inputdocWithNotEqKey = new InputData();
        Response resp = new Response();
        resp.setDocs(docsdocWithNotEqKey);
        inputdocWithNotEqKey.setResponse(resp);
        assertEquals("Search result from one file contains objects without pair in the other file",
                iterator.iterateAndCompare(comparator, input, inputdocWithNotEqKey).getMsg());
    }

    @Test
    public void runAndTestOutputResult() throws Exception {
        when(comparator.getDiff(any(Document.class), any(Document.class))).thenReturn(Collections.singletonList("score"));
        input.getResponse().setDocs(Collections.singletonList(docWithTypeParameter));
        OutputParameters output = iterator.iterateAndCompare(comparator, input, input);
        assertEquals("documentType", output.getNameIdField());
        OutputObject outputObject = output.getOutput().get(0);
        assertEquals("keyType", outputObject.getValueIdFirstObj());
        assertEquals("keyType", outputObject.getValueIdSecondObj());
        assertEquals(Collections.singletonList("score"), outputObject.getDiffList());

    }

}