package Siker.Sprzedajemy;

import Siker.SearchProperties;


public class SprzedajemySearchProperties
                extends SearchProperties
{
    public SprzedajemySearchProperties()
    {
        urlFormat = "https://sprzedajemy.pl/szukaj?inp_text=%s&sort=%s&items_per_page=60&offset=%s";
        sorting = "NEWEST";
        sorting = getSorting( sorting );
    }


    private static String getSorting( String sorting )
    {
        return SprzedajemySorting.valueOf( sorting ).getSorting();
    }


    public SprzedajemySearchProperties withQuery( String query )
    {
        this.query = query;
        return this;
    }


    public SprzedajemySearchProperties withPage( int page )
    {
        this.page = page * 60;
        return this;
    }


    public SprzedajemySearchProperties withSorting( String sorting )
    {
        this.sorting = SprzedajemySorting.valueOf( sorting ).getSorting();
        return this;
    }


    public String getUrl()
    {
        return String.format( urlFormat, query, sorting, page );
    }
}
