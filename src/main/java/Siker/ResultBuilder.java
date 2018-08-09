package Siker;

import java.util.ArrayList;
import java.util.List;

public abstract class ResultBuilder {
    public List<Offer> build() {
        List<String> titles = getTitles();
        List<String> links = getLinks();
        List<String> thumbnails = getThumbnails();
        List<Integer> prices = getPrice();

        return getOffersList(titles, links, thumbnails, prices);
    }

    protected List<Offer> getOffersList(List<String> titles, List<String> links, List<String> thumbnails, List<Integer> prices) {
        List<Offer> offers = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String thumbnail = thumbnails.get(i);
            String link = links.get(i);
            Integer price = prices.get(i);

            Offer offer = new Offer().title(title).thumbnail(thumbnail).link(link).price(price);
            offers.add(offer);
        }

        return offers;
    }

    abstract protected List<String> getTitles();
    abstract protected List<String> getLinks();
    abstract protected List<String> getThumbnails();
    abstract protected List<Integer> getPrice();
}
