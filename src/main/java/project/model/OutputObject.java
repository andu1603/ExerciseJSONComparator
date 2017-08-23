package project.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class OutputObject {
    private String valueIdFirstObj;
    private String valueIdSecondObj;
    private List<String> diffList;
    private String msg;

    private OutputObject() {
    }

    public static Builder newBuilder() {
        return new OutputObject().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setValueIdFirstObj(String valueIdFirstObj) {
            OutputObject.this.valueIdFirstObj = valueIdFirstObj;
            return this;
        }

        public Builder setValueIdSecondObj(String valueIdSecondObj) {
            OutputObject.this.valueIdSecondObj = valueIdSecondObj;
            return this;
        }

        public Builder setDiffList(List<String> diffList) {
            OutputObject.this.diffList = diffList;
            return this;
        }

        public Builder setMsg(String msg) {
            OutputObject.this.msg = msg;
            return this;
        }

        public OutputObject build() {
            return OutputObject.this;
        }

    }


}
