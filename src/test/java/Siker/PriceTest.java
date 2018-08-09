package Siker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceTest {
    @Test
    public void testParseNoDigits() {
        int expected = 0;
        String noDigitsString = "Za darmo";

        Price price = new Price(noDigitsString);
        int actualPrice = price.getValue();

        assertThat(actualPrice, is(equalTo(expected)));
    }

    @Test
    public void testParsePriceWithNoCents() {
        int expected = 12300;
        String noDigitsString = "123 zł";

        Price price = new Price(noDigitsString);
        int actualPrice = price.getValue();

        assertThat(actualPrice, is(equalTo(expected)));
    }

    @Test
    public void testParsePriceWithCents() {
        int expected = 12312;
        String noDigitsString = "123,12 zł";

        Price price = new Price(noDigitsString);
        int actualPrice = price.getValue();

        assertThat(actualPrice, is(equalTo(expected)));
    }


    @Test
    public void testParseBigPrice() {
        int expected = 12312300;
        String noDigitsString = "123 123 zł";

        Price price = new Price(noDigitsString);
        int actualPrice = price.getValue();

        assertThat(actualPrice, is(equalTo(expected)));
    }


}