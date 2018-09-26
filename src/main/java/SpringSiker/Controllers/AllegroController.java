package SpringSiker.Controllers;

import Siker.Allegro.AllegroSearchProperties;
import Siker.Allegro.AllegroSearcher;
import Siker.Offer;
import Siker.SearchProperties;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class AllegroController
{
    Logger logger = LoggerFactory.getLogger( AllegroController.class );
    @Autowired
    private AllegroSearcher allegroSearcher;
    private Gson gson = new Gson();


    @RequestMapping( value = "/search/allegro", produces = { APPLICATION_JSON_VALUE } )
    public String search( @RequestParam( value = "query" ) String query )
    {
        SearchProperties searchProperties = new AllegroSearchProperties();
        searchProperties.withQuery( query );

        try
        {
            List<Offer> search = allegroSearcher.search( searchProperties );
            return gson.toJson( search );
        }
        catch( IOException exception )
        {
            logger.error( "Couldn't fetch offers!" );
            logger.error( exception.getMessage() );
            return "";
        }
    }
}
