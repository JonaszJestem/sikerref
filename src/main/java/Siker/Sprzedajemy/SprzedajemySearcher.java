package Siker.Sprzedajemy;

import Siker.Offer;
import Siker.SearchProperties;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class SprzedajemySearcher
                implements Searcher
{

    public List<Offer> search( SearchProperties searchProperties ) throws IOException
    {
        String url = searchProperties.getUrl();
        Document document = Jsoup.connect( url ).get();

        SprzedajemyResultBuilder sprzedajemyResultBuilder =
                        new SprzedajemyResultBuilder( document );

        return sprzedajemyResultBuilder.build();
    }
}
