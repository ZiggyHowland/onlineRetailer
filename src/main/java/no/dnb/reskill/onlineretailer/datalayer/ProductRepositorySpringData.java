package no.dnb.reskill.onlineretailer.datalayer;

import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface ProductRepositorySpringData extends CrudRepository<Product, Long> {

}
