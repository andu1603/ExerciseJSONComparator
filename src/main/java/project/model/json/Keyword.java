package project.model.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Keyword {
    private String isMajor;
    private Integer rank;
    private String name;
    private String value;
}
