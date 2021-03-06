package project.comparators;

import org.apache.log4j.Logger;
import project.converters.NameConverter;
import project.exceptions.SystemException;
import project.model.json.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocParamsComparator implements ComparatorBy {
    private static final Logger LOG = Logger.getLogger(DocParamsComparator.class);

    public List<String> getDiff(Document documentFf, Document documentSf) {
        if (documentFf.equals(documentSf)) {
            LOG.info(String.format("%s is equals %s", documentFf.getId(), documentSf.getId()));
            return Collections.singletonList("is equals");
        }
        List<String> diffFields = new ArrayList<>();
        Field[] fields = documentFf.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!isValueEq(field.get(documentFf), field.get(documentSf))) {
                    diffFields.add(NameConverter.convertFieldObj2Parameter(field));
                }
            } catch (IllegalAccessException e) {
                throw new SystemException(String.format("Can't get access to %s field",
                        field.getName()), e);
            }
        }
        LOG.info(String.format("Diff in %s fields", diffFields.toString()));
        return diffFields;
    }

    private static boolean isValueEq(Object first, Object second) {
        return first == null && second == null
                || first != null && first.equals(second);
    }
}
