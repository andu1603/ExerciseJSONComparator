package project;

import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
import project.model.json.Document;
import project.model.json.InputData;

import java.lang.reflect.Field;
import java.util.*;

public class Comparator {
    private static final Logger LOG = Logger.getLogger(Comparator.class);

    public static Map<String, List<String>> getDiff(InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) {
            LOG.info("One of the input files doesn't contain search results");
            return null;
        }
        Map<String, List<String>> output = new HashMap<String, List<String>>();
        LOG.info("Getting objects from search result");
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        for (int i = 0; i < inputDocsFf.size(); i++) {
            Document documentFf = inputDocsFf.get(i);
            Document documentSf = inputDocsSf.get(i);
            String key = documentFf.getId() + "<-->" + documentSf.getId();
            LOG.info(StringFormatter.format("[{}]Compare documents {}", i, key));
            if (documentFf.equals(documentSf)) {
                LOG.info(StringFormatter.format("{} is equals ",key));
                output.put(key, Collections.singletonList("is equals"));
                continue;
            }
            List<String> diffFields = new ArrayList<>();
            Field[] fields = documentFf.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (!isValueEq(field.get(documentFf), field.get(documentSf))) {
                        LOG.info(StringFormatter.format("{} is not equals ", field.getName()));
                        diffFields.add(field.getName());
                    }
                    LOG.info(StringFormatter.format("{} is equals ", field.getName()));
                } catch (IllegalAccessException e) {
                    LOG.error(StringFormatter.format("Can't get access to {} field and getting {}",field.getName(), e));
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
