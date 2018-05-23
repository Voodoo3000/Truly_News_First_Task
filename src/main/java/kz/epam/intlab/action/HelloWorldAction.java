package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoNews;
import kz.epam.intlab.instance.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldAction extends Action{

    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response) throws Exception {

        DaoNews daoNews = new DaoNews();
        News news = (News) form;
        news.setTitle(daoNews.getNews().getTitle());
        news.setDate(daoNews.getNews().getDate());
        news.setBrief(daoNews.getNews().getBrief());
        news.setContent(daoNews.getNews().getContent());

        return mapping.findForward("success");
    }
}
