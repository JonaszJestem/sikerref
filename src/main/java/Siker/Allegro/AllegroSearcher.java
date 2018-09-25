package Siker.Allegro;

import Siker.Offer;
import Siker.SearchProperties;
import Siker.Searcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class AllegroSearcher
                implements Searcher
{
    Logger logger = LoggerFactory.getLogger( AllegroSearcher.class );

    public List<Offer> search( SearchProperties searchProperties ) throws IOException
    {
        logger.info( "Searching for: {}", searchProperties );
        String url = searchProperties.getUrl();
        Document document = Jsoup.connect( url ).get();

        AllegroResultBuilder allegroResultBuilder = new AllegroResultBuilder( document );

        return allegroResultBuilder.build();
    }
}
