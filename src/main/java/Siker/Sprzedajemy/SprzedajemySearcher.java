package Siker.Sprzedajemy;

import Siker.Offer;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class SprzedajemySearcher
                implements Searcher
{

    public List<Offer> search( SprzedajemySearchProperties searchProperties )
    {
        String url = searchProperties.getFormattedUrl();
        try
        {
            Document document = Jsoup.connect( url ).get();

            SprzedajemyResultBuilder sprzedajemyResultBuilder =
                            new SprzedajemyResultBuilder( document );

            return sprzedajemyResultBuilder.build();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
