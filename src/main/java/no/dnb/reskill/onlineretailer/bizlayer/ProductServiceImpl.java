package no.dnb.reskill.onlineretailer.bizlayer;

import no.dnb.reskill.onlineretailer.models.Product;
import no.dnb.reskill.onlineretailer.datalayer.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository; // If autowiring field, then Mocking upon test - will be possible (since private)


    @Autowired
    public ProductServiceImpl(@Qualifier("productRepositoryRuntimeMemory") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public double calculateTotalValue() {
        return productRepository.getAllProducts()
                .stream()
                .mapToDouble(p -> p.getPrice() * p.getInStock())
                .sum();
    }


    @Override
    public Collection<Product> getLowStockProducts(long threshold) {
        return productRepository.getAllProducts()
                .stream()
                .filter(p -> p.getInStock() < threshold)
                .collect(Collectors.toList());

    }

    @Override
    public double getAveragePrice() {
        return productRepository.getAllProducts()
                .stream()
                .mapToDouble( p -> p.getPrice() )
                .average()
                .orElse(0.0);
    }


    @Override
    public double adjustPriceByPercent(long id, double byPercent) {
        Product p = productRepository.getProductById(id);
        if (p != null) {
            p.adjustPriceByPercent(byPercent);
            productRepository.updateProduct(p);
            return p.getPrice();
        }
        else {
            return -1;
        }
    }


    @Override
    public Product addToStock(Product product) {
        System.out.println("Service: Product added");
        return productRepository.insertProduct(product);
    }

    @Override
    public void deleteFromStock(long productId) {
        if (productRepository.deleteProduct(productId)) {
            System.out.println("Service: Product deleted");
        }
        else {
            System.out.println("Service: Product NOT deleted");
        }
    }

    @Override
    public void updateStock(Product product) {
        if (productRepository.updateProduct(product)) {
            System.out.println("Service: Product updated");
        } else {
            System.out.println("Service: Product NOT updated");
        }
    }

    @Override
    public Collection<Product> findAllInStock() {
        return productRepository.getAllProducts();
    }


    @Override
    public List<Product> findProductByName(String productName) {
        Stream<Product> stream = productRepository.getAllProducts().stream();
        return stream
            .filter(p -> p.getName().equals(productName))
            .collect(Collectors.toList());
    }
}
