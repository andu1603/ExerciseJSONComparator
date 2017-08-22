package project;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.log4j.Logger;
import project.model.InputParameters;
import project.model.json.InputData;

import java.util.List;
import java.util.Map;


public class JSONComparator {
    private static final Logger LOG = Logger.getLogger(JSONComparator.class);

    public static void main(String[] args) {
        LOG.info("Start application");
        Controller.run(args);
        LOG.info("Finish application");
    }
}
