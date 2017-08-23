package project.iterators;

import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.converters.Name2FieldConverter;
import project.exceptions.IncorrectInputParametersException;
import project.exceptions.SystemException;
import project.model.OutputObject;
import project.model.OutputParameters;
import project.model.json.Document;

import java.lang.reflect.Field;
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
        try {
            Map<Object, Document> inputDocsFfMap = formMap(inputDocsFf);
            Map<Object, Document> inputDocsSfMap = formMap(inputDocsSf);
            int diffFf = Math.abs(inputDocsFf.size() - inputDocsFfMap.size());
            int diffSf = Math.abs(inputDocsSf.size() - inputDocsSfMap.size());
            if (diffFf > 0 || diffSf > 0) {
                output.addMsg(String.format("Search result contains objects with empty key parameter: " +
                        "%d from first file and %d from second", diffFf, diffSf));
            }
            if (inputDocsFfMap.keySet().retainAll(inputDocsSfMap.keySet()))
                output.addMsg("Search result from one file contains objects without pair in the other file");
            for (Object key : inputDocsFfMap.keySet()) {
                OutputObject.Builder builder = OutputObject.newBuilder().setValueIdFirstObj(key.toString());
                Document docFromMap = inputDocsSfMap.get(key);
                builder.setValueIdSecondObj(key.toString());
                builder.setDiffList(comparator.getDiff(inputDocsFfMap.get(key), docFromMap));
                output.add(builder.build());
            }
        } catch (IllegalAccessException e) {
            throw new SystemException("Problem with field access", e);
        }
        return output;
    }

    private Map<Object, Document> formMap(List<Document> list) throws IllegalAccessException {
        Map<Object, Document> resultMap = new HashMap<>();
        for (Document doc : list) {
            Object key = field.get(doc);
            if (key == null) return resultMap;
            if (resultMap.containsKey(key)) {
                throw new IncorrectInputParametersException("Objects from search result contains duplicates by input key");
            } else
                resultMap.put(key, doc);
        }
        return resultMap;
    }

}
