package Siker.Allegro;

import Siker.ResultBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

class AllegroResultBuilder extends ResultBuilder {
    private static final String offersSelector = "#offers_table > tbody > tr > td > div > table > tbody > tr";
    private static final String titleSelector = "td.title-cell > div > h3 > a > strong";
    private static final String linkSelector = "td.title-cell > div > h3 > a";
    private static final String thumbnailsSelector = "td:nth-child(1) > a";
    private static final String priceSelector = "td.wwnormal.tright.td-price > div > p";

    private Elements offerElements;

    AllegroResultBuilder(Document document) {
        offerElements = document.select(offersSelector);
        offerElements.removeIf((offer) -> offer.select(priceSelector).isEmpty());
    }

    protected List<String> getThumbnails() {
        return null;
    }

    protected List<Integer> getPrice() {
        return null;
    }

    protected List<String> getLinks() {
        return null;

    }

    protected List<String> getTitles() {
        return null;

    }
}
