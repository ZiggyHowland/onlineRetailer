package no.dnb.reskill.onlineretailer;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryRuntimeMemory implements ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    @Override
    public int addProduct(Product product) {
        productMap.put(product.getId(), product);
        System.out.println("Repository: Product added to collection");
        return product.getId();
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
