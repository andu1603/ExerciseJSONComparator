package project.iterators;

import project.comparators.ComparatorBy;
import project.model.OutputParameters;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;

public interface IterateBy {
    OutputParameters iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf);
    boolean isInputDataCorrect(InputData inputData);
}
