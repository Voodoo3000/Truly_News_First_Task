package kz.epam.intlab.dao;

import kz.epam.intlab.instance.News;

import java.util.Map;

public interface DaoService {

    void addNews(News newsBean);

    Map<Integer, News> getAllNews();

    News getNewsById(Integer id);

    void updateNews (News newsBean);

    void deleteNews (News newsBean);
}
