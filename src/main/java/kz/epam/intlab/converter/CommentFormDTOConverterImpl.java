package kz.epam.intlab.converter;

import kz.epam.intlab.dto.CommentDTO;
import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.listener.ContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("commentFDCImpl")
public class CommentFormDTOConverterImpl implements FormDTOConverter<CommentDTO>  {

    @Override
    public CommentDTO convertFormToDTO(NewsForm newsForm) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setNewsId(newsForm.getId());
        commentDTO.setCommentDate(newsForm.getCommentDate());
        commentDTO.setCommentAuthor(newsForm.getCommentAuthor());
        commentDTO.setCommentContent(newsForm.getCommentContent());

        return commentDTO;
    }

    @Override
    public void convertDTOToForm(NewsForm newsForm, CommentDTO dto) {

    }
}
