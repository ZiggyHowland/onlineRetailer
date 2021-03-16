package no.dnb.reskill.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public int addToStock(Product product) {
        System.out.println("Service: Product added");
        return productRepository.addProduct(product);
    }

    @Override
    public void deleteFromStock(int productId) {
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
        return productRepository.findAllProducts();
    }


    @Override
    public List<Product> findProductByName(String productName) {
        Stream<Product> stream = productRepository.findAllProducts().stream();
        return stream
            .filter(p -> p.getName().equals(productName))
            .collect(Collectors.toList());
    }
}
