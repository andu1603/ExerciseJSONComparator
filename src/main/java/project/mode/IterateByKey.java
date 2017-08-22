package project.mode;

import project.comparators.ComparatorBy;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;

public class IterateByKey implements IterateBy {
    private String parameterName;

    public IterateByKey(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public Map<String, List<String>> iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf) {
        return null;
    }
}
