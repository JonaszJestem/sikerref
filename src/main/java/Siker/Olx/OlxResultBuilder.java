package Siker.Olx;

import Siker.Offer;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class OlxResultBuilder {
    private static final String offersSelector = "#offers_table > tbody > tr > td > div > table > tbody > tr";
    private static final String titleSelector = "td.title-cell > div > h3 > a > strong";
    private static final String linkSelector = "td.title-cell > div > h3 > a";
    private static final String thumbnailsSelector = "td:nth-child(1) > a > img";

    private Elements offerElements;

    OlxResultBuilder(Document document) {
        offerElements = document.select(offersSelector);
    }

    List<Offer> build() {
        List<String> titles = getTitles();
        List<String> links = getLinks();
        List<String> thumbnails = getThumbnails();

        List<Offer> offers = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String thumbnail = thumbnails.get(i);
            String link = links.get(i);
            Offer offer = new Offer().title(title).thumbnail(thumbnail).link(link);
            offers.add(offer);
        }

        return offers;
    }

    private List<String> getThumbnails() {
        Elements thumbnailElements = offerElements.select(thumbnailsSelector);
        List<String> thumbnails = new ArrayList<>();
        for (Element element : thumbnailElements) {
            thumbnails.add(element.attr("src"));
        }
        return thumbnails;
    }

    private List<String> getLinks() {
        Elements linkElements = offerElements.select(linkSelector);
        List<String> links = new ArrayList<>();
        for (Element element : linkElements) {
            links.add(element.attr("href"));
        }
        return links;
    }

    private List<String> getTitles() {
        Elements titleElements = offerElements.select(titleSelector);
        List<String> titles = new ArrayList<>();

        for (Element element : titleElements) {
            titles.add(element.text());
        }

        return titles;
    }
}
