package no.dnb.reskill.onlineretailer;

import java.util.Collection;
import java.util.List;

// Represent business logic
public interface ProductService {
    int addToStock(Product product);
    void deleteFromStock(int productId);
    void updateStock(Product product);
    Collection<Product> findAllInStock();
    List<Product> findProductByName(String productName);
}
