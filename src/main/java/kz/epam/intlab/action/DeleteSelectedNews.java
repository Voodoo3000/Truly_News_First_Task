package kz.epam.intlab.action;

import kz.epam.intlab.dao.DaoNews;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteSelectedNews extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        String[] parameterValues = request.getParameterValues("deleteNewsCheckbox");
        DaoNews daoNews = new DaoNews();
        int id;
        for (String s :  parameterValues) {
            id = Integer.parseInt(s);
            daoNews.deleteNews(daoNews.getNewsById(id));
        }

        return mapping.findForward("success");
    }
}
