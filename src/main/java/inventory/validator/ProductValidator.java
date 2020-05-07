package inventory.validator;

import inventory.model.*;

import javax.xml.bind.ValidationException;

public class ProductValidator implements IValidator<Product> {
    @Override
    public void validate(Product entity) throws ValidationException {
        String errors = "";
        if(entity.getName() == null || entity.getName().equals("")){
            errors += "invalid name.";
        }
        if(entity.getInStock() < 0){
            errors += "invalid inStock";
        }
        if(entity.getPrice() < 0.0){
            errors += "invalid price";
        }
        if(entity.getMin() < 0 ) {
            errors += "invalid min";
        }
        if(entity.getMax() <= 0 ) {
            errors += "invalid max";
        }
        if(entity.getMin() > entity.getMax()){
            errors += "min can't be bigger than max";
        }
        if(entity.getInStock() < entity.getMin() || entity.getInStock() > entity.getMax()){
            errors += "inStock not in [min, max]";
        }
        if(entity.getAssociatedParts().size() == 0){
            errors += "listParts can't be empty";
        }
        if(errors.length() > 0){
            throw new ValidationException(errors);
        }
    }
}