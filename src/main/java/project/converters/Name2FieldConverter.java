package project.convertors;

import com.google.gson.annotations.SerializedName;
import project.convertors.JSONParameter2JavaObjectFieldNameConverter;
import project.model.json.Document;

import java.lang.reflect.Field;

public class Name2FieldConverter {
    public static Field convert(String name){
        String convertedName = JSONParameter2JavaObjectFieldNameConverter.convert(name);
        for(Field field:Document.class.getDeclaredFields()){
            if(convertedName.equals(field.getName())) return field;
            for(SerializedName annotation:field.getAnnotationsByType(SerializedName.class))
                if(name.equals(annotation.value()))
                    return field;
        }
        throw new RuntimeException("Please check input parameter name. It doesn't exist");//TODO: create new Exception type or use some existing
    }
}
