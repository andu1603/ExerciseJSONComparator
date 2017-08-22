package project.model.json;

import java.util.List;

public class Response {
    private List<Document> docs;

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }
}
