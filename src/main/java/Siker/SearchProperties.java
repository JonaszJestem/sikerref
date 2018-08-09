package Siker;


public class SearchProperties {
    protected String urlFormat;
    protected String query;
    protected String sorting;
    protected int page = 1;

    public String getFormattedUrl() {
        return String.format(urlFormat, query, page, sorting);
    }
}