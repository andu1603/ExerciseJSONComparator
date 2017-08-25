package project.printers;

import project.model.OutputParameters;

public class ConsolePrinter implements OutputDataPrinter{

    public void print(OutputParameters output) {
        if (output.getMsg() != null && !output.getMsg().isEmpty())
            System.out.println(output.getMsg());
        output.getOutput().forEach(outputObject -> {
            String valueIdFirstObj = outputObject.getValueIdFirstObj();
            String valueIdSecondObj = outputObject.getValueIdSecondObj();
            System.out.println(output.getNameIdField() + ": "
                    + valueIdFirstObj +
                    (valueIdFirstObj.equals(valueIdSecondObj) ? "" : " <--> " + valueIdSecondObj));
            outputObject.getDiffList().forEach(value -> System.out.println('\t' + value));
        });
    }
}
