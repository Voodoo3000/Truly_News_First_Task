package kz.epam.intlab.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class NewsForm extends ActionForm {

    private Integer id;
    private String title;
    private String brief;
    private String content;
    private String date;

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
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if(getDate() == null ||  getDate().equals(""))
        {
            errors.add("message.date.err",
                    new ActionMessage("label.message.error_date"));
        }
        if(getTitle() == null ||  getTitle().equals(""))
        {
            errors.add("message.title.err",
                    new ActionMessage("label.message.error_title"));
        }
        if(getBrief() == null ||  getBrief().equals(""))
        {
            errors.add("message.brief.err",
                    new ActionMessage("label.message.error_brief"));
        }
        if(getContent() == null ||  getContent().equals(""))
        {
            errors.add("message.content.err",
                    new ActionMessage("label.message.error_content"));
        }

        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        setDate(String.valueOf(new Date()));
        setTitle("");
        setBrief("");
        setContent("");
        setId(0);
    }
}
