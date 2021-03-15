package no.dnb.reskill.onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("Before running spring application");
        ApplicationContext app = SpringApplication.run(Application.class, args);
        System.out.println("After running spring application");

        ProductService service = app.getBean(ProductService.class);

        // Initial stock
        service.addToStock("Sunglasses", 199.99);
        service.addToStock("Hat", 29.49);
        service.addToStock("Shorts", 39.99);
        service.addToStock("Towel", 10.20);
        service.addToStock("Sandals", 19.00);
        service.addToStock("Sunscreen", 12.49);

        // Delete one product
        service.deleteFromStock(service.findProductByName("Sandals").getId());

        for (Product p : service.findAllInStock()) {
            System.out.println(p.toString());
        }

    }

}
