package kz.epam.intlab.action;

import kz.epam.intlab.converter.CommentFormDTOConverterImpl;
import kz.epam.intlab.converter.FormDTOConverter;
import kz.epam.intlab.converter.NewsFormDTOConverterImpl;
import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dto.NewsDTO;
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

public class AddUpdateNewsAction extends ActionSupport {

    private static final Logger LOGGER = Logger.getLogger(AddUpdateNewsAction.class);

    public ActionForward execute (ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response) throws ActionException {
        NewsForm newsForm = (NewsForm) form;

        Service service = getWebApplicationContext().getBean(DDDService.class);
        FormDTOConverter formDTOConverter = getWebApplicationContext().getBean(NewsFormDTOConverterImpl.class);

        try {
            service.addUpdateNews((NewsDTO) formDTOConverter.convertFormToDTO(newsForm));
            LOGGER.info("Adding or updating news");
        } catch (DaoException e) {
            LOGGER.error("DaoException in addUpdateNews", e);
            throw new ActionException(e);
        }
        return mapping.findForward("main");
    }
}
