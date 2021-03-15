package no.dnb.reskill.onlineretailer;

public class Product {
    private static int nextId = 0;
    private int id;
    private String name;
    private double price;


    public Product(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return String.format("Product[id=%d, name='%s' price=%.2f", id, name, price);
    }
}

