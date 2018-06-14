package kz.epam.intlab.converter;

import kz.epam.intlab.dto.NewsDTO;
import kz.epam.intlab.entity.Comment;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.listener.ContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("newsFDCImpl")
public class NewsFormDTOConverterImpl implements FormDTOConverter<NewsDTO> {

    @Override
    public NewsDTO convertFormToDTO(NewsForm newsForm) {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(newsForm.getId());
        newsDTO.setDate(newsForm.getDate());
        newsDTO.setTitle(newsForm.getTitle());
        newsDTO.setBrief(newsForm.getBrief());
        newsDTO.setContent(newsForm.getContent());

        return newsDTO;
    }

    @Override
    public void convertDTOToForm(NewsForm newsForm, NewsDTO newsDTO) {

        newsForm.setId(newsDTO.getId());
        newsForm.setDate(newsDTO.getDate());
        newsForm.setTitle(newsDTO.getTitle());
        newsForm.setBrief(newsDTO.getBrief());
        newsForm.setContent(newsDTO.getContent());

        for (Comment formComment : newsDTO.getDTOCommentList()) {
            newsForm.getFormComments().add(formComment);
        }
    }
}
