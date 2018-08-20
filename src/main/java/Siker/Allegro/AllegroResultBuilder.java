package Siker.Allegro;

import Siker.ResultBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


class AllegroResultBuilder
                extends ResultBuilder
{
    private static final String jsonSelector = "html > body > div:nth-child(2) > " +
                    " div:nth-child(3) > div > div > div > div > div:nth-child(2) > div:nth-child(2) " +
                    "> div > div:nth-child(3) > div > div > div > div > script:nth-child(2)";
    private static final String offersSelector =
                    "#offers_table > tbody > tr > td > div > table > tbody > tr";
    private static final String titleSelector = "td.title-cell > div > h3 > a > strong";
    private static final String linkSelector = "td.title-cell > div > h3 > a";
    private static final String thumbnailsSelector = "td:nth-child(1) > a";
    private static final String priceSelector = "td.wwnormal.tright.td-price > div > p";


    AllegroResultBuilder( Document document )
    {

    }


    @Override
    protected String getTitle( Element offer )
    {
        return null;
    }


    @Override
    protected String getLink( Element offer )
    {
        return null;
    }


    @Override
    protected String getThumbnail( Element offer )
    {
        return null;
    }


    @Override
    protected int getPrice( Element offer )
    {
        return 0;
    }
}
