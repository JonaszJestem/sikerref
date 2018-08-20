package Siker.Allegro;

import Siker.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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


    @Before
    public void setUp() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( Objects
                        .requireNonNull( classLoader.getResource( "allegro_offers.html" ) )
                        .getFile() );
        document = Jsoup.parse( file, "UTF-8" );
        allegroResultBuilder = new AllegroResultBuilder( document );
    }


    @Test
    public void testGettingOffers()
    {
        assertEquals( 3, allegroResultBuilder.offerElements.size() );
    }


    @Test
    public void testGettingThumbnails()
    {
        Elements offers = allegroResultBuilder.offerElements;

        assertEquals( "FAKE_IMG_1", allegroResultBuilder.getThumbnail( offers.get( 0 ) ) );
        assertEquals( "No photo", allegroResultBuilder.getThumbnail( offers.get( 1 ) ) );
        assertEquals( "FAKE_IMG_3", allegroResultBuilder.getThumbnail( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingTitles()
    {
        Elements offers = allegroResultBuilder.offerElements;

        assertEquals( "FAKE_TITLE_1", allegroResultBuilder.getTitle( offers.get( 0 ) ) );
        assertEquals( "FAKE_TITLE_2", allegroResultBuilder.getTitle( offers.get( 1 ) ) );
        assertEquals( "FAKE_TITLE_3", allegroResultBuilder.getTitle( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingPrices()
    {
        Elements offers = allegroResultBuilder.offerElements;

        assertEquals( 34500, allegroResultBuilder.getPrice( offers.get( 0 ) ) );
        assertEquals( 0, allegroResultBuilder.getPrice( offers.get( 1 ) ) );
        assertEquals( 12300, allegroResultBuilder.getPrice( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingLink()
    {
        Elements offers = allegroResultBuilder.offerElements;

        assertEquals( "FAKE_URL_1", allegroResultBuilder.getLink( offers.get( 0 ) ) );
        assertEquals( "FAKE_URL_2", allegroResultBuilder.getLink( offers.get( 1 ) ) );
        assertEquals( "FAKE_URL_3", allegroResultBuilder.getLink( offers.get( 2 ) ) );
    }


    @Test
    public void testBuildingOffers()
    {
        List<Offer> offers = allegroResultBuilder.build();

        assertEquals( 3, offers.size() );
    }
}
