package project.comparators;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import project.model.json.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DocParamsComparatorTest {
    private Document documentFf;
    private Document documentSf;
    private DocParamsComparator comparator = new DocParamsComparator();

    @Before
    public void setUp() throws Exception {
        documentFf = new Document();
        documentSf = new Document();
    }

    @Test
    public void getDiffEquals() throws Exception {
        documentFf.setId("id1");
        documentSf.setId("id2");
        assertEquals(Collections.singletonList("is equals"), comparator.getDiff(documentFf, documentFf));
    }

    @Test
    public void getDiffDifferent() throws Exception {
        documentFf.setId("id1");
        documentFf.setScore(1);
        documentSf.setId("id2");
        documentSf.setScore(1);
        assertEquals(Collections.singletonList("_id"), comparator.getDiff(documentFf, documentSf));
    }
}