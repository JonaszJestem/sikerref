package Siker;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;


public class SikerTest
{
    private final String query = "kawa";
    private SearchProperties searchProperties;


    @Before
    public void setUp()
    {
        searchProperties = new SearchProperties().withQuery( query );
    }


    @Test
    public void testSearchNotEmpty() throws IOException
    {
        Siker siker = new Siker();
        List<Offer> search = siker.search( searchProperties );

        assertThat( "Search should contain offers", search, is( not( empty() ) ) );
    }
}
