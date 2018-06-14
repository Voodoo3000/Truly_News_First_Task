package kz.epam.intlab.action;

import kz.epam.intlab.converter.FormDTOConverter;
import kz.epam.intlab.converter.NewsFormDTOConverterImpl;
import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.listener.ContextListener;
import kz.epam.intlab.service.DDDService;
import kz.epam.intlab.service.Service;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.struts.DispatchActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction extends DispatchActionSupport {

    private Service service;
    private FormDTOConverter formDTOConverter;

    @Override
    protected void onInit() {
         super.onInit();
         service = (Service) getWebApplicationContext().getBean("service");
         formDTOConverter = getWebApplicationContext().getBean(NewsFormDTOConverterImpl.class);
    }

    private static final Logger LOGGER = Logger.getLogger(NewsAction.class);

    public ActionForward openMainPage(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response) throws ActionException {
        try {
            request.getSession().setAttribute("newsTitle", service.getAllNewsService());
            LOGGER.info("Getting all news on main page");
        } catch (DaoException e) {
            LOGGER.error("DaoException in openMainPageAction", e);
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
            formDTOConverter.convertDTOToForm(newsForm, service.getNewsById(newsForm.getId()));
            LOGGER.info("Getting selected news");
        } catch (DaoException e) {
            LOGGER.error("DaoException in openSelectedNews", e);
            throw new ActionException(e);
        }
        return mapping.findForward("selected");
    }

    public ActionForward openEditNewsPage(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws ActionException {

        NewsForm newsForm = (NewsForm) form;
        try {
            formDTOConverter.convertDTOToForm(newsForm, service.getNewsById(newsForm.getId()));
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
                    service.deleteNewsById(id);
                    LOGGER.info("Deleting selected news");
                }
            } else {
                NewsForm newsForm = (NewsForm) form;
                service.deleteNewsById(newsForm.getId());
                LOGGER.info("Deleting news");
            }
        } catch (DaoException e) {
            LOGGER.error("DaoException in deleteNews", e);
            throw new ActionException(e);
        }

        return mapping.findForward("openMainAct");
    }
}
