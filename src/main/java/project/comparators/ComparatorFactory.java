package project.comparators;

import project.model.InputParameters;

public class ComparatorFactory {
    public static ComparatorBy getComparator(InputParameters params) {
        return new DocParamsComparator();
    }
}
