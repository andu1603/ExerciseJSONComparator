package project.mode;

import project.comparators.ComparatorBy;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;

public interface IterateBy {
    public Map<String, List<String>> iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf);
}
