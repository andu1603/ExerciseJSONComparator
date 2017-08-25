package project;

import org.apache.log4j.Logger;
import project.controllers.Controller;


public class JSONComparatorApplication {
    private static final Logger LOG = Logger.getLogger(JSONComparatorApplication.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Started");
        LOG.info("Start application");
        Controller.run(args);
        LOG.info(String.format("Finished with %d ms", System.currentTimeMillis() - start));
        System.out.println("Finished");
    }
}
