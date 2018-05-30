package kz.epam.intlab.dao;

import kz.epam.intlab.entity.News;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.util.*;

public class NewsDao implements Dao {

    private static final Logger LOGGER = Logger.getLogger(NewsDao.class);

    SessionFactory sessionFactory;
    Session session;

    public NewsDao() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public Map<Integer, News> getAllNews() throws DaoException {
        Map<Integer, News> newsTitle = new HashMap<>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List result = session.createQuery("from News").list();
            for (News news : (List<News>) result) {
                newsTitle.put(news.getId(), news);
            }
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            LOGGER.error("HibernateException in getAllNews", e);
            throw new DaoException();
        }
        return newsTitle;
    }

    @Override
    public News getNewsById(Integer id) throws DaoException {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            News result = (News) session.createQuery("from News where id=:id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            LOGGER.error("HibernateException in getNewsById", e);
            throw new DaoException();
        }
    }

    @Override
    public void addUpdateNews(News news) throws DaoException {
        try {
        session = sessionFactory.openSession();
        session.beginTransaction();
        if (news.getId() != 0) {
            session.update(news);
        } else session.save(news);
        session.getTransaction().commit();
        session.close();
        } catch (HibernateException e) {
            LOGGER.error("HibernateException in addUpdateNews", e);
            throw new DaoException();
        }
    }

    @Override
    public void deleteNews(News newsBean) throws DaoException {
        try {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newsBean);
        session.getTransaction().commit();
        session.close();
        } catch (HibernateException e) {
            LOGGER.error("HibernateException in deleteNews", e);
            throw new DaoException();
        }
    }
}
