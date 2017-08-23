package project.comparators;

import project.model.json.Document;

import java.util.List;

public interface ComparatorBy {
    List<String> getDiff(Document documentFf, Document documentSf);
}
