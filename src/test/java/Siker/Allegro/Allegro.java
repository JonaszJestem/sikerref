package Siker.Allegro;

import Siker.Offer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.collection.IsEmptyCollection.empty;


public class Allegro {

    private final String query = "kawa";
    private AllegroSearchProperties searchProperties;

    @Before
    public void setUp() {
        searchProperties = new AllegroSearchProperties().query(query);
    }

    @Test
    public void testSearchNotEmpty() {
        AllegroSearcher AllegroSearcher = new AllegroSearcher();
        List<Offer> search = AllegroSearcher.search(searchProperties);

        assertThat("Search should contain offers", search, is(not(empty())));
    }

    @Test
    public void testSearchOnDifferentPages() {
        AllegroSearcher AllegroSearcher = new AllegroSearcher();

        for (int i = 1; i < 3; i++) {
            List<Offer> search = AllegroSearcher.search(searchProperties.page(i));
            assertThat("Search should contain offers", search, is(not(empty())));
        }
    }

    @Test
    public void testSearchPricesAscending() {
        AllegroSearcher AllegroSearcher = new AllegroSearcher();
        List<Offer> search = AllegroSearcher.search(searchProperties.sorting("PRICE_ASCENDING"));

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
    public void testSearchPricesDescending() {
        AllegroSearcher AllegroSearcher = new AllegroSearcher();
        List<Offer> search = AllegroSearcher.search(searchProperties.sorting("PRICE_DESCENDING"));

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