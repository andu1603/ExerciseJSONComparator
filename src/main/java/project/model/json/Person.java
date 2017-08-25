package project.model.json;

import lombok.Data;

@Data
public class Person {
    private String organization;
    private String role;
    private Integer rank;
    private String firstname;
    private String lastname;
}
