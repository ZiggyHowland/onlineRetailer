package no.dnb.reskill.onlineretailer.datalayer;

import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public class ProductRepositoryMongoDB implements ProductRepository {
    @Override
    public Collection<Product> getAllProducts() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Product getProductById(long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Product insertProduct(Product product) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean updateProduct(Product product) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean deleteProduct(long id) {
        throw new RuntimeException("Not implemented");
    }
}
