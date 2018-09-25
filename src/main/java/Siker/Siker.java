package Siker;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Siker
                implements Searcher
{
    List<Searcher> searchers;


    @Autowired
    public void setSearchers( List<Searcher> searchers )
    {
        this.searchers = searchers;
    }


    @Override
    public List<Offer> search( SearchProperties searchProperties ) throws IOException
    {
        List<Offer> offers = new ArrayList<>();

        for( Searcher searcher : searchers )
        {
            System.out.println( searcher );
            List<Offer> searchResults = searcher.search( searchProperties );
            offers.addAll( searchResults );
        }

        return offers;
    }
}
