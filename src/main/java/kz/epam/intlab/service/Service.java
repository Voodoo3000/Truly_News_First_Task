package kz.epam.intlab.service;

import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dto.NewsDTO;
import kz.epam.intlab.form.NewsForm;

public interface Service {
    public void forwardActionToDao(NewsDTO newsDTO);

    public NewsDTO getNewsById(Integer id) throws DaoException;
}
