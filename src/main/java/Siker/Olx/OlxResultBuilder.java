package Siker.Olx;

import Siker.Price;
import Siker.ResultBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class OlxResultBuilder
                extends ResultBuilder
{
    private static final String offersSelector =
                    "#offers_table > tbody > tr > td > div > table > tbody > tr";
    private static final String titleSelector = "td:nth-child(2) > div > h3 > a > strong";
    private static final String linkSelector = "td > div > h3 > a";
    private static final String thumbnailsSelector = "td:nth-child(1) > a > img";
    private static final String priceSelector = "td.td-price > div > p > strong";


    OlxResultBuilder( Document document )
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
