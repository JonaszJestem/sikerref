package Siker.Sprzedajemy;

import Siker.Price;
import Siker.ResultBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class SprzedajemyResultBuilder
                extends ResultBuilder
{
    private static final String offersSelector = "section.offers > ul > li > article > ul";
    private static final String titleSelector = "li:nth-child(2) > h2 > a";
    private static final String linkSelector = "li:nth-child(2) > h2 > a";
    private static final String thumbnailsSelector = "li:first-child > a > span > img";
    private static final String priceSelector = "li:nth-child(2) > div > span";


    SprzedajemyResultBuilder( Document document )
    {
        offerElements = document.select( offersSelector );
    }


    public String getThumbnail( Element offer )
    {
        Elements probableThumbnail = offer.select( thumbnailsSelector );
        if( probableThumbnail.hasAttr( "src" ) )
        {
            return probableThumbnail.attr( "src" );
        }
        else
        {
            return "No photo";
        }
    }


    public String getTitle( Element offer )
    {
        Elements titleElements = offer.select( titleSelector );

        return titleElements.text();
    }


    public int getPrice( Element offer )
    {
        Elements titleElements = offer.select( priceSelector );
        String price = titleElements.text();
        return new Price( price ).getValue();
    }


    public String getLink( Element offer )
    {
        Elements linkElements = offer.select( linkSelector );
        return linkElements.attr( "href" );
    }
}
