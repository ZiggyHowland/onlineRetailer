package no.dnb.reskill.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void addToStock(String name, double price ) {
        productRepository.addProduct(new Product(name, price));
        System.out.println("Service: Product added");
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
    public Product findProductByName(String productName) {
        for (Product p : productRepository.findAllProducts()) {
            if (p.getName().equalsIgnoreCase(productName)) {
                return p;
            }
        }
        throw new NoSuchElementException("Product name not found in stock");
    }
}
