package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoNews;
import kz.epam.intlab.instance.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenSelectedNewsAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        News newsBean = (News) form;
        DaoNews daoNews = new DaoNews();
        request.setAttribute("news", daoNews.getNewsById(newsBean.getId()));

        return mapping.findForward("success");
    }
}
