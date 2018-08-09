package Siker.Allegro;

import Siker.Offer;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AllegroSearcher implements Searcher {

    public List<Offer> search(AllegroSearchProperties searchProperties) {
        String url = searchProperties.getFormattedUrl();
        try {
            Document document = Jsoup.connect(url).get();

            AllegroResultBuilder allegroResultBuilder = new AllegroResultBuilder(document);

            return allegroResultBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
