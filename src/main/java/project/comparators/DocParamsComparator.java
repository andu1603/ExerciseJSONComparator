package project.comparators;

import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
import project.model.json.Document;

import java.lang.reflect.Field;
import java.util.*;

public class DocParamsComparator implements ComparatorBy {
    private static final Logger LOG = Logger.getLogger(DocParamsComparator.class);

    public List<String> getDiff(Document documentFf, Document documentSf) {
        if (documentFf.equals(documentSf)) {
            LOG.info(StringFormatter.format("{} is equals "));
            return Collections.singletonList("is equals");
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
        return diffFields;
    }

    private static boolean isValueEq(Object first, Object second) {
        return first == null && second == null
                || first != null && first.equals(second);
    }
}
