package kz.epam.intlab.converter;

import kz.epam.intlab.dto.CommentDTO;
import kz.epam.intlab.entity.Comment;
import kz.epam.intlab.listener.ContextListener;
import org.springframework.stereotype.Component;

@Component("commentEDCImpl")
public class CommentEntityDTOConverterImpl implements EntityDTOConverter<CommentDTO, Comment> {

    @Override
    public CommentDTO convertEntityToDTO(Comment entity) {
        return null;
    }

    @Override
    public Comment convertDTOToEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setNewsId(dto.getNewsId());
        comment.setCommentDate(dto.getCommentDate());
        comment.setCommentAuthor(dto.getCommentAuthor());
        comment.setCommentContent(dto.getCommentContent());

        return comment;
    }
}
