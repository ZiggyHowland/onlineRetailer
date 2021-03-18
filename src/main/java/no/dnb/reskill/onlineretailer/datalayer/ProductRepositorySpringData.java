package no.dnb.reskill.onlineretailer.datalayer;

import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface ProductRepositorySpringData extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.inStock <= ?1")
    Iterable<Product> findProductsBelowStockThreshold(long threshold);

    List<Product> findByName(String name);
}
