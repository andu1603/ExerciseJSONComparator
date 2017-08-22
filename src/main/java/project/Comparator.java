package project;

import project.model.json.Document;
import project.model.json.InputData;

import java.lang.reflect.Field;
import java.util.*;

public class Comparator {

    public static Map<String, List<String>> getDiff(InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) return null;
        Map<String, List<String>> output = new HashMap<String, List<String>>();
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        for (int i = 0; i < inputDocsFf.size(); i++) {
            Document documentFf = inputDocsFf.get(i);
            Document documentSf = inputDocsSf.get(i);
            String key = documentFf.getId() + "<-->" + documentSf.getId();
            if (documentFf.equals(documentSf)) {
                output.put(key, Collections.singletonList("is equals"));
                continue;
            }
            List<String> diffFields = new ArrayList<>();
            Field[] fields = documentFf.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (!isValueEq(field.get(documentFf), field.get(documentSf))) {
                        diffFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.getCause();

                }
            }
            output.put(key, diffFields);
        }
        return output;
    }

    private static boolean isValueEq(Object first, Object second) {
        return first == null && second == null
                || first != null && first.equals(second);
    }

    private static boolean isInputDataCorrect(InputData inputData) {
        return inputData != null
                && inputData.getResponse() != null
                && inputData.getResponse().getDocs() != null;
    }
}
