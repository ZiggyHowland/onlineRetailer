package no.dnb.reskill.onlineretailer;


// Represent logic to save (DB or memory)
public interface ProductRepository {
    void addProduct(int productId, String productName, double price);
    boolean deleteProduct(int productId);
    void updateProduct(int productId, String productName, double price);
    int findProductId(String productName);
}
