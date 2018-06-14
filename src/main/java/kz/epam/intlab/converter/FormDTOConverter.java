package kz.epam.intlab.converter;

import kz.epam.intlab.dto.DTOParent;
import kz.epam.intlab.form.NewsForm;

public interface FormDTOConverter<T extends DTOParent> {

    T convertFormToDTO(NewsForm newsForm);

    void convertDTOToForm(NewsForm newsForm, T dto);
}
