package kz.epam.intlab.converter;

import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.parent.AbstractParentForEntityAndDTO;

public class EntityDTOConverter implements Converter {
    @Override
    public AbstractParentForEntityAndDTO convertNewsFormToSomething(NewsForm newsForm) {
        return null;
    }

    @Override
    public NewsForm convertSomethingToNewsForm(AbstractParentForEntityAndDTO thing) {
        return null;
    }
}
