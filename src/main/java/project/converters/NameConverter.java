package project.converters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.annotations.SerializedName;
import project.exceptions.IncorrectInputParametersException;
import project.model.json.Document;

import java.lang.reflect.Field;

public class NameConverter {

    public static Field convertParameter2FieldObj(String name) {
        String convertedName = convertParameter2FieldName(name);
        for (Field field : Document.class.getDeclaredFields()) {
            if (convertedName.equals(field.getName())) return field;
            for (SerializedName annotation : field.getAnnotationsByType(SerializedName.class))
                if (name.equals(annotation.value()))
                    return field;
        }
        throw new IncorrectInputParametersException(String.format("Parameter with name like %s doesn't exist " +
                "in the Document class", name));
    }

    public static String convertFieldObj2Parameter(Field field){
        for (SerializedName annotation : field.getAnnotationsByType(SerializedName.class))
            return annotation.value();
        return FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.translateName(field);
    }

    public static String convertParameter2FieldName(String name) {
        StringBuilder translation = new StringBuilder();
        while (name.startsWith("_")) {
            name = name.substring(1);
        }
        if (!name.contains("_"))
            return name;
        String[] words = name.split("_");
        translation.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            translation.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1));
        }
        return translation.toString();
    }


}
