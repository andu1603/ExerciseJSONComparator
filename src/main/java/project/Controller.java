package project;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import project.model.InputParameters;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;

public class Controller {
    public static void run(String[] input){
        InputParameters inputParameters = new InputParameters();
        JCommander commander = JCommander.newBuilder()
                .addObject(inputParameters)
                .build();
        try {
            commander.parse(input);
            InputData inputDataFf = JSON2JavaObjectConverter.convert(inputParameters.getFirstFile());
            InputData inputDataSf = JSON2JavaObjectConverter.convert(inputParameters.getSecondFile());
            Map<String, List<String>> diff = Comparator.getDiff(inputDataFf, inputDataSf);
            System.out.println(diff);
        } catch (ParameterException e) {
            System.out.println("[ERROR.INCORRECT_PARAMETERS] " + e.getMessage());
        }
    }
}
