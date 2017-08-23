package project.iterators;

import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.convertors.Name2FieldConverter;
import project.model.OutputObject;
import project.model.OutputParameters;
import project.model.json.Document;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IterateByDocsByKey extends IterateByDocs {
    private static final Logger LOG = Logger.getLogger(IterateByDocsByKey.class);
    private Field field;

    public IterateByDocsByKey(String parameterName) {
        this.field = Name2FieldConverter.convert(parameterName);
    }

    public OutputParameters runIteration(ComparatorBy comparator, List<Document> inputDocsFf, List<Document> inputDocsSf) {
        field.setAccessible(true);
        OutputParameters output = new OutputParameters();
        output.setNameIdField(field.getName());
        Map<Object, Document> inputDocsMap = new HashMap<>();

        try {
            for (Document doc : getListWithMinOrEqLength(inputDocsFf, inputDocsSf)) {
                Object key = null;
                key = field.get(doc);
                if (key == null) {
                    LOG.warn("is empty");//TODO:add msg
                    continue;
                }
                inputDocsMap.put(key, doc);
            }
            for (Document doc : getListWithMaxLength(inputDocsFf, inputDocsSf)) {
                Object key = field.get(doc);
                if (key == null) {
                    LOG.warn("is empty");//TODO:add msg
                    continue;
                }
                OutputObject.Builder builder = OutputObject.newBuilder().setValueIdFirstObj(key.toString());
                Document docFromMap = inputDocsMap.get(key);
                if (docFromMap == null) {
                }
                builder.setValueIdSecondObj(key.toString());
                builder.setDiffList(comparator.getDiff(doc, docFromMap));
                output.add(builder.build());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return output;
    }

    private List<Document> getListWithMaxLength(List<Document> first, List<Document> second) {
        if (first.size() > second.size())
            return first;
        return second;
    }

    private List<Document> getListWithMinOrEqLength(List<Document> first, List<Document> second) {
        if (first.size() <= second.size())
            return first;
        return second;
    }

}
