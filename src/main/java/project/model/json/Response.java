package project.model.json;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private List<Document> docs;
}
