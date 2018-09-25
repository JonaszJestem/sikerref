package SpringSiker.Controllers;

import Siker.Offer;
import Siker.SearchProperties;
import Siker.Searcher;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class SikerController
{
    Logger logger = LoggerFactory.getLogger( SikerController.class );
    @Autowired
    private List<Searcher> searchers;
    private Gson gson = new Gson();


    @RequestMapping( value = "/search" )
    public String search( @RequestParam( value = "query" ) String query )
    {
        SearchProperties searchProperties = new SearchProperties();
        searchProperties.withQuery( query );

        try
        {
            List<Offer> search = new ArrayList<>();
            for( Searcher searcher : searchers )
            {
                search.addAll( searcher.search( searchProperties ) );
            }

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
