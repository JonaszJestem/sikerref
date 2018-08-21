package Siker.Sprzedajemy;

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


public class SprzedajemySearcherTest
{
    private final String query = "kawa";
    private SprzedajemySearchProperties searchProperties;


    @Before
    public void setUp()
    {
        searchProperties = new SprzedajemySearchProperties().query( query );
    }


    @Test
    public void testSearchNotEmpty() throws IOException {
        SprzedajemySearcher sprzedajemySearcher = new SprzedajemySearcher();
        List<Offer> search = sprzedajemySearcher.search( searchProperties );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
    }


    @Test
    public void testSearchOnDifferentPages() throws IOException {
        SprzedajemySearcher sprzedajemySearcher = new SprzedajemySearcher();

        for( int i = 1; i < 10; i++ )
        {
            List<Offer> search = sprzedajemySearcher.search( searchProperties.page( i ) );
            assertThat( "Search should contain offers", search, is( not( empty() ) ) );
        }
    }


    @Test
    public void testSearchPricesAscending() throws IOException {
        SprzedajemySearcher sprzedajemySearcher = new SprzedajemySearcher();
        List<Offer> search =
                        sprzedajemySearcher.search( searchProperties.sorting( "PRICE_ASCENDING" ) );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
        int minPrice = 0;
        search = search.subList( 5, search.size() );
        for( Offer offer : search )
        {
            int price = offer.getPrice();

            assertThat( price, is( greaterThanOrEqualTo( minPrice ) ) );
            minPrice = price;
        }
    }


    @Test
    public void testSearchPricesDescending() throws IOException {
        SprzedajemySearcher sprzedajemySearcher = new SprzedajemySearcher();
        List<Offer> search = sprzedajemySearcher
                        .search( searchProperties.sorting( "PRICE_DESCENDING" ) );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
        int maxPrice = Integer.MAX_VALUE;
        search = search.subList( 5, search.size() );
        for( Offer offer : search )
        {
            int price = offer.getPrice();

            assertThat( price, is( lessThanOrEqualTo( maxPrice ) ) );
            maxPrice = price;
        }
    }

}
