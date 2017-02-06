package main.java.entity;

/**
 * Created by riot_000 on 06.02.2017.
 */
public class Page {
    private String uri;
    private String header;
    private String content;
    private String title;
    private String templatePath;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Page(String uri, String header, String content, String title, String templatePath) {
        this.uri = uri;
        this.header = header;
        this.content = content;
        this.title = title;
        this.templatePath = templatePath;
    }
}
