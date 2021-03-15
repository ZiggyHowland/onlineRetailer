package no.dnb.reskill.onlineretailer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void creatingFirstProduct_shouldReturnProductWithId1() {
        // Arrange
        Product p = new Product("Sunglasses", 199.99);

        // Act

        // Assert
        assertEquals(1, p.getId());
        
    }
}