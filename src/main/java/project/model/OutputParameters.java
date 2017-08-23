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
    private StringBuilder msg;
    private List<OutputObject> output;

    public OutputParameters() {
        this.output = new ArrayList<>();
    }

    public void add(OutputObject output) {
        this.output.add(output);
    }

    public void setMsg(String msg) {
        this.msg = new StringBuilder(msg);
    }

    public void addMsg(String msg) {
        if (this.msg == null)
            setMsg(msg);
        else
            this.msg.append('\n').append(msg);
    }

    public String getMsg() {
        return msg == null ? null : msg.toString();
    }
}
