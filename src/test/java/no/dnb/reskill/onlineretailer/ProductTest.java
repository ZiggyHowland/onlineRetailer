package no.dnb.reskill.onlineretailer;

import no.dnb.reskill.onlineretailer.models.Product;
import no.dnb.reskill.onlineretailer.models.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void creatingANewProduct_shouldReturnProductWithIdMinus1() {
        // Arrange
        Product p = new Product("Sunglasses", ProductCategory.ACCESSORIES, 199.99, 10);

        // Act

        // Assert
        assertEquals(-1, p.getId());
        
    }

    @Test void adjustingProductPrice_with10PercentDown_shouldReturnLowerPrice() {
        Product p = new Product("Test", ProductCategory.ACCESSORIES, 100, 0);
        p.adjustPriceByPercent(-10);
        assertEquals(90, p.getPrice());
    }

    @Test void adjustingProductPrice_with10PercentUp_shouldReturnHigherPrice() {
        Product p = new Product("Test", ProductCategory.ACCESSORIES, 100, 0);
        p.adjustPriceByPercent(10);
        assertEquals(110, p.getPrice());
    }
}