package Siker.Olx;

import Siker.SearchProperties;

public class OlxSearchProperties extends SearchProperties {
    public OlxSearchProperties() {
        urlFormat = "https://www.olx.pl/oferty/q-%s/?search[order]=%s&withPage=%s";
        sorting = "NEWEST";
        sorting = getSorting( sorting );
    }


    private static String getSorting( String sorting )
    {
        return OlxSorting.valueOf( sorting ).getSorting();
    }


    public OlxSearchProperties withQuery( String query )
    {
        this.query = query;
        return this;
    }


    public OlxSearchProperties withPage( int page )
    {
        this.page = page;
        return this;
    }


    public OlxSearchProperties withSorting( String sorting )
    {
        this.sorting = OlxSorting.valueOf(sorting).getSorting();
        return this;
    }


    public String getUrl()
    {
        return String.format(urlFormat, query, sorting, page);
    }

}
