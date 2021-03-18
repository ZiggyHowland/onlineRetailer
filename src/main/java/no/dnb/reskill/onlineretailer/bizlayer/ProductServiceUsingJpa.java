package no.dnb.reskill.onlineretailer.bizlayer;

import no.dnb.reskill.onlineretailer.models.VatSetup;
import no.dnb.reskill.onlineretailer.datalayer.ProductRepositorySpringData;
import no.dnb.reskill.onlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service("productService")
public class ProductServiceUsingJpa implements ProductService {
    private final ProductRepositorySpringData productRepository; // If autowiring field, then Mocking upon test - will be possible (since private)

    @Autowired
    private VatSetup vatSetup;


    @Autowired // TODO I would like to read the qualifier value from the properties-file. Is that possible?
    public ProductServiceUsingJpa(@Qualifier("productRepositorySpringData") ProductRepositorySpringData productRepository) {
        this.productRepository = productRepository;
    }


    public void doDemo() {
        displayProducts("All products", productRepository.findAll());
        displayMessage("Total value", String.format("All products in stock: %.2f", calculateTotalValue()));
        displayLowStockProducts(5);
        displayAveragePrice();
        adjustPriceByPercent(2, -23);
        adjustPriceByPercent(4, 9);
        displayProducts("All products after price adjustment", productRepository.findAll());
        displayProducts("Search for 'Towel'", findProductByName("Towel"));
        displayHeader("Deleting id #2");
        deleteFromStock(2);
        displayProducts("All products after delete", findAllInStock());
    }


    @Override
    public double calculateTotalValue() {
        double totalValue = 0;
        for (Product p: productRepository.findAll()) {
            totalValue += p.getPrice() * p.getInStock();
        }
        return totalValue;

    }

    public void displayLowStockProducts(long threshold) {
        displayProducts("Low stock products", productRepository.findProductsBelowStockThreshold(threshold));
    }

    @Override
    public Collection<Product> getLowStockProducts(long threshold) {
        return null;
    }

    public void displayAveragePrice() {
        double sumPrice = 0;
        int count = 0;
        for (Product p: productRepository.findAll()) {
            sumPrice += p.getPrice();
        }
        displayMessage("Average product price", String.format("Average: %.2f", sumPrice/count));
    }


    @Override
    public double getAveragePrice() {
        return 0;
    }


    @Override
    public double adjustPriceByPercent(long id, double byPercent) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()) {
            p.get().adjustPriceByPercent(byPercent);
            productRepository.save(p.get());
            return p.get().getPrice();
        }
        else {
            return -1;
        }
    }


    @Override
    public double getVatByPrice(double price) {
        return vatSetup.getVatPercentageByPrice(price);
    }




    @Override
    public Product addToStock(Product product) {
        System.out.println("Service: Product added");
        return productRepository.save(product);
    }

    @Override
    public void deleteFromStock(long productId) {
        productRepository.deleteById(productId);
        System.out.println("Service: Product deleted");
    }

    @Override
    public void updateStock(Product product) {
        productRepository.save(product);
        System.out.println("Service: Product updated");
    }

    @Override
    public Collection<Product> findAllInStock() {
        Collection<Product> result = new ArrayList<>();
        for (Product p: productRepository.findAll()) {
            result.add(p);
        }
        return result;
    }


    @Override
    public List<Product> findProductByName(String productName) {
        return productRepository.findByName(productName);
    }







    private void displayMessage(String header, String message) {
        displayHeader(header);
        System.out.println(message);
    }
    
    private void displayProducts(String header, Iterable<Product> products) {
        displayHeader(header);
        for (Product p: products) {
            System.out.println(p);
        }
    }

    private void displayHeader(String header) {
        System.out.printf("%n-----%s------%n", header);
    }
}
