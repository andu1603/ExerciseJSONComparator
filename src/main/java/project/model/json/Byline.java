package project.model.json;

import java.util.List;

public class Byline {
    private List<Person> person;
    private String original;
    private String organization;

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
