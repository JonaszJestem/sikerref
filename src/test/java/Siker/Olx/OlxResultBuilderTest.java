package Siker.Olx;

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


public class OlxResultBuilderTest
{
    private OlxResultBuilder olxResultBuilder;
    private Document document;


    @Before
    public void setUp() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( Objects.requireNonNull( classLoader.getResource( "olx_offers.html" ) )
                        .getFile() );
        document = Jsoup.parse( file, "UTF-8" );
        olxResultBuilder = new OlxResultBuilder( document );
    }


    @Test
    public void testGettingOffers()
    {
        assertEquals( 3, olxResultBuilder.offerElements.size() );
    }


    @Test
    public void testGettingThumbnails()
    {
        Elements offers = olxResultBuilder.offerElements;

        assertEquals( "FAKE_IMG_1", olxResultBuilder.getThumbnail( offers.get( 0 ) ) );
        assertEquals( "No photo", olxResultBuilder.getThumbnail( offers.get( 1 ) ) );
        assertEquals( "FAKE_IMG_3", olxResultBuilder.getThumbnail( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingTitles()
    {
        Elements offers = olxResultBuilder.offerElements;

        assertEquals( "FAKE_TITLE_1", olxResultBuilder.getTitle( offers.get( 0 ) ) );
        assertEquals( "FAKE_TITLE_2", olxResultBuilder.getTitle( offers.get( 1 ) ) );
        assertEquals( "FAKE_TITLE_3", olxResultBuilder.getTitle( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingPrices()
    {
        Elements offers = olxResultBuilder.offerElements;

        assertEquals( 34500, olxResultBuilder.getPrice( offers.get( 0 ) ) );
        assertEquals( 0, olxResultBuilder.getPrice( offers.get( 1 ) ) );
        assertEquals( 12300, olxResultBuilder.getPrice( offers.get( 2 ) ) );
    }


    @Test
    public void testGettingLink()
    {
        Elements offers = olxResultBuilder.offerElements;

        assertEquals( "FAKE_URL_1", olxResultBuilder.getLink( offers.get( 0 ) ) );
        assertEquals( "FAKE_URL_2", olxResultBuilder.getLink( offers.get( 1 ) ) );
        assertEquals( "FAKE_URL_3", olxResultBuilder.getLink( offers.get( 2 ) ) );
    }


    @Test
    public void testBuildingOffers()
    {
        List<Offer> offers = olxResultBuilder.build();

        assertEquals( 3, offers.size() );
    }
}
