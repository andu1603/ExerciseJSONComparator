package project.converters;

import com.google.gson.annotations.SerializedName;
import project.exceptions.IncorrectInputParametersException;
import project.model.json.Document;

import java.lang.reflect.Field;

public class Name2FieldConverter {
    public static Field convert(String name) {
        String convertedName = JSONParameter2JavaObjectFieldNameConverter.convert(name);
        for (Field field : Document.class.getDeclaredFields()) {
            if (convertedName.equals(field.getName())) return field;
            for (SerializedName annotation : field.getAnnotationsByType(SerializedName.class))
                if (name.equals(annotation.value()))
                    return field;
        }
        throw new IncorrectInputParametersException(String.format("Parameter with name like %s doesn't exist " +
                "in the Document class", name));
    }
}
