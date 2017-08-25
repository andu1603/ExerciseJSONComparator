package project.model.json;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URL;
import java.util.Date;
import java.util.List;

@Data
public class Document {
    @SerializedName("abstract")
    private Integer abstr;
    @SerializedName("_id")
    private String id;
    private URL webUrl;
    private String snippet;
    private String leadParagraph;
    private Integer printPage;
    private String source;
    private Date pubDate;
    private String documentType;
    private String newsDesk;
    private String sectionName;
    private String subsectionName;
    private String typeOfMaterial;
    private Long wordCount;
    private String slideshowCredits;
    private Integer score;
    private Headline headline;
    private Byline byline;
    private List<String> blog;
    private List<Multimedia> multimedia;
    private List<Keyword> keywords;
}
