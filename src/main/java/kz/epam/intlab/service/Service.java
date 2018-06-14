package kz.epam.intlab.service;

import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dto.CommentDTO;
import kz.epam.intlab.dto.NewsDTO;
import kz.epam.intlab.entity.News;

import java.util.Map;

public interface Service {

    public Map<Integer, News> getAllNewsService() throws DaoException;

    public void addUpdateNews(NewsDTO dto) throws DaoException;

    public void addUpdateCommentAction(Integer id,CommentDTO commentDTO) throws DaoException;

    public NewsDTO getNewsById(Integer id) throws DaoException;

    public void deleteNewsById(Integer id) throws DaoException;
}
