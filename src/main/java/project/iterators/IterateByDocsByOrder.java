package project.iterators;

import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.model.OutputObject;
import project.model.OutputParameters;
import project.model.json.Document;
import project.model.json.InputData;

import java.util.List;

public class IterateByDocsByOrder extends IterateByDocs {
    private static final Logger LOG = Logger.getLogger(IterateByDocsByOrder.class);
    //TODO:what if arrays length is different?

    @Override
    public OutputParameters iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) {
            LOG.info("One of the input files doesn't contain search results");
            return null;
        }
        OutputParameters output = new OutputParameters();
        output.setNameIdField("id");
        LOG.info("Getting objects from search result");
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        for (int i = 0; i < inputDocsFf.size(); i++) {
            Document documentFf = inputDocsFf.get(i);
            Document documentSf = inputDocsSf.get(i);
            output.add(OutputObject.newBuilder()
                    .setValueIdFirstObj(documentFf.getId())
                    .setValueIdSecondObj(documentSf.getId())
                    .setDiffList(comparator.getDiff(documentFf, documentSf))
                    .build());
        }
        return output;
    }

    @Override
    OutputParameters runIteration(ComparatorBy comparator, List<Document> inputDocsFf, List<Document> inputDocsSf) {
        return null;
    }
}
