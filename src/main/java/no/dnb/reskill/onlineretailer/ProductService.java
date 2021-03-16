package no.dnb.reskill.onlineretailer;

import java.util.Collection;
import java.util.List;

// Represent business logic
public interface ProductService {
    Product addToStock(Product product);
    void deleteFromStock(long productId);
    void updateStock(Product product);
    Collection<Product> findAllInStock();
    List<Product> findProductByName(String productName);
}
