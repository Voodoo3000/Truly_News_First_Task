package kz.epam.intlab.dao;

import kz.epam.intlab.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.util.*;

public class DaoNews implements DaoService {

    private static Map<Integer, News> newsTitle = new HashMap<>();

    private Connection connect;
    SessionFactory sessionFactory;
    Session session;

    public DaoNews() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public Map<Integer, News> getAllNews() {
        Map<Integer, News> newsTitle = new HashMap<>();
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from News" ).list();
        for ( News news : (List<News>) result ) {
            newsTitle.put(news.getId() ,news);
        }
        session.getTransaction().commit();
        session.close();
        return newsTitle;
    }

    @Override
    public News getNewsById(Integer id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        News result = (News) session.createQuery( "from News where id=:id" ).setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void addUpdateNews(News news) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        if (news.getId() != 0) {
            session.update(news);
        } else session.save(news);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteNews(News newsBean) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newsBean);
        session.getTransaction().commit();
        session.close();
    }

    public static Map<Integer, News> getNewsTitle() {
        return newsTitle;
    }

    public static void setNewsTitle(Map<Integer, News> newsTitle) {
        DaoNews.newsTitle = newsTitle;
    }

}
