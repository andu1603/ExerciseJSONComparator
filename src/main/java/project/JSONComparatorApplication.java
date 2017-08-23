package project;

import org.apache.log4j.Logger;
import project.controllers.Controller;
import project.convertors.JSONParameter2JavaObjectFieldNameConverter;


public class JSONComparatorApplication {
    private static final Logger LOG = Logger.getLogger(JSONComparatorApplication.class);

    public static void main(String[] args) {
        LOG.info("Start application");
        Controller.run(args);
        LOG.info("Finish application");
    }
}
