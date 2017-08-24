package project.converters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import project.exceptions.IncorrectInputParametersException;
import project.exceptions.SystemException;
import project.model.json.InputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSON2JavaObjectConverter {
    private static final Logger LOG = Logger.getLogger(JSON2JavaObjectConverter.class);

    public static InputData convert(File file) {
        return convert(file, FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    }

    public static InputData convert(File file, FieldNamingPolicy policy) {
        LOG.info(String.format("Start to convert file %s to JSON object using policy %s",
                file.getName(),
                policy.name()));
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(policy)
                .create();
        InputData inputData;
        try (FileReader reader = new FileReader(file)) {
            inputData = gson.fromJson(reader, InputData.class);
        } catch (FileNotFoundException e) {
            throw new IncorrectInputParametersException(String.format("File %s wasn't found in the system.",
                    file.getName()), e);
        } catch (IOException e) {
            throw new SystemException(String.format("Problem with input thread for %s",
                    file.getName()), e);
        }
        LOG.info(String.format("File was successfully converted to %s", inputData));
        return inputData;

    }


}
