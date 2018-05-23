package kz.epam.intlab.instance;

import org.apache.struts.action.ActionForm;

import java.util.Date;

public class News extends ActionForm {

    private String title;
    private String brief;
    private String content;
    private Date date = new Date();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
