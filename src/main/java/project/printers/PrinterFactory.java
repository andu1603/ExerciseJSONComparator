package project.printers;

import project.iterators.IterateBy;
import project.iterators.IterateByDocsByKey;
import project.iterators.IterateByDocsByOrder;
import project.model.InputParameters;

public class PrinterFactory {

    public static OutputDataPrinter getPrinter(InputParameters params) {
        return new MapListConsolePrinter();
    }
}
