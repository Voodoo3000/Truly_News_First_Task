package kz.epam.intlab.dao;

import kz.epam.intlab.instance.News;

public interface DaoService {

    News getNews();

    void editNews (News newsBean);
}
