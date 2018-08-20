package Siker;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public abstract class ResultBuilder
{
    public Elements offerElements;


    public List<Offer> build()
    {
        List<Offer> offers = new ArrayList<>();

        for( Element offerElement : offerElements )
        {
            Offer offer = parseOffer( offerElement );
            offers.add( offer );
        }

        return offers;
    }


    private Offer parseOffer( Element offerElement )
    {
        String title = getTitle( offerElement );
        String link = getLink( offerElement );
        String thumbnail = getThumbnail( offerElement );
        int price = getPrice( offerElement );

        return new Offer().title( title ).thumbnail( thumbnail ).link( link ).price( price );
    }


    protected abstract String getTitle( Element offer );

    protected abstract String getLink( Element offer );

    protected abstract String getThumbnail( Element offer );

    protected abstract int getPrice( Element offer );
}
