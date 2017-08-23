package project.controllers;

import com.beust.jcommander.JCommander;
import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.comparators.ComparatorFactory;
import project.converters.JSON2JavaObjectConverter;
import project.iterators.IterateBy;
import project.iterators.IterateFactory;
import project.model.InputParameters;
import project.model.OutputParameters;
import project.model.json.InputData;
import project.printers.ExceptionConsolePrinter;
import project.printers.MapListConsolePrinter;

import java.util.Arrays;

public class Controller {
    private static final Logger LOG = Logger.getLogger(Controller.class);

    public static void run(String[] input) {
        InputParameters inputParameters = new InputParameters();
        JCommander commander = JCommander.newBuilder()
                .addObject(inputParameters)
                .build();
        try {
            LOG.info(String.format("Start to parse input parameters: %s", Arrays.toString(input)));
            commander.parse(input);
            InputData inputDataFf = JSON2JavaObjectConverter.convert(inputParameters.getFirstFile());
            InputData inputDataSf = JSON2JavaObjectConverter.convert(inputParameters.getSecondFile());
            IterateBy iterateMethod = IterateFactory.getIterateMethod(inputParameters);
            ComparatorBy comparator = ComparatorFactory.getComparator(inputParameters);
            OutputParameters diff = iterateMethod.iterateAndCompare(comparator, inputDataFf, inputDataSf);
            MapListConsolePrinter.print(diff);
        } catch (Exception e) {
            LOG.error(e);
            ExceptionConsolePrinter.print(e);
        }
    }
}
