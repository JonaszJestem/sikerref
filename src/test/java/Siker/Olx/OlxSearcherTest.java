package Siker.Olx;

import Siker.Offer;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;


public class OlxSearcherTest {
    @Test
    public void testSearchNotEmpty() {
        OlxSearcher olxSearcher = new OlxSearcher();
        OlxSearchProperties searchProperties = new OlxSearchProperties("kawa", "1", "PRICE_ASCENDING");
        List<Offer> search = olxSearcher.search(searchProperties);

        assertThat("Search should contain offers", search, is(not(empty())));
    }
}