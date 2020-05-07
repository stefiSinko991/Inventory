package inventory.validator;

import javax.xml.bind.ValidationException;

public interface IValidator<T> {
    void validate(T entity) throws ValidationException;
}
