package project.model.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Person {
    private String organization;
    private String role;
    private Integer rank;
    private String firstname;
    private String lastname;
}
