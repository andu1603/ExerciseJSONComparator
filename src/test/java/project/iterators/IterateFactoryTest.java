package project.iterators;

import org.junit.Test;
import project.model.InputParameters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IterateFactoryTest {

    @Test
    public void getIterateMethodDefault() throws Exception {
        IterateBy result = IterateFactory.getIterateMethod(new InputParameters());
        assertNotNull(result);
        assertTrue(result instanceof IterateByDocsByOrder);
    }

    @Test
    public void getIterateMethodByKey() throws Exception {
        InputParameters input = new InputParameters();
        input.setIdForComparing("snippet");
        IterateBy result = IterateFactory.getIterateMethod(input);
        assertNotNull(result);
        assertTrue(result instanceof IterateByDocsByKey);
    }

}