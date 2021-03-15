package no.dnb.reskill.onlineretailer;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryRuntimeMemory implements ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.replace(product.getId(), product);
        }
        else {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productMap.remove(productId) != null;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productMap.replace(product.getId(), product) != null;
    }

    @Override
    public Collection<Product> findAllProducts() {
        return productMap.values();
    }
}
