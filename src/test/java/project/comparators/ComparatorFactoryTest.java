package project.comparators;

import org.junit.Before;
import org.junit.Test;
import project.model.InputParameters;

import static org.junit.Assert.*;

public class ComparatorFactoryTest {
    private InputParameters parameters;

    @Before
    public void setUp() {
        parameters = new InputParameters();
    }

    @Test
    public void getComparator() throws Exception {
        assertTrue(ComparatorFactory.getComparator(parameters) instanceof DocParamsComparator);
    }

}