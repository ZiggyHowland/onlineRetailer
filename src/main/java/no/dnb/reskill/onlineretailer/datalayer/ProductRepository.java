package no.dnb.reskill.onlineretailer.datalayer;


import no.dnb.reskill.onlineretailer.models.Product;

import java.util.Collection;

// Represent logic to save (DB or memory)
// CRUD: Create, Read, Update, Delete
public interface ProductRepository {
    // Read
    Collection<Product> getAllProducts();
    Product getProductById(long id);

    // Create
    Product insertProduct(Product product);

    // Update
    boolean updateProduct(Product product);

    // Delete
    boolean deleteProduct(long id);

}
