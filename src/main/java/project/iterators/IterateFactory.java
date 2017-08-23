package project.iterators;

import project.model.InputParameters;

public class IterateFactory {

    public static IterateBy getIterateMethod(InputParameters params){
        if(params.getIdForComparing()!=null)
            return new IterateByDocsByKey(params.getIdForComparing());
        return new IterateByDocsByOrder();
    }
}
