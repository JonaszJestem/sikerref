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
    private SprzedajemySearcher sprzedajemySearcher;


    @Before
    public void setUp()
    {
        searchProperties = new SprzedajemySearchProperties().withQuery( query );
        sprzedajemySearcher = new SprzedajemySearcher();
    }


    @Test
    public void testSearchNotEmpty() throws IOException
    {
        List<Offer> search = sprzedajemySearcher.search( searchProperties );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
    }


    @Test
    public void testSearchOnDifferentPages() throws IOException
    {
        for( int i = 1; i < 10; i++ )
        {
            List<Offer> search = sprzedajemySearcher.search( searchProperties.withPage( i ) );
            assertThat( "Search should contain offers", search, is( not( empty() ) ) );
        }
    }


    @Test
    public void testSearchPricesAscending() throws IOException
    {
        List<Offer> search = sprzedajemySearcher
                        .search( searchProperties.withSorting( "PRICE_ASCENDING" ) );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
        int prevPrice = 0;
        search = search.subList( 5, search.size() );

        for( Offer offer : search )
        {
            int price = offer.getPrice();

            assertThat( price, is( greaterThanOrEqualTo( prevPrice ) ) );
            prevPrice = price;
        }
    }


    @Test
    public void testSearchPricesDescending() throws IOException
    {
        SprzedajemySearcher sprzedajemySearcher = new SprzedajemySearcher();
        List<Offer> search = sprzedajemySearcher
                        .search( searchProperties.withSorting( "PRICE_DESCENDING" ) );

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
