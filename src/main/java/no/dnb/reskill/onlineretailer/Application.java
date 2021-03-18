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


        ProductService service = app.getBean("productServiceUsingJpa", ProductService.class);
        //ProductService service = app.getBean("productServiceImpl", ProductService.class);
        service.doDemo();


    }

}
