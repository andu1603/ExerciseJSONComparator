package project.model.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URI;
import java.util.Map;

@ToString
@Getter
@Setter
public class Multimedia {
    private Integer width;
    private URI url;
    private Integer rank;
    private Integer height;
    private String subtype;
    private String type;
    private Map<String, Object> legacy;
}
