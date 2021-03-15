package no.dnb.reskill.onlineretailer;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryRuntimeMemory implements ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    // FROM ANDY: When adding, you generally don't know the id beforehand (it's typically generated by the database upon insertion).
    // So there's no nee dto test if the Map already contains the key - it couldn't possibly.
    // Also generally you return either a Product object (enriched with the now-known id), or just an integer with that id.
    @Override
    public void addProduct(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.replace(product.getId(), product);
            System.out.println("Repository: Product added to collection (updated)");
        }
        else {
            productMap.put(product.getId(), product);
            System.out.println("Repository: Product added to collection");
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Repository: Product deleted");
            return true;
        }
        else {
            System.out.println("Repository: Product not found in collection");
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        if (productMap.replace(product.getId(), product) != null) {
            System.out.println("Repository: Product updated");
            return true;
        }
        else {
            System.out.println("Repository: Product not found in collection");
            return false;
        }
    }

    @Override
    public Collection<Product> findAllProducts() {
        return productMap.values();
    }


}
