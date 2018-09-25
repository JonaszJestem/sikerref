package Siker;

public class SearchProperties
{
    public String urlFormat;
    public String query;
    public String sorting = "NEWEST";
    public int page = 1;


    public String getUrl()
    {
        return String.format( urlFormat, query, page, sorting );
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
        return this;
    }


    @Override
    public String toString()
    {
        return "SearchProperties{" + "urlFormat='" + urlFormat + '\'' + ", withQuery='" + query +
                        '\'' + ", withSorting='" + sorting + '\'' + ", withPage=" + page + '}';
    }
}
