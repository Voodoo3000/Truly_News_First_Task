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

        List<Integer> checkedBoxesList = (List<Integer>) request.getAttribute("checkedBoxesList");
        DaoNews daoNews = new DaoNews();
        for (int i : checkedBoxesList) {
            daoNews.deleteNews(daoNews.getNewsById(i));
        }

        return mapping.findForward("success");
    }
}
