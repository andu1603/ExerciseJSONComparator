package project.model.json;

import lombok.Data;

import java.net.URI;
import java.util.Map;

@Data
public class Multimedia {
    private Integer width;
    private URI url;
    private Integer rank;
    private Integer height;
    private String subtype;
    private String type;
    private Map<String, Object> legacy;
}
