package no.dnb.reskill.onlineretailer;

import java.util.Collection;

// Represent business logic
public interface ProductService {
    void addToStock(String name, double price);
    void deleteFromStock(int productId);
    void updateStock(Product product);
    Collection<Product> findAllInStock();
    Product findProductByName(String productName);
}
