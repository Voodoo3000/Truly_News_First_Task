package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dao.NewsDao;
import kz.epam.intlab.entity.News;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.listener.ContextListener;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUpdateNewsAction extends Action {

    private NewsDao newsDao = ContextListener.getCtx().getBean(NewsDao.class);
    private static final Logger LOGGER = Logger.getLogger(AddUpdateNewsAction.class);

    public ActionForward execute (ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response) throws ActionException {

        NewsForm newsForm = (NewsForm) form;
        News news = ContextListener.getCtx().getBean(News.class);
        news.setId(newsForm.getId());
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        news.setDate(newsForm.getDate());
        try {
            newsDao.addUpdateNews(news);
            LOGGER.info("Adding or updating news");
        } catch (DaoException e) {
            LOGGER.error("DaoException in addUpdateNews", e);
            throw new ActionException(e);
        }
        return mapping.findForward("main");
    }
}
