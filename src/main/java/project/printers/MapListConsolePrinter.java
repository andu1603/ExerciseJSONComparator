package project.printers;

import project.model.OutputObject;
import project.model.OutputParameters;

import java.util.List;
import java.util.Map;

public class MapListConsolePrinter {

    public static void print(OutputParameters output) {
        output.getOutput().forEach(outputObject -> {
            String valueIdFirstObj = outputObject.getValueIdFirstObj();
            String valueIdSecondObj = outputObject.getValueIdSecondObj();
            System.out.println(output.getNameIdField() + ": "
                    + valueIdFirstObj +
                    (valueIdFirstObj.equals(valueIdSecondObj) ? "" : " <--> " + valueIdSecondObj));
            for (String value : outputObject.getDiffList())
                System.out.println('\t' + value);
        });
    }
}
