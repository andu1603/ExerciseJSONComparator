package project.printers;

import project.model.OutputParameters;

public class MapListConsolePrinter {

    public static void print(OutputParameters output) {
        if (output.getMsg() != null && !output.getMsg().isEmpty())
            System.out.println(output.getMsg());
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
