package no.dnb.reskill.onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("Before running spring application");
        ApplicationContext app = SpringApplication.run(Application.class, args);
        System.out.println("After running spring application");

        ProductService service = app.getBean(ProductService.class);

        // Initial stock
        service.addToStock(new Product("Sunglasses", 199.99));
        service.addToStock(new Product("Hat", 29.49));
        service.addToStock(new Product("Shorts", 39.99));
        service.addToStock(new Product("Towel", 10.20));
        service.addToStock(new Product("Sandals", 19.00));
        service.addToStock(new Product("Sunscreen", 12.49));

        // Delete products matching given name
        Stream<Product> stream = service.findProductByName("Sandals").stream();
        stream.forEach(p -> service.deleteFromStock(p.getId()));


        for (Product p : service.findAllInStock()) {
            System.out.println(p.toString());
        }

    }

}
