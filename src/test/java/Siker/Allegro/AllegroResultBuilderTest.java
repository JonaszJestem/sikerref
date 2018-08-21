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
        assertEquals( 3, offers.size() );
    }


    @Test
    public void testGettingThumbnails()
    {
        assertEquals( "FAKE_IMG_1", offers.get( 0 ).getThumbnail() );
        assertEquals( "FAKE_IMG_2", offers.get( 1 ).getThumbnail() );
        assertEquals( "FAKE_IMG_3", offers.get( 2 ).getThumbnail() );
    }


    @Test
    public void testGettingTitles()
    {
        assertEquals( "FAKE_TITLE_1", offers.get( 0 ).getTitle() );
        assertEquals( "FAKE_TITLE_2", offers.get( 1 ).getTitle() );
        assertEquals( "FAKE_TITLE_3", offers.get( 2 ).getTitle() );
    }


    @Test
    public void testGettingPrices()
    {
        assertEquals( 100, offers.get( 0 ).getPrice() );
        assertEquals( 200, offers.get( 1 ).getPrice() );
        assertEquals( 300, offers.get( 2 ).getPrice() );
    }


    @Test
    public void testGettingLink()
    {
        assertEquals( "FAKE_URL_1", offers.get( 0 ).getLink() );
        assertEquals( "FAKE_URL_2", offers.get( 1 ).getLink() );
        assertEquals( "FAKE_URL_3", offers.get( 2 ).getLink() );
    }

}
