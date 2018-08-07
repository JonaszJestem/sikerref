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
            System.out.println(document);
            OlxResultBuilder olxResultBuilder = new OlxResultBuilder(document);
            return olxResultBuilder.getResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
