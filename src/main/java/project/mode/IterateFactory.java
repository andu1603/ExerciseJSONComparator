package project.mode;

import project.comparators.ComparatorBy;
import project.comparators.DocParamsComparator;
import project.model.InputParameters;

public class IterateFactory {

    public static IterateBy getIterateMethod(InputParameters params){
        if(params.getIdForComparing()!=null)
            return new IterateByKey(params.getIdForComparing());
        return new IterateByOrder();
    }
}
