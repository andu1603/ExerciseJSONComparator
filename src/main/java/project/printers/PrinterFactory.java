package project.printers;

import project.model.InputParameters;

public class PrinterFactory {

    public static OutputDataPrinter getPrinter(InputParameters params) {
        if (params.getFileName() != null)
            return new FilePrinter(params.getFileName());
        return new ConsolePrinter();
    }
}
