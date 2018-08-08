package Siker.Olx;

import Siker.Offer;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class OlxSearcher implements Searcher {

    public List<Offer> search(OlxSearchProperties searchProperties) {
        String url = searchProperties.getFormattedUrl();
        try {
            Document document = Jsoup.connect(url).get();

            OlxResultBuilder olxResultBuilder = new OlxResultBuilder(document);

            return olxResultBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
