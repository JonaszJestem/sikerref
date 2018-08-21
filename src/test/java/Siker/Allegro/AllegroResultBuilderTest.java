package Siker.Allegro;

import Siker.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;


public class AllegroResultBuilderTest
{
    private AllegroResultBuilder allegroResultBuilder;
    private Document document;
    private List<Offer> offers;


    @Before
    public void setUp() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( Objects
                        .requireNonNull( classLoader.getResource( "allegro_offers.html" ) )
                        .getFile() );
        document = Jsoup.parse( file, "UTF-8" );
        allegroResultBuilder = new AllegroResultBuilder( document );
        offers = allegroResultBuilder.build();
    }


    @Test
    public void testGettingOffers()
    {
        assertEquals( 2, offers.size() );
    }


    @Test
    public void testGettingThumbnails()
    {
        assertEquals( "FAKE_IMG_2", offers.get( 0 ).getThumbnail() );
        assertEquals( "FAKE_IMG_3", offers.get( 1 ).getThumbnail() );
    }


    @Test
    public void testGettingTitles()
    {
        assertEquals( "FAKE_TITLE_2", offers.get( 0 ).getTitle() );
        assertEquals( "FAKE_TITLE_3", offers.get( 1 ).getTitle() );
    }


    @Test
    public void testGettingPrices()
    {
        assertEquals( 200, offers.get( 0 ).getPrice() );
        assertEquals( 300, offers.get( 1 ).getPrice() );
    }


    @Test
    public void testGettingLink()
    {
        assertEquals( "FAKE_URL_2", offers.get( 0 ).getLink() );
        assertEquals( "FAKE_URL_3", offers.get( 1 ).getLink() );
    }

}
