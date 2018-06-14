package kz.epam.intlab.dto;

import kz.epam.intlab.entity.Comment;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class NewsDTO extends DTOParent {

    private Integer id;
    private String title;
    private String brief;
    private String content;
    private String date;

    private List<Comment> DTOCommentList = new ArrayList<>();

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

    public List<Comment> getDTOCommentList() {
        return DTOCommentList;
    }

    public void setDTOCommentList(List<Comment> DTOCommentList) {
        this.DTOCommentList = DTOCommentList;
    }
}
