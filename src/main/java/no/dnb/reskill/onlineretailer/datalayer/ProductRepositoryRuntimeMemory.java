package no.dnb.reskill.onlineretailer.datalayer;


import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryRuntimeMemory implements ProductRepository {
    private static long nextId = 1;
    private Map<Long, Product> productMap = new HashMap<>();


    public ProductRepositoryRuntimeMemory() {
        insertProduct(new Product("Sunglasses", 199.99, 100));
        insertProduct(new Product("Hat", 29.49, 10));
        insertProduct(new Product("Shorts", 39.99, 50));
        insertProduct(new Product("Towel", 10.20, 30));
        insertProduct(new Product("Sandals", 19.00, 15));
        insertProduct(new Product("Sunscreen", 12.49, 125));
    }


    @Override
    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    @Override
    public Product getProductById(long id) {
        return productMap.get(id);
    }

    @Override
    public Product insertProduct(Product product) {
        if (product.getId() != Product.DUMMY_ID) {
            throw new IllegalArgumentException("Id for product to be inserted must be -1");
        }
        product.setId(nextId++);
        productMap.put(product.getId(), product);
        System.out.println("Repository: Product added to collection");
        return product;
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
    public boolean deleteProduct(long productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Repository: Product deleted");
            return true;
        }
        else {
            System.out.println("Repository: Product not found in collection");
            return false;
        }
    }




}
