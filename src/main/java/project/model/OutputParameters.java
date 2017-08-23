package project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class OutputParameters {
    private String nameIdField;
    private List<OutputObject> output;

    public OutputParameters(){
        this.output=new ArrayList<>();
    }

    public void add(OutputObject output){
        this.output.add(output);
    }
}
