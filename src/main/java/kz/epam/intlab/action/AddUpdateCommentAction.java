package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dao.NewsDao;
import kz.epam.intlab.entity.Comment;
import kz.epam.intlab.entity.News;
import kz.epam.intlab.form.NewsForm;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUpdateCommentAction extends Action {

    private static final Logger LOGGER = Logger.getLogger(AddUpdateCommentAction.class);

    public ActionForward execute (ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response) throws ActionException {

        NewsForm newsForm = (NewsForm) form;
        NewsDao newsDao = new NewsDao();
        News news;
        try {
            news = newsDao.getNewsById(newsForm.getId());
        } catch (DaoException e) {
            LOGGER.error("DaoException in AddUpdateCommentAction", e);
            throw new ActionException(e);
        }

        Comment comment = new Comment();
        comment.setNewsId(newsForm.getId());
        comment.setCommentDate(newsForm.getCommentDate());
        comment.setCommentAuthor(newsForm.getCommentAuthor());
        comment.setCommentContent(newsForm.getCommentContent());

        news.getCommentList().add(comment);

        try {
            newsDao.addUpdateNews(news);
            LOGGER.info("Adding comment");
        } catch (DaoException e) {
            LOGGER.error("DaoException in AddUpdateCommentAction", e);
            throw new ActionException(e);
        }

        return mapping.findForward("selected");
    }
}


