package project.printers;

import org.junit.Before;
import org.junit.Test;
import project.comparators.ComparatorFactory;
import project.comparators.DocParamsComparator;
import project.model.InputParameters;

import static org.junit.Assert.*;

public class PrinterFactoryTest {
    private InputParameters parameters;

    @Before
    public void setUp() {
        parameters = new InputParameters();
    }

    @Test
    public void getPrinter() throws Exception {
        assertTrue(PrinterFactory.getPrinter(parameters) instanceof MapListConsolePrinter);
    }

}