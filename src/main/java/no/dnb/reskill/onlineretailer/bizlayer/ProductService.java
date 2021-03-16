package no.dnb.reskill.onlineretailer.bizlayer;

import no.dnb.reskill.onlineretailer.models.Product;

import java.util.Collection;
import java.util.List;

// Represent business logic
// Has nothing to do with database, only about user needs
public interface ProductService {
    double calculateTotalValue();
    Collection<Product> getLowStockProducts(long threshold);
    double getAveragePrice();
    double adjustPriceByPercent(long id, double byPercent);
    double getVatByPrice(double price);




    Product addToStock(Product product);
    void deleteFromStock(long productId);
    void updateStock(Product product);
    Collection<Product> findAllInStock();
    List<Product> findProductByName(String productName);
}
