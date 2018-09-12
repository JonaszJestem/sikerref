package Siker;

public abstract class SearchProperties
{
    protected String urlFormat;
    protected String query;
    protected String sorting;
    protected int page = 1;


    public String getFormattedUrl()
    {
        return String.format( urlFormat, query, page, sorting );
    }


    public SearchProperties query( String query )
    {
        this.query = query;
        return this;
    }


    public SearchProperties page( int page )
    {
        this.page = page;
        return this;
    }


    public abstract SearchProperties sorting( String sorting );
}
