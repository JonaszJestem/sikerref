package Siker;

public class SearchProperties {
    protected String urlFormat;
    protected String query;
    protected int page;
    private String sorting;

    public String getFormattedUrl() {
        return String.format(urlFormat, query, page, sorting);
    }
}