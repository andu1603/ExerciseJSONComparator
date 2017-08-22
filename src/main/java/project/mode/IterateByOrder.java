package project.mode;

import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.Logger;
import project.comparators.ComparatorBy;
import project.model.json.Document;
import project.model.json.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IterateByOrder implements IterateBy {
    private static final Logger LOG = Logger.getLogger(IterateByOrder.class);

    @Override
    public Map<String, List<String>> iterateAndCompare(ComparatorBy comparator, InputData inputDataFf, InputData inputDataSf) {
        if (!isInputDataCorrect(inputDataFf) || !isInputDataCorrect(inputDataSf)) {
            LOG.info("One of the input files doesn't contain search results");
            return null;
        }
        Map<String, List<String>> output = new HashMap<String, List<String>>();
        LOG.info("Getting objects from search result");
        List<Document> inputDocsFf = inputDataFf.getResponse().getDocs();
        List<Document> inputDocsSf = inputDataSf.getResponse().getDocs();
        for (int i = 0; i < inputDocsFf.size(); i++) {
            Document documentFf = inputDocsFf.get(i);
            Document documentSf = inputDocsSf.get(i);
            String key = documentFf.getId() + "<-->" + documentSf.getId();
            LOG.info(StringFormatter.format("Compare documents {}", key));
            output.put(key, comparator.getDiff(documentFf, documentSf));
        }
        return output;
    }

    private static boolean isInputDataCorrect(InputData inputData) {
        return inputData != null
                && inputData.getResponse() != null
                && inputData.getResponse().getDocs() != null;
    }
}
