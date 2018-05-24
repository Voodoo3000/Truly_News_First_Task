package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoNews;
import kz.epam.intlab.entity.News;
import kz.epam.intlab.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction extends DispatchAction {

    private DaoNews daoNews = new DaoNews();

    public ActionForward openMainPage(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getSession().setAttribute("newsTitle", daoNews.getAllNews());

        return mapping.findForward("main");
    }

    public ActionForward openSelectedNews(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        News news = daoNews.getNewsById(newsForm.getId());

        newsForm.setId(news.getId());
        newsForm.setTitle(news.getTitle());
        newsForm.setBrief(news.getBrief());
        newsForm.setContent(news.getContent());
        newsForm.setDate(news.getDate());

        return mapping.findForward("selected");
    }

    public ActionForward addUpdateNews(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;

        News news = new News();
        news.setId(newsForm.getId());
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        news.setDate(newsForm.getDate());

        daoNews.addUpdateNews(news);

        openMainPage(mapping, form, request, response);

        return mapping.findForward("main");
    }

    public ActionForward openEditNewsPage(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        News news = daoNews.getNewsById(newsForm.getId());

        newsForm.setId(news.getId());
        newsForm.setTitle(news.getTitle());
        newsForm.setBrief(news.getBrief());
        newsForm.setContent(news.getContent());
        newsForm.setDate(news.getDate());

        return mapping.findForward("edit");
    }

    public ActionForward deleteNews(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {


        if ((request.getParameterValues("deleteNewsCheckbox")) != null) {
            String[] parameterValues = request.getParameterValues("deleteNewsCheckbox");

            int id;
            for (String s : parameterValues) {
                id = Integer.parseInt(s);
                daoNews.deleteNews(daoNews.getNewsById(id));
            }
        } else {
            NewsForm newsForm = (NewsForm) form;
            News newsForDeleting = daoNews.getNewsById(newsForm.getId());
            daoNews.deleteNews(newsForDeleting);
        }
        openMainPage(mapping, form, request, response);

        return mapping.findForward("main");
    }
}
