package project.iterators;

import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.model.OutputParameters;
import project.model.json.Document;
import project.model.json.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class IterateByDocs implements IterateBy {
    private static final Logger LOG = Logger.getLogger(IterateByDocs.class);

    @Override
    public boolean isInputDataCorrect(InputData inputData) {
        return inputData != null
                && inputData.getResponse() != null
                && inputData.getResponse().getDocs() != null;
    }

    @Override
    public OutputParameters iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) {
            LOG.info("One of the input files doesn't contain search results");
            return null;
        }
        LOG.info("Getting objects from search result");
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        return runIteration(comparator, inputDocsFf, inputDocsSf);
    }

    abstract OutputParameters runIteration(ComparatorBy comparator, List<Document> inputDocsFf, List<Document> inputDocsSf);
}
