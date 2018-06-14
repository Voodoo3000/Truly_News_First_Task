package kz.epam.intlab.converter;

import kz.epam.intlab.dto.DTOParent;
import kz.epam.intlab.entity.EntityParent;

public interface EntityDTOConverter<T extends DTOParent, K extends EntityParent> {

    T convertEntityToDTO(K entity);

    K convertDTOToEntity(T dto);
}
