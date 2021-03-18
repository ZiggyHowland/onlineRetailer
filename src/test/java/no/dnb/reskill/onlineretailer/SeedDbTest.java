package no.dnb.reskill.onlineretailer;

import no.dnb.reskill.onlineretailer.models.ProductCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SeedDbTest {
    @Test
    public void test() {
        Object[] list = new Object[6];

        list[0] = new Object[]{"Sunglasses", ProductCategory.ACCESSORIES.ordinal() , 199.99, 100};
        list[1] = new Object[]{"Hat",ProductCategory.CLOTHES.ordinal(), 29.49, 10};
        list[2] = new Object[]{"Shorts",ProductCategory.CLOTHES.ordinal(), 39.99, 50};
        list[3] = new Object[]{"Towel",ProductCategory.ACCESSORIES.ordinal(), 10.20, 30};
        list[4] = new Object[]{"Sandals",ProductCategory.SHOES.ordinal(), 19.00, 15};
        list[5] = new Object[]{"Sunscreen",ProductCategory.ACCESSORIES.ordinal(), 12.49, 125};

        System.out.println(list[0]);
    }


}