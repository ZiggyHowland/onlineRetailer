package no.dnb.reskill.onlineretailer;

import no.dnb.reskill.onlineretailer.bizlayer.ProductService;
import no.dnb.reskill.onlineretailer.models.Product;
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

        // Delete products matching given name
        Stream<Product> stream = service.findProductByName("Sandals").stream();
        stream.forEach(p -> service.deleteFromStock(p.getId()));

        // List all the products
        service.findAllInStock()
                .stream()
                .forEach(p -> System.out.println(p));

        System.out.println("\n-------------------\n");
        System.out.println("Total value of inventory: " + service.calculateTotalValue());

        System.out.println("\n-------------------\n");
        service.findProductByName("Sunglasses")
                .stream()
                .forEach(p -> System.out.printf("%s cost %.2f, VAT is %.2f", p.getName(), p.getPrice(), service.getVatByPrice(p.getPrice())));



    }

}
