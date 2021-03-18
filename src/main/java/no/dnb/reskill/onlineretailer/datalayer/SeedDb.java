package no.dnb.reskill.onlineretailer.datalayer;

import no.dnb.reskill.onlineretailer.models.DatabaseSetup;
import no.dnb.reskill.onlineretailer.models.ProductCategory;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DatabaseSetup dbSetup;

    @PostConstruct
    public void init() {
        if (dbSetup.isMySQL()) {
            jdbcTemplate.execute("TRUNCATE Product");
        }
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Sunglasses", ProductCategory.ACCESSORIES.ordinal() , 199.99, 100});
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Hat",ProductCategory.CLOTHES.ordinal(), 29.49, 10} );
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Shorts",ProductCategory.CLOTHES.ordinal(), 39.99, 50} );
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Towel",ProductCategory.ACCESSORIES.ordinal(), 10.20, 30}  );
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Sandals",ProductCategory.SHOES.ordinal(), 19.00, 15} );
        jdbcTemplate.update("INSERT INTO Product (name, productcategory, price, instock) VALUES(?, ?, ?, ?)", new Object[]{"Sunscreen",ProductCategory.ACCESSORIES.ordinal(), 12.49, 125}) ;
    }

}
