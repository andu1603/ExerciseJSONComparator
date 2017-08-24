package project.iterators;

import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.model.OutputObject;
import project.model.OutputParameters;
import project.model.json.Document;

import java.util.List;

public class IterateByDocsByOrder extends IterateByDocs {
    private static final Logger LOG = Logger.getLogger(IterateByDocsByOrder.class);

    @Override
    protected OutputParameters runIteration(ComparatorBy comparator, List<Document> inputDocsFf, List<Document> inputDocsSf) {
        OutputParameters output = new OutputParameters();
        output.setNameIdField("id");
        LOG.info("Comparing by order field");
        if (inputDocsFf.size() != inputDocsSf.size())
            output.addMsg("Count of search result objects is not equals in files. Diff = "
                    + Math.abs(inputDocsFf.size() - inputDocsSf.size()));
        for (int i = 0; i < getListWithMinOrEqLength(inputDocsFf, inputDocsSf).size(); i++) {
            Document documentFf = inputDocsFf.get(i);
            Document documentSf = inputDocsSf.get(i);
            LOG.info(String.format("Compare objects with keys: %s and %s", documentFf.getId(), documentSf.getId()));
            output.add(OutputObject.newBuilder()
                    .setValueIdFirstObj(documentFf.getId())
                    .setValueIdSecondObj(documentSf.getId())
                    .setDiffList(comparator.getDiff(documentFf, documentSf))
                    .build());
        }
        return output;
    }
}
