package Siker.Allegro;

import Siker.Offer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.collection.IsEmptyCollection.empty;


public class AllegroSearcherTest
{
    private final String query = "kawa";
    private AllegroSearchProperties searchProperties;

    @Before
    public void setUp() {
        searchProperties = new AllegroSearchProperties().query(query);
    }

    @Test
    public void testSearchNotEmpty() throws IOException {
        AllegroSearcher allegroSearcher = new AllegroSearcher();
        List<Offer> search = allegroSearcher.search( searchProperties );

        assertThat("Search should contain offers", search, is(not(empty())));
    }

    @Test
    public void testSearchOnDifferentPages() throws IOException {
        AllegroSearcher allegroSearcher = new AllegroSearcher();

        for (int i = 1; i < 3; i++) {
            List<Offer> search = allegroSearcher.search( searchProperties.page( i ) );
            assertThat("Search should contain offers", search, is(not(empty())));
        }
    }

    @Test
    public void testSearchPricesAscending() throws IOException {
        AllegroSearcher allegroSearcher = new AllegroSearcher();
        List<Offer> search =
                        allegroSearcher.search( searchProperties.sorting( "PRICE_ASCENDING" ) );

        assertThat("Search should contain offers", search, is(not(empty())));
        int minPrice = 0;
        search = search.subList(5, search.size());
        for (Offer offer : search) {
            int price = offer.getPrice();

            assertThat(price, is(greaterThanOrEqualTo(minPrice)));
            minPrice = price;
        }
    }

    @Test
    public void testSearchPricesDescending() throws IOException {
        AllegroSearcher allegroSearcher = new AllegroSearcher();
        List<Offer> search =
                        allegroSearcher.search( searchProperties.sorting( "PRICE_DESCENDING" ) );

        assertThat("Search should contain offers", search, is(not(empty())));
        int maxPrice = Integer.MAX_VALUE;
        search = search.subList(5, search.size());
        for (Offer offer : search) {
            int price = offer.getPrice();
            assertThat(price, is(lessThanOrEqualTo(maxPrice)));
            maxPrice = price;
        }
    }


}
