package kz.epam.intlab.dao;

import kz.epam.intlab.entity.News;

import java.util.Map;

public interface DaoService {

    void addUpdateNews(News newsBean);

    Map<Integer, News> getAllNews();

    News getNewsById(Integer id);

    void deleteNews (News newsBean);
}
