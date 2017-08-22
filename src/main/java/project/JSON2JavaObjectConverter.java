package project;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.model.json.InputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSON2JavaObjectConverter {

    public static InputData convert(File file) {
        return convert(file, FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    }

    public static InputData convert(File file, FieldNamingPolicy policy) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(policy).create();
        InputData inputData = null;
        try (FileReader reader = new FileReader(file)) {
            inputData = gson.fromJson(reader, InputData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;

    }


}
