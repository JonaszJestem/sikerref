package Siker.Allegro;

import Siker.Offer;
import Siker.ResultBuilder;
import com.google.gson.Gson;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;


class AllegroResultBuilder
                extends ResultBuilder
{
    private static final String jsonSelector = "body > div:nth-child(2) > " +
                    " div:nth-child(3) > div > div > div > div > div:nth-child(2) > div:nth-child(2) " +
                    "> div > div:nth-child(3) > div > div > div > div > script:nth-child(4)";

    private final List<Item> items = new ArrayList<>();


    AllegroResultBuilder( Document document )
    {
        offerElements = document.select( jsonSelector );
        String jsonOffers = truncateJson();
        Gson gson = new Gson();
        Items parsedItems = gson.fromJson( jsonOffers, Items.class );
        this.items.addAll( flattenStructure( parsedItems ) );
    }

    private String truncateJson() {
        String jsonOffers = offerElements.html();

        int indexOfObject = jsonOffers.indexOf( '{' );
        int indexOfEndObject = jsonOffers.lastIndexOf("window.__listing_CookieMonster");

        jsonOffers = jsonOffers.substring( indexOfObject, indexOfEndObject).trim();
        int indexOfSemicolon = jsonOffers.lastIndexOf(";");
        jsonOffers = jsonOffers.substring(0, indexOfSemicolon);
        return jsonOffers;
    }


    private List<Item> flattenStructure( Items items )
    {
        List<Item> result = new ArrayList<>();

        for( Group group : items.items.itemsGroups )
        {
            if(group.sponsored) {
                continue;
            }
            result.addAll( group.items );
        }

        return result;
    }


    @Override
    public List<Offer> build()
    {
        List<Offer> offers = new ArrayList<>();

        for( Item item : items )
        {
            offers.add( parseOffer( item ) );
        }

        return offers;
    }


    private Offer parseOffer( Item item )
    {
        String parsedAmount = item.price.normal.amount;
        String parsedUrl = item.url;
        String parsedThumbnail = item.thumbnails.s128;
        String parsedTitle = item.title.text;
        int price = new Siker.Price( parsedAmount ).getValue();

        return new Offer().link( parsedUrl ).price( price ).thumbnail( parsedThumbnail )
                        .title( parsedTitle );
    }

    @Override
    protected int getPrice(Element offerElement) {
        return 0;
    }

    @Override
    protected String getThumbnail(Element offerElement) {
        return null;
    }

    @Override
    protected String getLink(Element offerElement) {
        return null;
    }

    @Override
    protected String getTitle(Element offerElement) {
        return null;
    }
}
