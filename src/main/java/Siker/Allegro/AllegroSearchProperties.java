package Siker.Allegro;

import Siker.SearchProperties;


public class AllegroSearchProperties
                extends SearchProperties
{
    public AllegroSearchProperties()
    {
        urlFormat = "https://allegro.pl/listing?string=%s&order=%s&p=%s";
        sorting = "NEWEST";
        sorting = getSorting( sorting );
    }


    private static String getSorting( String sorting )
    {
        return AllegroSorting.valueOf( sorting ).getSorting();
    }


    public SearchProperties withQuery( String query )
    {
        this.query = query;
        return this;
    }


    public SearchProperties withPage( int page )
    {
        this.page = page;
        return this;
    }


    public SearchProperties withSorting( String sorting )
    {
        this.sorting = getSorting( sorting );
        return this;
    }


    public String getUrl()
    {
        return String.format( urlFormat, query, sorting, page );
    }

}
