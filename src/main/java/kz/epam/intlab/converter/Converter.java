package kz.epam.intlab.converter;

import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.parent.AbstractParentForEntityAndDTO;

public interface Converter<T extends AbstractParentForEntityAndDTO> {

   T convertNewsFormToSomething (NewsForm newsForm);

   NewsForm convertSomethingToNewsForm (T thing);
}
