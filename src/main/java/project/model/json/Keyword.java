package project.model.json;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Keyword {
    private String isMajor;
    private Integer rank;
    private String name;
    private String value;
}
