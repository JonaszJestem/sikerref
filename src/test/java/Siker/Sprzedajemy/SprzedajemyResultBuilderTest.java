package Siker.Sprzedajemy;

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


public class SprzedajemyResultBuilderTest
{
    private SprzedajemyResultBuilder sprzedajemyResultBuilder;
    private Document document;


    @Before
    public void setUp() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( Objects
                        .requireNonNull( classLoader.getResource( "sprzedajemy_offers.html" ) )
                        .getFile() );
        document = Jsoup.parse( file, "UTF-8" );
        sprzedajemyResultBuilder = new SprzedajemyResultBuilder( document );
    }


    @Test
    public void testGettingOffers()
    {
        assertEquals( 3, sprzedajemyResultBuilder.offerElements.size() );
    }


    @Test
    public void testGettingThumbnails()
    {
        Elements offers = sprzedajemyResultBuilder.offerElements;

        assertEquals( "FAKE_IMG_1", sprzedajemyResultBuilder.getThumbnail( offers.get( 0 ) ) );
        assertEquals( "FAKE_IMG_2", sprzedajemyResultBuilder.getThumbnail( offers.get( 1 ) ) );
        assertEquals( "FAKE_IMG_3", sprzedajemyResultBuilder.getThumbnail( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingTitles()
    {
        Elements offers = sprzedajemyResultBuilder.offerElements;

        assertEquals( "FAKE_TITLE_1", sprzedajemyResultBuilder.getTitle( offers.get( 0 ) ) );
        assertEquals( "FAKE_TITLE_2", sprzedajemyResultBuilder.getTitle( offers.get( 1 ) ) );
        assertEquals( "FAKE_TITLE_3", sprzedajemyResultBuilder.getTitle( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingPrices()
    {
        Elements offers = sprzedajemyResultBuilder.offerElements;

        assertEquals( 100, sprzedajemyResultBuilder.getPrice( offers.get( 0 ) ) );
        assertEquals( 200, sprzedajemyResultBuilder.getPrice( offers.get( 1 ) ) );
        assertEquals( 300, sprzedajemyResultBuilder.getPrice( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingLink()
    {
        Elements offers = sprzedajemyResultBuilder.offerElements;

        assertEquals( "FAKE_URL_1", sprzedajemyResultBuilder.getLink( offers.get( 0 ) ) );
        assertEquals( "FAKE_URL_2", sprzedajemyResultBuilder.getLink( offers.get( 1 ) ) );
        assertEquals( "FAKE_URL_3", sprzedajemyResultBuilder.getLink( offers.get( 2 ) ) );
    }


    @Test
    public void testBuildingOffers()
    {
        List<Offer> offers = sprzedajemyResultBuilder.build();

        assertEquals( 3, offers.size() );
    }
}
