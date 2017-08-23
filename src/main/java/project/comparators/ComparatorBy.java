package project.comparators;

import project.model.json.Document;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;

public interface ComparatorBy {
    List<String> getDiff(Document documentFf, Document documentSf);
}
