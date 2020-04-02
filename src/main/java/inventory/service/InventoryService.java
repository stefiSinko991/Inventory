package inventory.service;

import inventory.model.*;
import inventory.repository.InventoryRepository;
import javafx.collections.ObservableList;

public class InventoryService {

    // Se initializeaza repository-ul
    private InventoryRepository repo;

    // Se initializeaza service-ul
    public InventoryService(InventoryRepository repo){
        this.repo =repo;
    }

    // Se trateaza cazul de adaugare in care piesa este fabricata
    public void addInhousePart(String name, double price, int inStock, int min, int  max, int partDynamicValue){
        InhousePart inhousePart = new InhousePart(repo.getAutoPartId(), name, price, inStock, min, max, partDynamicValue);
        String error = "";
        error = AbstractPart.isValidPart(name, price, inStock, min, max, error);

        if (error.length() == 0){
            repo.addPart(inhousePart);
        } else {
            throw new IllegalArgumentException(error);
        }
    }

    // Se trateaza cazul de adaugare in care piesa este cumparata
    public void addOutsourcePart(String name, double price, int inStock, int min, int  max, String partDynamicValue){
        OutsourcedPart outsourcedPart = new OutsourcedPart(repo.getAutoPartId(), name, price, inStock, min, max, partDynamicValue);
        repo.addPart(outsourcedPart);
    }

    // Se adauga un produs
    public void addProduct(String name, double price, int inStock, int min, int  max, ObservableList<AbstractPart> addParts){
        Product product = new Product(repo.getAutoProductId(), name, price, inStock, min, max, addParts);
        repo.addProduct(product);
    }

    public ObservableList<AbstractPart> getAllParts() {
        return repo.getAllParts();
    }

    public ObservableList<Product> getAllProducts() {
        return repo.getAllProducts();
    }

    public AbstractPart lookupPart(String search) {
        return repo.lookupPart(search);
    }

    public Product lookupProduct(String search) {
        return repo.lookupProduct(search);
    }

    // Se modifica o piesa fabricata
    public void updateInhousePart(int partIndex, int partId, String name, double price, int inStock, int min, int max, int partDynamicValue){
        InhousePart inhousePart = new InhousePart(partId, name, price, inStock, min, max, partDynamicValue);
        repo.updatePart(partIndex, inhousePart);
    }

    // Se modifica o piesa cumparat
    public void updateOutsourcedPart(int partIndex, int partId, String name, double price, int inStock, int min, int max, String partDynamicValue){
        OutsourcedPart outsourcedPart = new OutsourcedPart(partId, name, price, inStock, min, max, partDynamicValue);
        repo.updatePart(partIndex, outsourcedPart);
    }

    // Se modifica un produs
    public void updateProduct(int productIndex, int productId, String name, double price, int inStock, int min, int max, ObservableList<AbstractPart> addParts){
        Product product = new Product(productId, name, price, inStock, min, max, addParts);
        repo.updateProduct(productIndex, product);
    }

    // Se sterge o piesa
    public void deletePart(AbstractPart part){
        repo.deletePart(part);
    }

    // Se sterge un produs
    public void deleteProduct(Product product){
        repo.deleteProduct(product);
    }

}
