package kz.epam.intlab.action;

import kz.epam.intlab.converter.CommentFormDTOConverterImpl;
import kz.epam.intlab.converter.FormDTOConverter;
import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dto.CommentDTO;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.service.DDDService;
import kz.epam.intlab.service.Service;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUpdateCommentAction extends ActionSupport {

    private static final Logger LOGGER = Logger.getLogger(AddUpdateCommentAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws ActionException {
        NewsForm newsForm = (NewsForm) form;

        Service service = getWebApplicationContext().getBean(DDDService.class);
        FormDTOConverter formDTOConverter = getWebApplicationContext().getBean(CommentFormDTOConverterImpl.class);

        try {
            service.addUpdateCommentAction(newsForm.getId(), (CommentDTO) formDTOConverter.convertFormToDTO(newsForm));
            LOGGER.info("Adding comment");
        } catch (DaoException e) {
            LOGGER.error("DaoException in AddUpdateCommentAction", e);
            throw new ActionException(e);
        }

        return mapping.findForward("selected");
    }
}


