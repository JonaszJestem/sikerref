package Siker.Olx;

import Siker.Offer;
import Siker.SearchProperties;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class OlxSearcher implements Searcher {

    public List<Offer> search( SearchProperties searchProperties ) throws IOException
    {
        String url = searchProperties.getFormattedUrl();
        Document document = Jsoup.connect( url ).get();

        OlxResultBuilder olxResultBuilder = new OlxResultBuilder( document );

        return olxResultBuilder.build();
    }
}
