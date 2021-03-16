package no.dnb.reskill.onlineretailer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This is just a POJO, we create new instances of this class "just as normal"
// This will evolve into an Entity class (a class that corresponds to a table in a database)
// ORM => object-relational-mapping -> what to be done by JPA

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public static final int DUMMY_ID = -1;
    private long id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this(DUMMY_ID, name, price);
    }

    public String toString() {
        return String.format("Product[id=%d, name='%s' price=%.2f]", id, name, price);
    }
}


