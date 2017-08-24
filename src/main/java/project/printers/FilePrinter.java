package project.printers;

import project.exceptions.SystemException;
import project.model.OutputParameters;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements OutputDataPrinter {
    private String filepath;

    public FilePrinter(String path) {
        this.filepath = path;
    }

    @Override
    public void print(OutputParameters output) {
        String lineSeparator = System.getProperty("line.separator");
        try (FileWriter writer = new FileWriter(filepath)){
            StringBuilder builder = new StringBuilder();
            if (output.getMsg() != null && !output.getMsg().isEmpty())
                builder.append(output.getMsg())
                        .append(lineSeparator);
            output.getOutput().forEach(outputObject -> {
                String valueIdFirstObj = outputObject.getValueIdFirstObj();
                String valueIdSecondObj = outputObject.getValueIdSecondObj();
                builder.append(output.getNameIdField() + ": "
                        + valueIdFirstObj +
                        (valueIdFirstObj.equals(valueIdSecondObj) ? "" : " <--> " + valueIdSecondObj))
                        .append(lineSeparator);
                for (String value : outputObject.getDiffList())
                    builder.append('\t')
                            .append(value)
                            .append(lineSeparator);
            });
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new SystemException(String.format("Can't open %s file for output. Enter correct file path " +
                    "or run application with console output", filepath), e);
        }

    }
}
