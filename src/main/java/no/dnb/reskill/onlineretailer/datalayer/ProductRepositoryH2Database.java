package no.dnb.reskill.onlineretailer.datalayer;

import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class ProductRepositoryH2Database implements ProductRepository {

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public Collection<Product> getAllProducts() {
        String jpql = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public Product insertProduct(Product product) {
        if (product.getId() != Product.DUMMY_ID) {
            throw new IllegalArgumentException("Id for product to be inserted must be -1");
        }
        entityManager.persist(product);
        return product;
    }

    @Override
    @Transactional
    public boolean updateProduct(Product product) {
        try {
            Product p = entityManager.find(Product.class, product.getId());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setInStock(product.getInStock());
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteProduct(long id) {
        try {
            Product p = entityManager.find(Product.class, id);
            entityManager.remove(p);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }
}
