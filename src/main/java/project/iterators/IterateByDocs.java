package project.iterators;

import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.exceptions.IncorrectInputParametersException;
import project.model.OutputParameters;
import project.model.json.Document;
import project.model.json.InputData;

import java.util.List;

public abstract class IterateByDocs implements IterateBy {
    private static final Logger LOG = Logger.getLogger(IterateByDocs.class);

    private boolean isInputDataCorrect(InputData inputData) {
        return inputData != null
                && inputData.getResponse() != null
                && inputData.getResponse().getDocs() != null
                && !inputData.getResponse().getDocs().isEmpty();
    }

    @Override
    public OutputParameters iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) {
            throw new IncorrectInputParametersException("One of the input files doesn't contain search results");
        }
        LOG.info("Getting objects from search result");
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        return runIteration(comparator, inputDocsFf, inputDocsSf);
    }

    protected List<Document> getListWithMaxLength(List<Document> first, List<Document> second) {
        if (first.size() > second.size())
            return first;
        return second;
    }

    protected List<Document> getListWithMinOrEqLength(List<Document> first, List<Document> second) {
        if (first.size() <= second.size())
            return first;
        return second;
    }

    protected abstract OutputParameters runIteration(ComparatorBy comparator, List<Document> inputDocsFf, List<Document> inputDocsSf);
}
