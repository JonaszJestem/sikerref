package Siker.Olx;

import Siker.Offer;
import Siker.Price;
import Siker.ResultBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class OlxResultBuilder extends ResultBuilder {
    private static final String offersSelector = "#offers_table > tbody > tr > td > div > table > tbody > tr";
    private static final String titleSelector = "td.title-cell > div > h3 > a > strong";
    private static final String linkSelector = "td.title-cell > div > h3 > a";
    private static final String thumbnailsSelector = "td:nth-child(1) > a";
    private static final String priceSelector = "td.wwnormal.tright.td-price > div > p";

    private Elements offerElements;

    OlxResultBuilder(Document document) {
        offerElements = document.select(offersSelector);
        offerElements.removeIf((offer) -> offer.select(priceSelector).isEmpty());
    }

    protected List<String> getThumbnails() {
        Elements thumbnailElements = offerElements.select(thumbnailsSelector);
        List<String> thumbnails = new ArrayList<>();
        for (Element element : thumbnailElements) {
            if(element.hasAttr("src")) {
                String imageSource = element.attr("src");
                thumbnails.add(imageSource);
            }
            else {
                thumbnails.add("No photo");
            }
        }
        return thumbnails;
    }

    protected List<Integer> getPrice() {
        Elements priceElements = offerElements.select(priceSelector);

        List<Integer> prices = new ArrayList<>();
        for (Element element : priceElements) {
            Price p = new Price(element.text());
            prices.add(p.getValue());
        }

        return prices;
    }

    protected List<String> getLinks() {
        Elements linkElements = offerElements.select(linkSelector);
        List<String> links = new ArrayList<>();
        for (Element element : linkElements) {
            links.add(element.attr("href"));
        }
        return links;
    }

    protected List<String> getTitles() {
        Elements titleElements = offerElements.select(titleSelector);
        List<String> titles = new ArrayList<>();

        for (Element element : titleElements) {
            titles.add(element.text());
        }

        return titles;
    }
}
