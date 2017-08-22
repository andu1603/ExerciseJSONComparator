package project.model.json;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class Document {
    private URL webUrl;
    private String snippet;
    private String leadParagraph;
    @SerializedName("abstract")
    private Integer abstr;

    public Integer getAbstr() {
        return abstr;
    }

    public void setAbstr(Integer abstr) {
        this.abstr = abstr;
    }

    private Integer printPage;
    private List<String> blog;
    private String source;
    private List<Multimedia> multimedia;
    private Headline headline;
    private List<Keyword> keywords;
    private Date pubDate;
    private String documentType;
    private String newsDesk;
    private String sectionName;
    private String subsectionName;
    private Byline byline;
    private String typeOfMaterial;
    @SerializedName("_id")
    private String id;
    private Long wordCount;
    private String slideshowCredits;
    private Integer score;

    public URL getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(URL webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public Integer getPrintPage() {
        return printPage;
    }

    public void setPrintPage(Integer printPage) {
        this.printPage = printPage;
    }

    public List<String> getBlog() {
        return blog;
    }

    public void setBlog(List<String> blog) {
        this.blog = blog;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSubsectionName() {
        return subsectionName;
    }

    public void setSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }

    public String getSlideshowCredits() {
        return slideshowCredits;
    }

    public void setSlideshowCredits(String slideshowCredits) {
        this.slideshowCredits = slideshowCredits;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
