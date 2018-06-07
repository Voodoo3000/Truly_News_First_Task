package kz.epam.intlab.converter;

import kz.epam.intlab.form.NewsForm;
import kz.epam.intlab.parent.AbstractParentForEntityAndDTO;

import java.util.Objects;

public class FormDTOConverter implements Converter {

    @Override
    public AbstractParentForEntityAndDTO convertNewsFormToSomething(NewsForm newsForm) {
        return null;
    }

    @Override
    public NewsForm convertSomethingToNewsForm(AbstractParentForEntityAndDTO thing) {
        return null;
    }
}
