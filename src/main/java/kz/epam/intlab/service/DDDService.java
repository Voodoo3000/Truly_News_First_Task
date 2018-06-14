package kz.epam.intlab.service;

import kz.epam.intlab.converter.EntityDTOConverter;
import kz.epam.intlab.dao.DaoException;
import kz.epam.intlab.dao.NewsDao;
import kz.epam.intlab.dto.CommentDTO;
import kz.epam.intlab.dto.NewsDTO;
import kz.epam.intlab.entity.Comment;
import kz.epam.intlab.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("service")
public class DDDService implements Service {

    @Autowired
    @Qualifier("newsEDCImpl")
    private EntityDTOConverter newsEntityDTOConverter;

    @Autowired
    @Qualifier("commentEDCImpl")
    private EntityDTOConverter commentEntityDTOConverter;
    @Autowired
    private NewsDao newsDao;

    @Override
    public Map<Integer, News> getAllNewsService() throws DaoException {
        return newsDao.getAllNews();
    }

    @Override
    public NewsDTO getNewsById(Integer id) throws DaoException {
        return (NewsDTO) newsEntityDTOConverter.convertEntityToDTO(newsDao.getNewsById(id));
    }

    @Override
    public void addUpdateNews(NewsDTO dto) throws DaoException {
        newsDao.addUpdateNews((News) newsEntityDTOConverter.convertDTOToEntity(dto));
    }

    @Override
    public void addUpdateCommentAction(Integer id, CommentDTO commentDTO) throws DaoException {

        NewsDTO newsDTO = (NewsDTO) newsEntityDTOConverter.convertEntityToDTO(newsDao.getNewsById(id));

        newsDTO.getDTOCommentList().add((Comment) commentEntityDTOConverter.convertDTOToEntity(commentDTO));

        newsDao.addUpdateNews((News) newsEntityDTOConverter.convertDTOToEntity(newsDTO));
    }

    @Override
    public void deleteNewsById(Integer id) throws DaoException {
        newsDao.deleteNews(newsDao.getNewsById(id));
    }
}
