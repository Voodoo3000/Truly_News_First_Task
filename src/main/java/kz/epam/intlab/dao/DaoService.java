package kz.epam.intlab.dao;

import kz.epam.intlab.instance.News;

import java.util.Map;

public interface DaoService {

    Map<Integer, News> getAllNews();

    News getNewsById(Integer id);

    void editNews (News newsBean);
}
