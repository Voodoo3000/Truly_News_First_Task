package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dao.NewsDao;
import kz.epam.intlab.entity.Comment;
import kz.epam.intlab.entity.News;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.listener.ContextListener;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction extends DispatchAction {

    private NewsDao newsDao = ContextListener.getCtx().getBean(NewsDao.class);
    private static final Logger LOGGER = Logger.getLogger(NewsAction.class);

    public ActionForward openMainPage(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response) throws ActionException {
        System.out.println("MANUAL RESET");
        form.reset(mapping, request);
        try {
            request.getSession().setAttribute("newsTitle", newsDao.getAllNews());
            LOGGER.info("Getting all news on main page");
        } catch (DaoException e) {
            LOGGER.error("DaoException in openMainPageAvtion", e);
            throw new ActionException(e);
        }
        return mapping.findForward("main");
    }

    public ActionForward openSelectedNews(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws ActionException {

        NewsForm newsForm = (NewsForm) form;
        int id = newsForm.getId();
        newsForm.reset(mapping, request);
        newsForm.setId(id);

        try {
            setNewsEntityInForm(newsForm);
            LOGGER.info("Getting selected news");
        } catch (DaoException e) {
            LOGGER.error("DaoException in openSelectedNews", e);
            throw new ActionException(e);
        }
        return mapping.findForward("selected");
    }

    private void setNewsEntityInForm(NewsForm newsForm) throws DaoException {

        News news = newsDao.getNewsById(newsForm.getId());
        newsForm.setId(news.getId());
        newsForm.setTitle(news.getTitle());
        newsForm.setBrief(news.getBrief());
        newsForm.setContent(news.getContent());
        newsForm.setDate(news.getDate());

        for (Comment comment: news.getCommentList()) {
            newsForm.getFormComments().add(comment);
        }
    }

    public ActionForward openEditNewsPage(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws ActionException {

        NewsForm newsForm = (NewsForm) form;
        try {
            setNewsEntityInForm(newsForm);
            LOGGER.info("Getting selected news to edit mode page");
        } catch (DaoException e) {
            LOGGER.error("DaoException in openEditNewsPage", e);
            throw new ActionException(e);
        }
        return mapping.findForward("edit");
    }

    public ActionForward deleteNews(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) throws ActionException {

        try {
            if ((request.getParameterValues("deleteNewsCheckbox")) != null) {
                String[] parameterValues = request.getParameterValues("deleteNewsCheckbox");
                int id;
                for (String s : parameterValues) {
                    id = Integer.parseInt(s);
                    newsDao.deleteNews(newsDao.getNewsById(id));
                    LOGGER.info("Deleting selected news");
                }
            } else {
                NewsForm newsForm = (NewsForm) form;
                News newsForDeleting = newsDao.getNewsById(newsForm.getId());
                newsDao.deleteNews(newsForDeleting);
                LOGGER.info("Deleting news");
            }
        } catch (DaoException e) {
            LOGGER.error("DaoException in deleteNews", e);
            throw new ActionException(e);
        }
        openMainPage(mapping, form, request, response);

        return mapping.findForward("main");
    }
}
