package no.dnb.reskill.onlineretailer.models;

import lombok.*;

import javax.persistence.*;

// This is just a POJO, we create new instances of this class "just as normal"
// This will evolve into an Entity class (a class that corresponds to a table in a database)
// ORM => object-relational-mapping -> what to be done by JPA

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product")
public class Product {
    public static final int DUMMY_ID = -1;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    @Column(name="instock")
    private long inStock;


    public Product(String name, double price, long inStock  ) {
        this(DUMMY_ID, name, price, inStock);
    }

    public double adjustPriceByPercent(double percent) {
        return this.price *= 1 + percent/100;
    }

    public String toString() {
        return String.format(
                "Product[id=%d, name='%s' price=%.2f inStock=%d]",
                id, name, price, inStock);
    }
}


