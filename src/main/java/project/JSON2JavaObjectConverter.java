package project;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
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
        LOG.info(StringFormatter.format("Start to convert file {} to JSON object using policy ", file.getName(), policy.name()));
        Gson gson = new GsonBuilder().setFieldNamingPolicy(policy).create();
        InputData inputData = null;
        try (FileReader reader = new FileReader(file)) {
            inputData = gson.fromJson(reader, InputData.class);
        } catch (FileNotFoundException e) {
            LOG.error(StringFormatter.format("File {} wasn't found in the system", file.getName()));
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(StringFormatter.format("Some problem with input thread for {}: {}", file.getName(), e));
        }
        LOG.info(StringFormatter.format("File was successfully converted to {}", inputData));
        return inputData;

    }


}
