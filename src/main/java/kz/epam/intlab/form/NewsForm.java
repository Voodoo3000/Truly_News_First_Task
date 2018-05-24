package kz.epam.intlab.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class NewsForm extends ActionForm {

    private Integer id;
    private String title;
    private String brief;
    private String content;
    private String date = String.valueOf(new Date());
    //News news;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        setDate("");
        setTitle("");
        setBrief("");
        setContent("");
        setId(0);
    }
    //    public News getNews() {
//        return news;
//    }
//
//    public void setNews(News news) {
//        this.news = news;
//    }
}
