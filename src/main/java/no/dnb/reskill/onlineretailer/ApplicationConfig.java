package no.dnb.reskill.onlineretailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public VatSetup vatSetup() {
        System.out.println("Before adding VAT policies");
        VatSetup vs = new VatSetup();
        vs.addVatPolicy(new VatPolicy(0, 100, 25 ));
        vs.addVatPolicy(new VatPolicy(101, 10_000, 27 ));
        vs.addVatPolicy(new VatPolicy(10_001, VatPolicy.NO_UPPER_LIMIT, 50 ));
        return vs;
    }

}
