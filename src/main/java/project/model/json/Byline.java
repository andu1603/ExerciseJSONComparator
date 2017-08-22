package project.model.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Byline {
    private List<Person> person;
    private String original;
    private String organization;
}
