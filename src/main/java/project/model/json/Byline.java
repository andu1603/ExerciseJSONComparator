package project.model.json;

import lombok.Data;

import java.util.List;

@Data
public class Byline {
    private List<Person> person;
    private String original;
    private String organization;
}
